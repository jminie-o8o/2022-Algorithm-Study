import java.io.InputStreamReader

fun main() = with(InputStreamReader(System.`in`)) {
    val aNum = readLine()!!.toInt()
    val aList = readLine()!!.split(" ").map { it.toInt() }

    val bNum = readLine()!!.toInt()
    val bList = readLine()!!.split(" ").map { it.toInt() }

    val aSet = mutableSetOf<Int>()
    for (i in aList.indices) {
        aSet.add(aList[i])
    }
    for (i in bList.indices) {
        if (aSet.contains(bList[i])) println(1)
        else println(0)
    }
}
