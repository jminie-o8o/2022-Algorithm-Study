import java.io.InputStreamReader

fun main() = with(InputStreamReader(System.`in`)) {
    val num = readLine()!!.toInt()
    val bList = readLine()!!.split(" ").map { it.toInt() }
    val aSumList = IntArray(num) { 0 }
    val aList = IntArray(num) { 0 }

    aList[0] = bList[0]
    aSumList[0] = bList[0]
    print("${aSumList[0]} ")

    for (i in 1 until bList.size) {
        val a = (bList[i] * (i + 1)) - aSumList[i - 1]
        aList[i] = a
        aSumList[i] = aSumList[i - 1] + a
        print("${aList[i]} ")
    }

}