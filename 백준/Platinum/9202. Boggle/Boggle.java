import java.util.*;
import java.io.*;
class Solution {
    Trie trie = new Trie();
    Trie now = trie;
    Set<String> dict = new HashSet<>();
    char[][] boggle;
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    String longest;
    int maxScore;
    Set<String> findWords = new HashSet<>();
    boolean[][] visit;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int W = Integer.parseInt(br.readLine());
        for (int i = 0; i < W; i++) {
            now = trie;
            String s = br.readLine();
            dict.add(s);
            for (int j = 0; j < s.length(); j++) {
                int idx = s.charAt(j) - 'A';
                if (now.arr[idx] == null) {
                    now.arr[idx] = new Trie();
                }
                now = now.arr[idx];
            }
        }

        br.readLine();

        StringBuilder sb = new StringBuilder();
        int B = Integer.parseInt(br.readLine());
        //보글 세팅
        boggle = new char[4][4];
        for (int i = 0; i < B; i++) {
            //세팅
            for (int j = 0; j < 4; j++) {
                String s = br.readLine();
                for (int k = 0; k < 4; k++) {
                    boggle[j][k] = s.charAt(k);
                }
            }

            now = trie;
            visit = new boolean[4][4];
            longest = "";
            maxScore = 0;
            findWords = new HashSet<>();

            //탐색
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    visit[j][k] = true;
                    int idx = boggle[j][k] - 'A';
                    if (now.arr[idx] != null) {
                        dfs(0, j, k, String.valueOf(boggle[j][k]), now.arr[idx]);
                    }
                    visit[j][k] = false;
                }
            }

            sb.append(maxScore).append(" ").append(longest).append(" ").append(findWords.size()).append("\n");
            if (i < B - 1) {
                br.readLine();
            }
        }

        System.out.println(sb);
    }

    public void dfs(int depth, int y, int x, String s, Trie now) {
        if (depth == 9) {
            return;
        }
        //단어 유무
        if (dict.contains(s)) {
            if (!findWords.contains(s)) {
                maxScore += getScore(s);
            }
            if (s.length() > longest.length()) {
                longest = s;
            } else if (s.length() == longest.length() && s.compareTo(longest) < 0) {
                longest = s;
            }
            findWords.add(s);
        }

        for (int i = 0; i < 8; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];
            if (nY < 0 || nY >= 4 || nX < 0 || nX >= 4) {
                continue;
            }
            if (visit[nY][nX]) {
                continue;
            }
            int idx = boggle[nY][nX] - 'A';
            if (now.arr[idx] != null) {
                visit[nY][nX] = true;
                dfs(depth + 1, nY, nX, s.concat(String.valueOf(boggle[nY][nX])), now.arr[idx]);
                visit[nY][nX] = false;
            }
        }
    }

    public int getScore(String s) {
        int length = s.length();
        if (length <= 2) {
            return 0;
        }
        if (length <= 4) {
            return 1;
        }
        if (length == 5) {
            return 2;
        }
        if (length == 6) {
            return 3;
        }
        if (length == 7) {
            return 5;
        }
        if (length == 8) {
            return 11;
        }

        return -1;
    }
}
class Trie {
    Trie[] arr = new Trie[26];
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
1,2 -> 0점,
3,4 -> 1점,
5 -> 2점,
6->  3점, => 5 두개가 더 좋음.
7 -> 5점, => 6 두개가 더 좋음.
8 -> 11점

큰거부터 찾으면 작은거 두개를 놓칠수 있음..
작은거부터 찾고 큰거에서 겹치면 큰 점수로 갱신? -> 갱신하면서 이전에는 불가했던게 될수도 있지 않을까?
---
다국어 이슈에 따른 문제 이해

최대 점수 / 긴 단어 / 단어 수 다 따로임.
최대 점수일 때 가장 긴 단어를 구하고 이 떄의 단어수를 구하는게 아님.
또한, 한 주사위가 한 단어에서만 한 번 쓰이는거지, 여러 단어에서 공유되어도 괜찮음.
 */