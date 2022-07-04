//class Solution {
//    val operationList = mutableListOf<MutableList<Boolean>>()
//
//    fun solution(numbers: IntArray, target: Int): Int {
//        var answer = 0
//
//        val tempOperationList = mutableListOf<Boolean>()
//        dfs(tempOperationList, numbers.size)
//
//        if (operationList.size == 0) {
//            return 0
//        } else {
//            for (i in operationList.indices) {
//                var total = 0
//                for (j in operationList[0].indices) {
//                    if (operationList[i][j]) total += numbers[j]
//                    else total -= numbers[j]
//                }
//                if (total == target) answer++
//            }
//            return answer
//        }
//
//    }
//
//    private fun dfs(tempList: MutableList<Boolean>, size: Int) {
//        val tempListCopy = mutableListOf<Boolean>()
//        tempListCopy.addAll(tempList)
//
//        if (tempListCopy.size >= size) {
//            operationList.add(tempListCopy)
//            return
//        } else {
//            tempListCopy.add(true)
//            dfs(tempListCopy, size)
//            tempListCopy.removeAt(tempListCopy.size - 1)
//
//            tempListCopy.add(false)
//            dfs(tempListCopy, size)
//        }
//
//    }
//
//
//}

class Solution타겟넘버 {
    var answer = 0
    fun solution(numbers: IntArray, target: Int): Int {

        dfs(numbers, 0, 0, target)
        return answer
    }

    private fun dfs(numbers: IntArray, index: Int, total: Int, target: Int) {
        if (index >= numbers.size) {
            if (target == total) {
                answer++
            }
            return
        } else {
            val input = numbers[index]
            dfs(numbers, index + 1, total + input, target)
            dfs(numbers, index + 1, total - input, target)
        }
    }
}