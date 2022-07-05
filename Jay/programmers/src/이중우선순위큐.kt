import java.util.PriorityQueue
import java.util.Collections


class Solution이중우선순위큐 {

    // 최대힙과 최소힙 두개를 관리한다.
    fun solution(operations: Array<String>): IntArray {

        val minQueue = PriorityQueue<Int>()
        val maxQueue = PriorityQueue<Int>(Collections.reverseOrder())

        operations.forEach {
            val input = it.split(" ")
            if (input[0] == "I") {
                minQueue.add(input[1].toInt())
                maxQueue.add(input[1].toInt())
            } else if (minQueue.size == 0)
            else if (input[1] == "1") minQueue.remove(maxQueue.poll())
            else maxQueue.remove(minQueue.poll())
        }


        return if (maxQueue.size > 0) intArrayOf(maxQueue.peek(), minQueue.peek())
        else intArrayOf(0, 0)
    }
}