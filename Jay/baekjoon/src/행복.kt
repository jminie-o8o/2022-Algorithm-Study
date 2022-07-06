import java.io.InputStreamReader
import java.lang.Integer.*

fun main() = with(InputStreamReader(System.`in`)) {
    val num = readLine()?.toInt()
    var max = Integer.MIN_VALUE
    var min = Integer.MAX_VALUE

    val scores = readLine()?.split(" ")
    if (scores != null) {
        for (i in scores.indices) {
            val target = (scores[i]).toInt()
            max = max(max, target)
            min = min(min, target)
        }
    }
    println(max - min)

}