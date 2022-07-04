import java.util.Scanner

fun main(args: Array<String>) {
    val input = readLine()
    val (originWord, findWord) = input?.split("$") ?: throw WrongInput()
    var nowWord = originWord
    var count = 0

    while (true) {
        val wordList = nowWord.split(findWord)
        if (wordList.size == 1) {
            nowWord = wordList[0]
            break
        }
        else count += wordList.size - 1
        val sb = StringBuilder("")
        wordList.forEach { sb.append(it) }
        nowWord =sb.toString()
    }
    println("$count $nowWord")
}


