import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val dx = arrayListOf<Int>(0, 1, 0, -1)
    val dy = arrayListOf<Int>(1, 0, -1, 0)
    val n = readLine().toInt()

    repeat(n) {
        var answer = 0
        val (xSize, ySize, cabbageCount) = readLine().split(" ").map { it.toInt() }
        val ground = Array(ySize) { Array(xSize) { 0 } }

        // 배추 위치 지정
        repeat(cabbageCount) {
            val (x, y) = readLine().split(" ").map { it.toInt() }
            ground[y][x] = 1
        }

        fun dfs(y: Int, x: Int) {
            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx < 0 || ny < 0 || nx >= xSize || ny >= ySize || ground[ny][nx] == 0) {
                    continue
                }
                ground[ny][nx] = 0
                dfs(ny, nx)
            }
        }

        for (i in 0 until ySize) {
            for (j in 0 until xSize) {
                if (ground[i][j] == 1) {
                    dfs(i, j)
                    answer++
                }
            }
        }
        println(answer)
    }
}


