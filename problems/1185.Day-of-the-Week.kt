/**
 * Runtime: 120 ms, faster than 100.00% of Kotlin online submissions for Day of the Week.
 * Memory Usage: 33.2 MB, less than 66.67% of Kotlin online submissions for Day of the Week.
 */

class Solution {
    fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
        val daysPassedInPreviousYears = daysOnYearsUpUntilThis(year)
        val daysPassedInPreviousMonths = daysOnMonthUpUntilThis(month, year)
        val daysPassedFromBeginng = daysPassedInPreviousYears + daysPassedInPreviousMonths + day - 1
        val dayIndex = (daysPassedFromBeginng + FIRST_DAY_INDEX) % DAYS_OF_WEEK.size
        return DAYS_OF_WEEK[dayIndex]
    }
    
    fun daysOnYearsUpUntilThis(year: Int): Int {
        val yearsPassedByNow = year - FIRST_COMMON_YEAR
        val leapYearsPassedByNow = (year - FIRST_LEAP_YEAR) / 4 + if ((year - FIRST_LEAP_YEAR) % 4 > 0) 1 else 0
        
        return yearsPassedByNow * DAYS_IN_COMMON_YEAR + leapYearsPassedByNow
    }
    
    fun daysOnMonthUpUntilThis(month: Int, year: Int): Int {
        var daysPassed = 0
        for (i in 0 until month - 1) {
            daysPassed += DAYS_IN_MONTH[i]
        }
        if (month > 2 && (year % 100 != 0 || year % 400 == 0) && year % 4 == 0) {
            daysPassed++
        }
        return daysPassed
    }
    
    companion object {
        const val DAYS_IN_COMMON_YEAR = 365
        const val FIRST_LEAP_YEAR = 1972
        const val FIRST_COMMON_YEAR = 1970
        val DAYS_IN_MONTH = intArrayOf(31,28,31,30,31,30,31,31,30,31,30,31)
        val DAYS_OF_WEEK = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
        const val FIRST_DAY_INDEX = 4
    }
    
}
