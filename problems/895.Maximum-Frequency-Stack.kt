class FreqStack() {
    
    //value to frequency
    val frequencyMap = mutableMapOf<Int, Int>()
    
    //frequency to item
    val frequencyToItems = mutableMapOf<Int, LinkedList<Int>>()
    
    val frequencyHeap = PriorityQueue<Int> { element1, element2 -> 
        element2 - element1
    }

    fun push(x: Int) {
        val nextFrequency = frequencyMap.getOrElse(x, { 0 }) + 1
        val itemsList = frequencyToItems.getOrElse(nextFrequency, { LinkedList<Int>() })
        itemsList.addLast(x)
        
        frequencyMap.set(x, nextFrequency)
        frequencyToItems.set(nextFrequency, itemsList)
        frequencyHeap.add(nextFrequency)
    }

    fun pop(): Int {
        val frequency = frequencyHeap.poll()
        val item = frequencyToItems.get(frequency)!!.pollLast()
        frequencyMap.set(item, frequencyMap.getOrElse(item, { 1 }) - 1)
        return item
    }

}

/**
 * Your FreqStack object will be instantiated and called as such:
 * var obj = FreqStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 */
