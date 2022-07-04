import java.util.Scanner
fun main(args: Array<String>) {
    val input = readLine()
    val (findString , targetString) = input?.split(",") ?: throw WrongInput()

    val restWordList  = targetString.split(findString)
    val answerStringBuilder = StringBuilder("")

    answerStringBuilder.append(restWordList[restWordList.lastIndex])
    answerStringBuilder.append(restWordList[0])


    if (answerStringBuilder.toString() == findString ) {
        println("true")
    }else println("false")

}

