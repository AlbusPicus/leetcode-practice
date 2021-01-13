/**
 * Runtime: 952 ms, faster than 100.00% of Kotlin online submissions for Delivering Boxes from Storage to Ports.
 * Memory Usage: 94.4 MB, less than 75.00% of Kotlin online submissions for Delivering Boxes from Storage to Ports.
 */
class Solution {
    fun boxDelivering(boxes: Array<IntArray>, portsCount: Int, maxBoxes: Int, maxWeight: Int): Int {
        val boxesCount = boxes.size
        var trips = 0
        var lastBoxShippableIndex = 0
        var lastPortShippingIndex = 0
        var minTripsForBox = IntArray(boxesCount + 1) { 0 }
        var loadedBoxes = 0
        var loadedWeight = 0
        for (i in 0 until boxesCount) {
            while (lastBoxShippableIndex < boxesCount 
                   && loadedBoxes < maxBoxes 
                   && loadedWeight + boxes[lastBoxShippableIndex][1] <= maxWeight) {
                loadedBoxes += 1
                loadedWeight += boxes[lastBoxShippableIndex][1]
                if (lastBoxShippableIndex == 0 || boxes[lastBoxShippableIndex][0] != boxes[lastBoxShippableIndex - 1][0]) {
                    lastPortShippingIndex = lastBoxShippableIndex
                    trips++
                }
                lastBoxShippableIndex++
                minTripsForBox[lastBoxShippableIndex] = 200000
            }
            minTripsForBox[lastBoxShippableIndex] = Math.min(minTripsForBox[lastBoxShippableIndex], minTripsForBox[i] + trips + 1)
            minTripsForBox[lastPortShippingIndex] = Math.min(minTripsForBox[lastPortShippingIndex], minTripsForBox[i] + trips)
            loadedBoxes -= 1
            loadedWeight -= boxes[i][1]
            if (i == boxesCount - 1 || boxes[i][0] != boxes[i + 1][0]) {
                trips--;
            }
        }
        return minTripsForBox[boxesCount]
    }
    
}
