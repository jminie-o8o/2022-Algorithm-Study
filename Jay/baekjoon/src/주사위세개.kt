import java.lang.Integer.max


fun main() {
    // val aNum = readLine()!!.toInt()
    val diceList = readLine()!!.split(" ").map { it.toInt() }
    val diceCountList = IntArray(7) { 0 }

    var maxValue = 0
    var maxCount = 1
    var maxCountValue = 0
    diceList.forEach {
        diceCountList[it] += 1
        if (maxCount < diceCountList[it]) {
            maxCount = diceCountList[it]
            maxCountValue = it
        }
        maxValue = max(maxValue, it)
    }


    when (maxCount) {
        1 -> {
            println(maxValue * 100)
        }
        2 -> {
            println(1000 + maxCountValue * 100)
        }
        else -> {
            println(10000 + maxCountValue * 1000)
        }
    }

}

