import java.util.*
import kotlin.math.max

class P49189 {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        val dist = IntArray(n + 1)
        val q: Queue<Int> = LinkedList()
        val graph = Array(n + 1) { mutableListOf<Int>() }
        edge.forEach { pos ->
            graph[pos[0]].add(pos[1])
            graph[pos[1]].add(pos[0])
        }

        dist[1] = 1
        q.add(1)
        var max = 0
        while (q.isNotEmpty()) {
            val cur = q.poll()
            for (node in graph[cur]) {
                if (dist[node] != 0) continue
                dist[node] = dist[cur] + 1
                max = max(max, dist[node])
                q.add(node)
            }
        }

        dist.forEach {
            if (it == max) answer++
        }
        return answer
    }
}
