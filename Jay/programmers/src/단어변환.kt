//import java.lang.Math.min
//
//class Solution {
//    val changingList = mutableListOf<MutableList<String>>()
//
//    fun solution(begin: String, target: String, words: Array<String>): Int {
//        var answer = 0
//        var newWords = hashSetOf<String>()
//        newWords.addAll(words)
//
//
//
//        if (!newWords.contains(target)) return 0
//
//        val tempList = mutableListOf<String>()
//        tempList.add(begin)
//
//        bfs(target, tempList, words.toMutableList())
//
//        // 최초 원소 제외
//        answer = changingList.minOf { it.size } - 1
//
//        return answer
//    }
//
//    private fun bfs(target: String, tempList: MutableList<String>, words: MutableList<String>) {
//        val newTempList = mutableListOf<String>()
//        newTempList.addAll(tempList)
//
//        if (tempList.last() == target) {
//            changingList.add(newTempList)
//            return
//        } else {
//            words.forEach {
//                if (similar(it, tempList.last())) {
//                    newTempList.add(it)
//                    val newWords = mutableListOf<String>()
//                    newWords.addAll(words)
//                    newWords.remove(it)
//                    bfs(target, newTempList, newWords)
//                    newTempList.remove(it)
//                }
//            }
//        }
//    }
//    // O(V+E) * N(글자 평균크기로 계산필요)
//    private fun similar(str1: String, str2: String): Boolean {
//        var count = 0
//        for (i in str1.indices) {
//            if (str1[i] == str2[i]) count++
//        }
//        return str1.length - count == 1
//    }
//}

class Solution단어변환 {
    var answer = Int.MAX_VALUE
    lateinit var visited: BooleanArray
    fun solution(begin: String, target: String, words: Array<String>): Int {
        visited = BooleanArray(words.size) { false }

        if (!words.contains(target)) return 0
        dfs(begin, target, 0, words)

        return answer
    }


    private fun dfs(nowWord: String, target: String, count: Int, words: Array<String>) {
        if (nowWord == target) {
            answer = kotlin.math.min(answer, count)
            return
        } else {
            for (i in words.indices) {
                if (!visited[i] && similar(words[i], nowWord)) {
                    visited[i] = true
                    dfs(words[i], target, count + 1, words)
                    visited[i] = false
                }
            }
        }
    }

    private fun similar(str1: String, str2: String): Boolean {
        var count = 0
        for (i in str1.indices) {
            if (str1[i] == str2[i]) count++
        }
        return str1.length - count == 1
    }
}