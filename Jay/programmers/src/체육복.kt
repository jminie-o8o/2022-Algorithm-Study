fun main() {
    val exam = hashSetOf<Int>(4, 1, 3)
    exam.forEach {
        println(it)
    }
}

class Solution체육복 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val countList = MutableList<Int>(n) { 1 }

        lost.sort()
        reserve.sort()

        reserve.forEach {
            countList[it - 1] += 1
        }
        lost.forEach {
            countList[it - 1] -= 1
        }

        countList.forEach {
            print(it)
        }

        run {
            lost.forEach loop@{ lostIdx ->
                reserve.forEach { reserveIdx ->
                    if (countList[lostIdx - 1] == 1) {
                        return@loop
                    }
                    if (lostIdx - 1 == reserveIdx || lostIdx + 1 == reserveIdx) {
                        if (countList[lostIdx - 1] == 0 && countList[reserveIdx - 1] == 2) {
                            countList[lostIdx - 1] = 1
                            countList[reserveIdx - 1] = 1
                            return@run
                        }
                    }
                }
            }
        }
        return countList.count { it > 0 }
    }
}

class Solution체육복2 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {

        var answer = n
        var lostSet = lost.toSet() - reserve.toSet()
        var reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet

        for (i in lostSet) {
            when {
                i + 1 in reserveSet -> reserveSet.remove(i + 1)
                i - 1 in reserveSet -> reserveSet.remove(i - 1)
                else -> answer--
            }
        }
        return answer
    }
}