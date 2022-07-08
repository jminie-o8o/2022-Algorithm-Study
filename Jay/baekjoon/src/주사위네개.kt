import java.lang.Integer.max


fun main() {

    val n = readLine()!!.toInt()
    var answer = 0
    repeat(n) {
        val diceList = readLine()!!.split(" ").map { it.toInt() }
        answer = max(getPrice(diceList), answer)

    }

    println(answer)

}

fun getPrice(diceList: List<Int>): Int {
    var maxValue = 0
    var maxCount = 1
    var maxCountValue = 0
    val diceCountList = IntArray(7) { 0 }
    var doubleSet = mutableSetOf<Int>()
    diceList.forEach {
        diceCountList[it] += 1
        if (maxCount < diceCountList[it]) {
            maxCount = diceCountList[it]
            maxCountValue = it
        }

        if (diceCountList[it] == 2) {
            doubleSet.add(it)
        } else if (diceCountList[it] == 3) {
            doubleSet.remove(it)
        }
        maxValue = max(maxValue, it)
    }


    when (maxCount) {
        1 -> {
            return (maxValue * 100)
        }
        2 -> {
            if (doubleSet.size == 2) {
                var total = 2000
                doubleSet.forEach {
                    total += it * 500
                }
                return total
            } else {
                return (1000 + maxCountValue * 100)
            }

        }
        3 -> {
            return (10000 + maxCountValue * 1000)
        }
        else -> {
            return (50000 + maxCountValue * 5000)
        }
    }
}


