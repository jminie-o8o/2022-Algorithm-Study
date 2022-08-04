import java.lang.Math.max
import java.util.LinkedList


class Solution {
    private lateinit var map: Array<MutableList<Int>>
    private lateinit var visited: Array<Int>
    var answer = 0
    var maxLayer = 0
    fun solution(n: Int, edge: Array<IntArray>): Int {

        visited = Array(n + 1) { n }
        visited[0] = 0
        visited[1] = 0

        map = Array(n + 1) { mutableListOf() }
        edge.forEach {
            map[it[0]].add(it[1])
            map[it[1]].add(it[0])
        }
        bfs(1)
        return visited.count { it == maxLayer }
    }

    private fun dfs(startPoint: Int, layer: Int) {
        visited[startPoint] = kotlin.math.min(layer, visited[startPoint])
        map[startPoint].forEach {
            if (visited[it] > layer) {
                dfs(it, layer + 1)
            }
        }
    }

    private fun bfs(startPoint: Int) {
        val queue = LinkedList<Int>()

        queue.add((startPoint))
        while (queue.isNotEmpty()) {
            val newPoint = queue.poll()
            //layer = newPoint.second
            maxLayer = max(visited[newPoint], maxLayer)
            map[newPoint].forEach {
                if (visited[it] > visited[newPoint] + 1) {
                    queue.add(it)
                    visited[it] = visited[newPoint] + 1
                }
            }
        }
    }
}