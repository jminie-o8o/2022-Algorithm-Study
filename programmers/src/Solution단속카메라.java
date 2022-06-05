

class Solution단속카메라 {


    public int solution(int[][] routes) {
        int answer = 0;
        int[] parentList = new int[routes.length];

        for (int i = 0; i < parentList.length; i++) {
            if (find(routes[i]) != null) {

            } else {
                parentList[i] = i;
                answer++;
            }
        }


        return answer;
    }

    public static Integer find(int a , int[] parentList) {

        if (parentList[a] == a)
            return a;
        else{
            return parentList[a] = find(parentList[a] , parentList);
        }
    }

    public static void union(int a, int b) {
    }


}