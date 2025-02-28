import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        int[] priority = new int[26];
        for(int i=0;i<N;i++) {
            arr[i] = br.readLine();
            int length = arr[i].length()-1;
            for(int j=0;j<arr[i].length();j++) {
                char c = arr[i].charAt(j);
                priority[c-'A'] += (int) Math.pow(10,length--);
            }
        }

        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for(int i=0;i<26;i++) {
            if(priority[i]==0) {
                continue;
            }
            q.add(new int[]{priority[i], i});
        }

        Map<Character, Integer> map = new HashMap<>();
        int val = 9;
        while(!q.isEmpty()) {
            char c = (char) ('A'+ q.remove()[1]);
            map.put(c,val--);
        }

        int answer = 0;
        for(String s : arr) {
            int length = s.length()-1;
            for(int i=0;i<s.length();i++) {
                answer += (int) (map.get(s.charAt(i)) * Math.pow(10, length--));
            }
        }

        System.out.println(answer);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
길이가 제일 긴 녀석의 끝자리부터 채워가기
각 자릿수에 해당 알파벳이 몇번 나왔는가
알파벳마다의 가중치 - 10^자릿수*해당 자리에서의 횟수
 */