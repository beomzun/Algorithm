import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int N = commands.length;
        int[] answer = new int[N];
        for(int i=0;i<N;i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=start-1;j<end;j++) {
                arr.add(array[j]);
            }
            Collections.sort(arr);
            answer[i] = arr.get(k-1);
        }
        return answer;
    }
}