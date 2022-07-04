
class Solution_sk2 {
    fun solution(periods: IntArray, payments: Array<IntArray>, estimates: IntArray): IntArray {
        val postVipIndexes = mutableSetOf<Int>()
        val newVipIndexes = mutableSetOf<Int>()
        val postEnumPeriod = Array<Period>(periods.size) { Period.MEDIUM }
        val newEnumPeriod = Array<Period>(periods.size) { Period.MEDIUM }


        val answer: IntArray = IntArray(2) { 0 }

        for (i in periods.indices) {
            if (periods[i] < SHORT_TERM_MONTH) {
                postEnumPeriod[i] = Period.SHORT
            } else if (periods[i] >= LONG_TERM_MONTH) {
                postEnumPeriod[i] = Period.LONG
            }
        }
        for (i in periods.indices) {
            if (periods[i]+1 < SHORT_TERM_MONTH) {
                newEnumPeriod[i] = Period.SHORT
            } else if (periods[i]+1 >= LONG_TERM_MONTH) {
                newEnumPeriod[i] = Period.LONG
            }
        }

        // 지난 연간 합산금액 및 새롭게 갱신될 연간 합산금액 구하기
        val postPaymentSum = payments.map { it.sumOf { it } }
        val newPaymentSum = IntArray(postPaymentSum.size){0}
        for (i in postPaymentSum.indices) {
            newPaymentSum[i] = postPaymentSum[i] + estimates[i] - payments[i][0]
        }
        val postPaymentRange = getPaymentRangeList(postPaymentSum)
        val newPaymentRange = getPaymentRangeList(newPaymentSum.toList())


        for (i in postPaymentRange.indices) {
            // 지넌 등급 Vip
            if (postPaymentRange[i] == PaymentRange.ABOVE_90) {
                if (postEnumPeriod[i] != Period.SHORT) {
                    postVipIndexes.add(i)
                }
            } else if (postPaymentRange[i] == PaymentRange.ABOVE_60_LESS_90) {
                if (postEnumPeriod[i] == Period.LONG) {
                    postVipIndexes.add(i)
                }
            }

            // 이번 등급 Vip
            if (newPaymentRange[i] == PaymentRange.ABOVE_90) {
                if (newEnumPeriod[i] != Period.SHORT) {
                    newVipIndexes.add(i)
                }
            } else if (newPaymentRange[i] == PaymentRange.ABOVE_60_LESS_90) {
                if (newEnumPeriod[i] == Period.LONG) {
                    newVipIndexes.add(i)
                }
            }


        }

        for (i in periods.indices) {
            if (postVipIndexes.contains(i) && !newVipIndexes.contains(i)) {
                answer[1] += 1
            } else if (!postVipIndexes.contains(i) && newVipIndexes.contains(i)) {
                answer[0] += 1
            }
        }

        return answer
    }

    // 실제 상황이라면 여러번 가격범위를 구하는 행위가 여러번 반복될 것 같아
    // 재사용성을 위해 함수로 뺐습니다.
    private fun getPaymentRangeList(payments: List<Int>): List<PaymentRange> {
        val list = mutableListOf<PaymentRange>()
        payments.forEach {
            if (it < 36*10000) {
                list.add(PaymentRange.LESS_36)
            } else if (it < 48*10000) {
                list.add(PaymentRange.ABOVE_36_LESS_48)
            } else if (it < 60*10000) {
                list.add(PaymentRange.ABOVE_48_LESS_60)
            } else if (it < 90*10000) {
                list.add(PaymentRange.ABOVE_60_LESS_90)
            } else {
                list.add(PaymentRange.ABOVE_90)
            }
        }
        return list
    }

    enum class Period {
        SHORT, LONG, MEDIUM
    }

    enum class PaymentRange {
        LESS_36, ABOVE_36_LESS_48, ABOVE_48_LESS_60, ABOVE_60_LESS_90, ABOVE_90
    }

    companion object {
        const val SHORT_TERM_MONTH = 12 * 2
        const val LONG_TERM_MONTH = 12 * 5
    }
}