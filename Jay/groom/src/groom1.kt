import java.util.Scanner

fun main(args: Array<String>) {
    val input = readLine()
    try {
        if(input == null ) throw NoneListException()


        val inputList = input?.split(",")
        if(inputList.isEmpty()) throw NoneListException()
        val hashSet = hashSetOf<Int>()

        inputList.forEach {
            try {
                val number = it.toInt()
                if (number % 2 == 1) hashSet.add(number)
            } catch (e: Exception) {
            }
        }

        println("${hashSet.size} ${hashSet.sum()}")

    } catch (e: NoneListException) {
        // 문제에 예외처리를 어떻게 해야할지 명시되지 않아
        // 비워두었습니다.
    }
}

class NoneListException : java.lang.RuntimeException()