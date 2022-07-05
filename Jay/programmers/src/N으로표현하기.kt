import kotlin.math.min

class Solution_N으로표현하기 {

    var answer = 9
    var targetValue = 0

    fun solution(N: Int, number: Int): Int {
        targetValue = number
        dfs(N, 0, 0)

        if (answer >=9) answer =-1
        return answer
    }

    private fun dfs(_usingValue: Int, currentValue: Int, cnt: Int) {
        if (cnt > 8) {
            return
        }
        if (targetValue == currentValue) {
            answer = min(answer , cnt)
            return
        }
        var usingValue = _usingValue

        for (i in 0 until 8- cnt) {
            dfs(_usingValue, currentValue + usingValue, cnt + 1+i)
            dfs(_usingValue, currentValue - usingValue, cnt + 1+i)
            dfs(_usingValue, currentValue * usingValue, cnt + 1+i)
            dfs(_usingValue, currentValue / usingValue, cnt + 1+i)

          // 곱하기 usingVaule 가 아닌 _usingVaule 인것에 주의
            usingValue += (Math.pow(10.0, i.toDouble()+1) * _usingValue).toInt()
        }
    }
}