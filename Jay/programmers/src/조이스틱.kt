import kotlin.math.*


class Solution조이스틱{
    companion object {
        const val LENGTH = 26
    }

    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"


    fun solution(name: String): Int {
        var answer = 0
        var move = name.length - 1

        for (i in name.indices) {
            val index = alphabet.indexOf(name[i])
            val finalIndex = minOf(index, abs(index - LENGTH))
            answer += finalIndex


            if (i < name.length - 1 && name[i + 1] == 'A') {
                var nextIndex = i + 1
                while (nextIndex < name.length  && name[nextIndex] == 'A') {
                    nextIndex++
                }
                // 방향전환 후에 대한 좌우 움직임에 대한 계산이 빠진 것이 이해가 되지 않음
                move = min(move, i * 2 + (name.length - nextIndex))
                move = min(move, i + (name.length - nextIndex) * 2)
            }
        }
        return answer + move
    }
}