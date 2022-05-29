import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 소요시간으로 정렬한다
    // 빈칸이 있으면 넣는다.
    var answer = 0
    val n = readLine().toInt()
    val hashMap = hashMapOf<Int, MutableList<Pair<Int, Int>>>()
    repeat(n) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        hashMap[e - s]?.let { it.add(Pair(s, e)) } ?: kotlin.run {
            hashMap[e - s] = mutableListOf<Pair<Int, Int>>(Pair(s, e))
        }
    }
    val timeTable = MutableList<Boolean>(100001) { true }

    hashMap.keys.forEach { time ->
        hashMap[time]?.forEach loop1@ {
            for (i in it.first until it.first + time) {
                if (!timeTable[i]) {
                    return@loop1
                }
            }
            for (i in it.first until it.first + time) {
                timeTable[i] = false
            }
           // println("${it.first} , ${it.second} ")
            answer++
        }
    }
    println(answer)
}
