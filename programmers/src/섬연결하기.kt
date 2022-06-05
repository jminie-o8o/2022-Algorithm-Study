import kotlin.math.min


class Solution섬연결하기 {
    lateinit var parentList: IntArray
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        parentList = IntArray(n) { it }

       costs.sortBy { it[2] }

        for (i in costs.indices) {
            if (findParent(parentList,costs[i][0]) != findParent(parentList, costs[i][1])) {

                answer += costs[i][2]

                // 이제 연결이 되었다면 같은 부모로 귀속
                unionParent(parentList,costs[i][0], costs[i][1])
            }
        }
        return answer
    }

    private fun findParent(parentList: IntArray ,idx: Int): Int {
        return if (parentList[idx] == idx) idx
        else findParent(parentList , parentList[idx])
    }

    private fun unionParent(parentList: IntArray, aNode: Int, bNode: Int) {
        val x = findParent(parentList, aNode)
        val y = findParent(parentList, bNode)
        if(x<y){
            parentList[y]=x
        }
        else{
            parentList[x]=y
        }
    }
}


// 0. 코스트가 낮은 순으로 정렬한다.
// 1. 두개중에 한섬이라도 등록이 안되어 있는 지를 찾는다.
// 2. 두 섬중 한개만 등록하게 되는 경우 플레그를 지운다.
// 3. 등록할 섬이 비고 플레그가 바뀌어 있으면 멈춘다.
// 4. 1~3에 대해 포문을 반복한다.

// 모든 간선이 이어져있는지에 대한 확인이 불가하다.


//class Solution {
//    fun solution(n: Int, costs: Array<IntArray>): Int {
//        var answer = 0
//        val restList = (0..n-1).toHashSet()
//
//        costs.sortBy { it[2] }
//        var flag = false
//
//        costs.forEach{
//            if(restList.contains(it[0]) || restList.contains(it[1])){
//                if(!restList.contains(it[0]) && !restList.contains(it[1])){
//                    flag =true
//                }
//                restList.remove(it[0])
//                restList.remove(it[1])
//                answer += it[2]
//            }
//            if(restList.isEmpty() && flag == true){
//                return@forEach
//            }
//        }
//
//        return answer
//    }
//}