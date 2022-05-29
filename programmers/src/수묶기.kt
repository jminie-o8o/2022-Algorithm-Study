import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val plusList = mutableListOf<Int>()
    val minusList = mutableListOf<Int>()
    repeat(n) {
        val num = readLine().toInt()
        if (num > 0) plusList.add(num)
        else minusList.add(num)
    }


    plusList.sortDescending()
    minusList.sort()

    var plusIndex = 0
    var minusIndex = 0
    var answer = 0
    while (true) {
        // 두개가 존재할때
        if (plusIndex + 1 <= plusList.size - 1) {
            if (plusList[plusIndex] != 1 && plusList[plusIndex + 1] != 1)
                answer += plusList[plusIndex] * plusList[plusIndex + 1]
            else {
                answer += plusList[plusIndex]
                answer += plusList[plusIndex + 1]
            }
            plusIndex += 2
        }// 한개가 존재할때
        else if (plusIndex == plusList.size - 1) {
            answer += plusList[plusIndex]
            break
        } // 없을때
        else {
            break
        }
    }
    while (true) {
        if (minusIndex + 1 <= minusList.size - 1) {
            answer += minusList[minusIndex] * minusList[minusIndex + 1]
            minusIndex += 2
        }// 한개가 존재할때
        else if (minusIndex == minusList.size - 1) {
            answer += minusList[minusIndex]
            break
        } // 없을때
        else {
            break
        }
    }
    println(answer)
}
