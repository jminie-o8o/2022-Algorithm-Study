import java.util.Scanner
import java.util.Stack

fun main(args: Array<String>) {

    // 문제 제목이 2차원 배열 변환이기에
    // 다중배열문자열을 2차원 배열이라고 가정하고 풀이하였습니다.

    val input = readLine() ?: throw WrongInput()
    if (input[0] != '[' || input[input.lastIndex] != ']') {
        println("Error")
    }
    val inputInside = input.substring(1, input.lastIndex)
    val answerSet = mutableSetOf<String>()

    var maxArray = "[]"

//     다중 문자 배열에 대한 검사
    val stringStack = StringBuilder("")
    inputInside?.forEach {
        // 담기기 시작
        if (stringStack.isNotEmpty()) {
            if (it.isDigit()) stringStack.append(it)
            else if (it ==','){
                if (stringStack[stringStack.lastIndex].isDigit()){
                    stringStack.append(it)
                }else{
                    println("Error")
                }
            }
            else if (it == ']') {
                stringStack.append("]")
                answerSet.add(stringStack.toString())
                if (maxArray.length < stringStack.toString().length) maxArray = stringStack.toString()
                stringStack.clear()
            }
        } else if (it == '[') stringStack.append(']')
        else {
            // 배열안에 배열이 아닌 다른 값이 들어가 있는 경우
            println("Error")
            return@main
        }
    }
    if (answerSet.size == 0) {
        println("Error")
    } else {
        println("${answerSet.size} / ${maxArray}")
    }

}

//class WrongInput : java.lang.RuntimeException()