import kotlin.math.max

class Solution {
    fun solution(number: String, k: Int): String {
        var answer = StringBuilder()
        var index = 0
        var maxValue = 0
        // number의 길이에서 k 만큼을 뺀 길이의 수가 필요하므로 그 만큼 반복하게 된다.
        for (i in 0 until number.length - k) {
            maxValue = 0
            // 끝 범위 설정 : i + k + 1 - 1 = i + k
            for (j in index..i + k) {
               if (maxValue < number[j].digitToInt()){
                   index = j+1
                   maxValue = number[j].digitToInt()
               }
            }
            answer.append(maxValue)
        }
        return answer.toString()
    }
}

// 완전 탐색풀이 -> 메모리 부족으로 ㅋ통과 못함
// 인덱스만큼 뒷자리와 맨 앞자리 비교하기
// 맨뒷값이 추가하려는 값보다 큰지

//0 0 0 0 0
//1 2 3 4
//
//fun main() {
//    val sol = Solution()
//    sol.solution("1231234", 3)
//}
//
//class Solution {
//
//    var dfsList = mutableListOf<MutableList<Int>>()
//    fun solution(number: String, k: Int): String {
//        var answer: Long = Int.MIN_VALUE.toLong()
//        dfs(number.length, k, mutableListOf<Int>(-1))
//        dfsList.forEach {
//            val newString = StringBuilder(number)
//            it.forEach {
//                newString.setCharAt(it, ' ')
//            }
//            answer = max(answer,newString.toString().replace(" ", "").toLong())
//        }
//        return answer.toString()
//    }
//
//    private fun dfs(number: Int, k: Int, list: MutableList<Int>) {
//        if (list.size - 1 == k) {
//            list.removeLast()
//            dfsList.add(list)
//        } else if (list[0] > number - 1) return
//        else {
//            for (i in list[0] + 1 until number) {
//                val newList = mutableListOf<Int>()
//                newList.addAll(list)
//                newList.add(0, i)
//                dfs(number, k, newList)
//            }
//        }
//    }
//}
