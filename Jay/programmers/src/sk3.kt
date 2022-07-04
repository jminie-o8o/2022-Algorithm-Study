

class Solution_sk3 {
    fun solution(n: Int, plans: Array<String>, clients: Array<String>): IntArray {
        var answer: IntArray = IntArray(clients.size) { 0 }

        val ratePlanList = mutableListOf<RatePlan>()
        val clientPlanList = mutableListOf<RatePlan>()

        plans.forEachIndexed { index, value ->
            val input = value.split(" ").map { it.toInt() }
            val serviceList = mutableListOf<Int>()
            if (index != 0){
                serviceList.addAll(ratePlanList[index-1].serviceList)
            }

            for (i in 1 until input.size) {
                serviceList.add(input[i])
            }
            ratePlanList.add(RatePlan(index + 1, input[0], serviceList))
        }


        clients.forEach {
            val input = it.split(" ").map { it.toInt() }
            val serviceList = mutableListOf<Int>()
            for (i in 1 until input.size) {
                serviceList.add(input[i])
            }
            clientPlanList.add(RatePlan(0, input[0], serviceList))
        }


        for (i in clientPlanList.indices) {
            val candidatePlanList = ratePlanList.filter {
                clientPlanList[i].data <= it.data && isInclude(
                    it.serviceList,
                    clientPlanList[i].serviceList
                )
            }
            if (candidatePlanList.isNotEmpty()) {
                answer[i] = candidatePlanList[0].index
            } else answer[i] = 0
        }


        return answer
    }

    fun <T> isInclude(first: List<T>, second: List<T>): Boolean {
        second.forEach {
            if (!first.contains(it)) {
                return false
            }
        }
        return true
    }

    data class RatePlan(val index: Int, val data: Int, val serviceList: List<Int>)
}