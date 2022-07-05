class Solution_sk1 {
    fun solution(p: IntArray): IntArray {
        var answer = IntArray(p.size) { 0 }

        for (i in p.indices) {
            var minValue = p[i]
            var minIndex = i
            for (j in i + 1 until p.size) {
                if (minValue > p[j]) {
                    minIndex = j
                    minValue = p[j]
                }
            }
            if (minIndex != i) {
                val tempValue = p[i]
                p[i] = minValue
                p[minIndex] = tempValue
                answer[i] = answer[i] + 1
                answer[minIndex] = answer[minIndex] + 1
            }
        }
        return answer
    }
}