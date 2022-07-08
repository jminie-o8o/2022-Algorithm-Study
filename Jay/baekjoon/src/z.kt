import java.io.InputStreamReader
import kotlin.system.exitProcess

var count = 0

fun main() = with(InputStreamReader(System.`in`)) {
    // N : Test 반복회수

    val (N, r, c) = readLine()!!.split(" ").map { it.toInt() }
    //val endValue = Math.pow(2.0, N.toDouble()).toInt() - 1
    dfsZ(N, Pair(0, 0), r, c)
}


fun dfsZ(size: Int, startPoint: Pair<Int, Int>, r: Int, c: Int) {
    if (size <= 1) {
        if (startPoint.first == r && startPoint.second == c) {
            println(count)
            exitProcess(0)
        } else if (startPoint.first == r && startPoint.second + 1 == c) {
            println(count + 1)
            exitProcess(0)
        } else if (startPoint.first + 1 == r && startPoint.second == c) {
            println(count + 2)
            exitProcess(0)
        } else if (startPoint.first + 1 == r && startPoint.second + 1 == c) {
            println(count + 3)
            exitProcess(0)
        } else {
            count += 4
        }
    } else {
        val displacement = Math.pow(2.0, (size - 1).toDouble()).toInt()
        dfsZ(
            size - 1,
            Pair(startPoint.first, startPoint.second),
            r, c
        )
        dfsZ(
            size - 1,
            Pair(startPoint.first, startPoint.second + displacement),
            r, c
        )
        dfsZ(
            size - 1,
            Pair(startPoint.first + displacement, startPoint.second),
            r, c
        )
        dfsZ(
            size - 1,
            Pair(startPoint.first + displacement, startPoint.second + displacement),
            r, c
        )
    }
}