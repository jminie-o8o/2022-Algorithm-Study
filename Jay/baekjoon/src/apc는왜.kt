import java.io.InputStreamReader
import kotlin.system.exitProcess

fun main() = with(InputStreamReader(System.`in`)) {
    val (N, ability, limitCount) = readLine()!!.split(" ").map { it.toInt() }
    val isSolved = Array<Pair<Boolean, Boolean>>(N) { Pair(false, false) }
    val problemList = mutableListOf<Pair<Int, Int>>()
    var count = 0
    var total = 0
    repeat(N) {
        val score = readLine()!!.split(" ").map { it.toInt() }
        val pair = Pair(score[0], score[1])
        problemList.add(pair)
    }

    for (i in problemList.indices) {
        if (count >= limitCount) {
            print(total)
            exitProcess(0)
        } else {
            if (problemList[i].second <= ability) {
                count++
                total += 140
                isSolved[i] = Pair(true, true)
            }
        }
    }
    for (i in problemList.indices) {
        if (count >= limitCount) {
            print(total)
            exitProcess(0)
        } else {
            if (problemList[i].first <= ability && !isSolved[i].first) {
                count++
                total += 100
                isSolved[i] = Pair(true, false)
            }
        }
    }
    print(total)
}
