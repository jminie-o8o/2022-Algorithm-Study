fun main() {
    val sol = Solution()
    val result = sol.solution(
        5,
        arrayOf(intArrayOf(4, 3), intArrayOf(4, 2), intArrayOf(3, 2), intArrayOf(1, 2), intArrayOf(2, 5))
    )
    println(result)
}

class Solution {
    lateinit var winList: Array<MutableSet<Int>>
    lateinit var loseList: Array<MutableSet<Int>>

    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        // winList 에는 해당 index 에게 패배한 사람들이 들어 있다.
        // loseList 에는 해당 index 에게 승리한 사람들이 들어 있다.
        winList = Array(n + 1) { mutableSetOf() }
        loseList = Array(n + 1) { mutableSetOf() }

        for (i in results.indices) {
            val winner = results[i][0]
            val loser = results[i][1]
            winList[winner].add(loser)
            loseList[loser].add(winner)
        }

        for (i in 1..n) {
            val losers = winList[i]
            val winners = loseList[i]

            winners.forEach {
                winList[it].addAll(losers)
            }
            losers.forEach {
                loseList[it].addAll(winners)
            }

        }

        for (i in 1..n) {
            winList[i].remove(i)
            loseList[i].remove(i)
            val result = winList[i].size + loseList[i].size
            if (result == n - 1) {
                answer++
            }
        }
        return answer
    }
    private fun updateWinnerDfs(winner: Int, loser: Int) {
        loseList[loser].forEach {
            if (winner != it) {
                updateWinnerDfs(winner, it)
            }
        }
        winList[winner].addAll(loseList[loser])
        winList[winner].remove(winner)
    }

    private fun updateLoserDfs(winner: Int, loser: Int) {
        winList[winner].forEach {
            if (loser != it) {
                updateLoserDfs(it, loser)
            }
        }
        loseList[loser].addAll(winList[winner])
        loseList[loser].remove(loser)
    }
}