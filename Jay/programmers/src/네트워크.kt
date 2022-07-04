//    import java.util.LinkedList
//
//
//    class Solution {
//        fun solution(n: Int, computers: Array<IntArray>): Int {
//            var answer = 0
//            // 자기자신 말고 1인점을 찾는다
//            // 1인점에에 대하여 BFS 로 0으로 만든다
//
//            for (i in computers.indices) {
//                for (j in computers[0].indices) {
//                    if (computers[i][j] == 1) {
//                        bfs(Pair(i, j), computers)
//                        answer++
//                    }
//                }
//            }
//            return answer
//        }
//
//        private fun bfs(pair: Pair<Int, Int>, computers: Array<IntArray>) {
//            val queue = LinkedList<Pair<Int, Int>>()
//            queue.add(pair)
//
//            while (queue.isNotEmpty()) {
//                val point = queue.poll()
//                computers[point.first][point.second] = 0
//                computers[point.second][point.first] = 0
//
//                // 출발노드 검사
//                for (i in computers.indices) {
//                    if (computers[point.first][i] == 1) {
//                        queue.add(Pair(point.first, i))
//                    }
//                }
//
//                // 도착 노드 검사
//                for (i in computers.indices) {
//                    if (computers[point.second][i] == 1) {
//                        queue.add(Pair(point.second, i))
//                    }
//                }
//            }
//        }
//    }

class Solution {
    lateinit var parentList: IntArray
    fun solution(n: Int, computers: Array<IntArray>): Int {

        parentList = IntArray(computers.size) { it }

        for (i in computers.indices) {
            for (j in computers.indices) {
                if(computers[i][j]== 1)  {
                     union(i, j)
                }
            }
        }

        var answer = 0
        for (i in parentList.indices) {
            if (parentList[i] == i) answer++
        }
        return answer
    }

    private fun union(aNode: Int, bNode: Int) {
        val aParent = find(aNode)
        val bParent = find(bNode)
        if (aParent <= bParent) parentList[bParent] = aParent
        else parentList[aParent] = bParent
    }

    private fun find(target: Int): Int {
        return if (parentList[target] == target) {
            target
        } else {
            find(parentList[target])
        }
    }
}

