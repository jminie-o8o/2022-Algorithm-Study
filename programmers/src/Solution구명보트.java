//import java.util.*;
//
//class Solution {
//    public int solution(int[] people, int limit) {
//
//        boolean[] peopleRest = new boolean[people.length];
//
//        int answer = 0;
//        for (int i = 0; i < people.length; i++) {
//            if (peopleRest[i]) {
//                continue;
//            }
//            int maxIndex = i;
//            int maxValue = people[i];
//            for (int j = i; j < people.length; j++) {
//                if (peopleRest[j]) {
//                    continue;
//                }
//                if (people[i] + people[j] <= limit && maxValue < people[i] + people[j]) {
//                    maxIndex = j;
//                    maxValue = people[i] + people[j];
//                }
//            }
//            if (maxIndex != i) {
//                peopleRest[maxIndex] = true;
//
//            }
//            peopleRest[i] = true;
//            answer++;
//        }
//        return answer;
//    }
//}
//
//
//// 합이 100에 제일 가까운 값을 챙겨서 나간다.
//// 없을 땐 혼자 나간다.

import java.util.*;

//class Solution {
//    public int solution(int[] people, int limit) {
//
//        boolean[] peopleRest = new boolean[people.length];
//
//        int answer = 0;
//        for (int i = 0; i < people.length; i++) {
//            if (peopleRest[i]) {
//                continue;
//            }
//            int maxIndex = i;
//            int maxValue = people[i];
//            for (int j = i; j < people.length; j++) {
//                if (peopleRest[j]) {
//                    continue;
//                }
//                if (people[i] + people[j] <= limit && maxValue < people[i] + people[j]) {
//                    maxIndex = j;
//                    maxValue = people[i] + people[j];
//                }
//            }
//            if (maxIndex != i) {
//                peopleRest[maxIndex] = true;
//
//            }
//            peopleRest[i] = true;
//            answer++;
//        }
//        return answer;
//    }
//}


class Solution구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int index = 0;
        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {
                index++;
            }
            answer++;

        }
        return answer;
    }
}


// 합이 100에 제일 가까운 값을 챙겨서 나간다.
// 없을 땐 혼자 나간다.

// 합이 100에 제일 가까운 값을 챙겨서 나간다.
// 없을 땐 혼자 나간다.