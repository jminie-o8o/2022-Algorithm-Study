import kotlin.math.min

fun main() {
    val sol = Solution_sk4(
    )

    val x = sol.solution(
        arrayOf(
            ".F.FFFFF.F",
            ".########.",
            ".########F",
            "...######F",
            "##.######F",
            "...######F",
            ".########F",
            ".########.",
            ".#...####F",
            "...#......"
        ), 6
    )
    println(x)
}

class Solution_sk4 {
    var answer: Int = Int.MAX_VALUE
    var endRow: Int = 0
    var endColum: Int = 0
    var maxMovableCount = 0
    var map = arrayOf("")
    var liver = 0
    fun solution(grid: Array<String>, k: Int): Int {

        maxMovableCount = k
        endRow = grid.size - 1
        endColum = grid[0].length - 1
        map = grid

        val routeHashMap = hashMapOf<Int, MutableList<Int>>()

        grid.forEachIndexed { indexColum, valueColum ->
            valueColum.forEachIndexed { indexRow, valueRow ->
                if (valueRow == '#') liver++
            }
        }
        dfs(0, 0, k, 0, 0)

        return answer
    }

    private fun dfs(colum: Int, row: Int, movableCount: Int, cnt: Int, moveCnt: Int) {
        if (map[row][colum] == '#') return
        if (moveCnt > (endRow) * (endColum) - liver) return
        if (cnt > (endRow) * (endColum) - liver) return
        if (colum == endColum && row == endRow) {
            answer = min(cnt, answer)
            return
        }
        if (movableCount == 0) return
        else {
            if (row == endRow - 3) {
                println("ss")
            }
            if (colum < endColum ) {
                dfs(colum + 1, row, movableCount - 1, cnt, moveCnt + 1)
            }
            if (row < endRow ) {
                dfs(colum, row + 1, movableCount - 1, cnt, moveCnt + 1)
            }
//            if (row > 1) {
//                dfs(colum, row - 1, movableCount - 1, cnt, moveCnt + 1)
//            }
//            if (colum > 1) {
//                dfs(colum - 1, row, movableCount - 1, cnt, moveCnt + 1)
//            }

            if (map[row][colum] == '.') {
                dfs(colum, row, maxMovableCount, cnt + 1, moveCnt)
            }
        }
    }
}
