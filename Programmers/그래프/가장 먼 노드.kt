import java.util.*

class Solution {

    data class Node(
        var node: Int = 1,
        var dist: Int = 0
    )

    var MAX = 0
    val Graph = Array(20005) { ArrayList<Int>() }
    val Visited = Array(20005) { false }
    val DistList = ArrayList<Int>()

    fun bfs() {
        var queue: Queue<Node> = LinkedList<Node>()

        var start = Node(1, 0)
        queue.add(start)
        Visited[1] = true

        while (queue.isNotEmpty()) {
            val current = queue.peek()
            queue.poll()

            if (current.dist > MAX) MAX = current.dist
            DistList.add(current.dist)

            Graph[current.node].forEach {
                if (!Visited[it]) {
                    Visited[it] = true
                    queue.add(Node(it, current.dist + 1))
                }
            }
        }
    }

    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0

        for (i in edge.indices) {
            val num1 = edge[i][0]
            val num2 = edge[i][1]

            Graph[num1].add(num2)
            Graph[num2].add(num1)
        }

        bfs()

        answer = DistList.filter { it == MAX }.size

        return answer
    }
}