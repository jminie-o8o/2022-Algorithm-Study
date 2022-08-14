class P49191 {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        val loserGraph = Array<MutableSet<Int>>(n + 1) { mutableSetOf() }
        val winnerGraph = Array<MutableSet<Int>>(n + 1) { mutableSetOf() }

        for ((winner, loser) in results) {
            loserGraph[winner].add(loser) // winner에게 진 사람 목록
            winnerGraph[loser].add(winner) // loser를 이긴 사람 목록
        }

        for (i in 1..n) {
            for (winner in winnerGraph[i]) {
                loserGraph[winner].addAll(loserGraph[i]) // i(winner)에게 진 사람들은 i를 이긴 사람한테 짐
            }
            for (loser in loserGraph[i]) {
                winnerGraph[loser].addAll(winnerGraph[i]) // i(loser)를 이긴 사람들은 i한테 진 사람도 이길 수 있음
            }
        }

        repeat(n + 1) {
            if (loserGraph[it].size + winnerGraph[it].size == n - 1) {
                answer++
            }
        }

        return answer
    }
}

fun main() {
    val sol = P49191()
    sol.solution(
        5, arrayOf(
            intArrayOf(4, 3),
            intArrayOf(4, 2),
            intArrayOf(3, 2),
            intArrayOf(1, 2),
            intArrayOf(2, 5),
        )
    )
}
