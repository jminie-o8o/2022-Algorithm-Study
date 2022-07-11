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


        fun bfs(y: Int, x: Int) {
            val queue = LinkedList<Pair<Int, Int>>()
            queue.offer(Pair(x, y))
            while (!queue.isEmpty()) {
                val (targetX, targetY) = queue.poll()
                for (i in 0..3) {
                    val nx = targetX + dx[i]
                    val ny = targetY + dy[i]
                    if (nx < 0 || ny < 0 || ny >= ground.size || nx >= ground[0].size || ground[ny][nx] == 0) continue
                    ground[ny][nx] = 0
                    queue.offer(Pair(nx, ny))
                }
            }
        }


        for (i in 0 until ySize) {
            for (j in 0 until xSize) {
                if (ground[i][j] == 1) {
                    bfs(i, j)
                    answer++
                }
            }
        }
        println(answer)
    }
}


