public class Solution카펫 {
    public int minValue = Integer.MAX_VALUE;

    public int[] solution(int brown, int yellow) {
        int[] answer = getPossiblePair(brown + yellow, yellow);
        return answer;
    }

    public int[] getPossiblePair(int value, int yellow) {
        int[] pair = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i = 1; i <= value; i++) {
            if (value % i == 0) {
                if (i > value / i) {
                    break;
                } else {
                    if ((value / i - 2) * (i - 2) == yellow) {
                        pair[0] = value / i;
                        pair[1] = i;
                    }
                }
            }
        }
        return pair;
    }
}
