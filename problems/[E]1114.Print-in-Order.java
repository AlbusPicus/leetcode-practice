import java.util.EnumSet;

/**
 * Runtime: 10 ms, faster than 94.45% of Java online submissions for Print in Order.
 * Memory Usage: 38.6 MB, less than 47.61% of Java online submissions for Print in Order.
 */
class Foo {
    
  private Set<Options> options = EnumSet.allOf(Options.class);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(options) {
        
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            
            options.remove(Options.FIRST);
            options.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        synchronized(options) {
            while (options.contains(Options.FIRST)) {
                options.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            
            options.remove(Options.SECOND);
            options.notifyAll();
            
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        synchronized(options) {
            while (options.contains(Options.SECOND)) {
                options.wait();
            }
            
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            
            options.remove(Options.THIRD);
            options.notifyAll();
            
        }
    }
    
    static enum Options {
        FIRST,
        SECOND,
        THIRD
    }
}
