class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        return placeQueens(n, 0, emptySet<Int>(), emptySet<Int>(), emptySet<Int>())
    }
    
    fun placeQueens(
        boardSize: Int, 
        lineToSearch: Int, 
        blockedRows: Set<Int>,
        leftBlockedCells: Set<Int>,
        rightBlockedCells: Set<Int>
    ): List<LinkedList<String>> {
        var result = mutableListOf<LinkedList<String>>()
        for (columnIndex in 0 until boardSize) {
            val isAvailableIndex = isAvailableIndex(columnIndex, blockedRows, leftBlockedCells, rightBlockedCells)
            if (isAvailableIndex) {
                if (lineToSearch < boardSize - 1) {
                    val nextLevelLeftBlockedCells = generateBlockedCellsForNextLine(
                        leftBlockedCells,
                        columnIndex - 1, 
                        -1
                    ) { index -> index - 1 }
                    val nextLevelRightBlockedCells = generateBlockedCellsForNextLine(
                        rightBlockedCells,
                        columnIndex + 1, 
                        boardSize
                    ) { index -> index + 1 }
                    
                    val nextLevelBlockedRows = blockedRows + columnIndex
                    
                    val successPaths = placeQueens(
                        boardSize, 
                        lineToSearch + 1, 
                        nextLevelBlockedRows,
                        nextLevelLeftBlockedCells,
                        nextLevelRightBlockedCells
                    )
                    
                    appendResultToList(boardSize, columnIndex, result, successPaths)
                } else {
                    val rowAsList = LinkedList<String>()
                    rowAsList.add(getCurrentRowString(boardSize, columnIndex))
                    result.add(rowAsList)
                }
                
            }
        }
        
        return result
    }
    
    fun generateBlockedCellsForNextLine(
        indexesToShift: Set<Int>,
        indexToAdd: Int,
        indexToRemove: Int,
        shiftOperation: (Int) -> Int
    ): Set<Int> {
        val nextLevelLeftBlockedCells = mutableSetOf<Int>()
        indexesToShift.forEach { cellIndex ->
            nextLevelLeftBlockedCells.add(shiftOperation(cellIndex))
        }
        nextLevelLeftBlockedCells.add(indexToAdd)
        nextLevelLeftBlockedCells.remove(indexToRemove)
        return nextLevelLeftBlockedCells
    }
    
    fun isAvailableIndex(
        index: Int,
        blockedRows: Set<Int>,
        cellsBlockedToTheLeft: Set<Int>,
        cellsBlockedToTheRight: Set<Int>
    ): Boolean {
        return index !in cellsBlockedToTheLeft 
            && index !in cellsBlockedToTheRight
            && index !in blockedRows
    }
    
    fun appendResultToList(
        boardSize: Int,
        columnIndex: Int,
        resultsList: MutableList<LinkedList<String>>, 
        successPaths: List<LinkedList<String>>
    ) {
        if (successPaths.isNotEmpty()) {
            val currentRow = getCurrentRowString(boardSize, columnIndex)
            successPaths.forEach { path ->
                path.addFirst(currentRow)
            }
            resultsList.addAll(successPaths)
        }
    }
    
    fun getCurrentRowString(
        boardSize: Int,
        columnIndex: Int
    ): String {
        val rowBuilder = StringBuilder()
        for (i in 0 until columnIndex) {
            rowBuilder.append('.')
        }
        rowBuilder.append('Q')
        for (i in columnIndex + 1 until boardSize) {
            rowBuilder.append('.')
        }
        return rowBuilder.toString()
    }
    
}
