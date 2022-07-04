class SolutionHIndex {
    fun solution(citations: IntArray): Int {
        var answer = 0
        citations.sort()

        for(i in citations.indices){
            val h = citations.size - i
            if( h <= citations[i]){
                answer = h
                break
            }
        }
        return answer
    }
}



