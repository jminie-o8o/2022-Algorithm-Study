class Solution소수찾기{
    private val totalList = hashSetOf<Int>()
    fun solution(numbers: String): Int {

        dfs(mutableListOf<Char>(), numbers.toMutableList())

        return totalList.size
    }


    private fun dfs(nowString: MutableList<Char>, remain: MutableList<Char>) {
        if (nowString.size != 0) {
            val finalNum = String(nowString.toCharArray()).toInt()
            if (isPrime(finalNum)) totalList.add(finalNum)
        }
        if (remain.size == 0) return
        else {
            remain.forEach {
                val newNowString = nowString.toMutableList()
                val newRemain = remain.toMutableList()

                newNowString.add(it)
                newRemain.remove(it)
                dfs(newNowString,newRemain)
            }
        }
    }

    private fun isPrime(num: Int): Boolean {
        if (num == 1 || num == 0) return false
        for (i in 2 until num) if (num % i == 0) return false
        return true
    }
}