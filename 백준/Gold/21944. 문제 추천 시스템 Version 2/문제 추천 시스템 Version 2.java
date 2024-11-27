import java.util.*;
import java.io.*;
class Solution {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    Map<Integer, TreeMap<Integer, TreeSet<Integer>>> problems = new HashMap<>();    //알고리즘종류/난이도/문제번호
    Map<Integer, int[]> problemNumMap = new HashMap<>();
    TreeMap<Integer, TreeSet<Integer>> lMap = new TreeMap<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            exec("add");
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();
            exec(comm);
        }
        
        bw.flush();
    }
    public void exec(String comm) throws IOException {
        if (comm.equals("recommend")) {
            int G = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            if (X == 1) {
                bw.write(problems.get(G).get(problems.get(G).lastKey()).last() + "\n");
            } else {
                bw.write(problems.get(G).get(problems.get(G).firstKey()).first() + "\n");
            }
            return;
        }
        if (comm.equals("recommend2")) {
            int X = Integer.parseInt(st.nextToken());
            int answer;
            if (X == 1) {
                answer = lMap.get(lMap.lastKey()).last();
            } else {
                answer = lMap.get(lMap.firstKey()).first();
            }
            bw.write(answer + "\n");
            return;
        }
        if (comm.equals("recommend3")) {
            int X = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int answer;
            if (X == 1) {
                Integer nowL = lMap.ceilingKey(L);
                if (nowL == null) {
                    answer = -1;
                } else {
                    answer = lMap.get(nowL).first();
                }
            } else {
                Integer nowL = lMap.lowerKey(L);
                if (nowL == null) {
                    answer = -1;
                } else {
                    answer = lMap.get(nowL).last();
                }
            }
            bw.write(answer + "\n");
            return;
        }
        if (comm.equals("add")) {
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            problemNumMap.put(P, new int[]{L, G});
            if (!problems.containsKey(G)) {
                problems.put(G, new TreeMap<>());
            }
            if (!problems.get(G).containsKey(L)) {
                problems.get(G).put(L, new TreeSet<>());
            }
            problems.get(G).get(L).add(P);

            if (!lMap.containsKey(L)) {
                lMap.put(L, new TreeSet<>());
            }
            lMap.get(L).add(P);

            return;
        }
        if (comm.equals("solved")) {
            int P = Integer.parseInt(st.nextToken());
            int[] data = problemNumMap.get(P);
            int L = data[0];
            int G = data[1];
            problemNumMap.remove(P);
            problems.get(G).get(L).remove(P);
            if (problems.get(G).get(L).isEmpty()) {
                problems.get(G).remove(L);
            }
            if (problems.get(G).isEmpty()) {
                problems.remove(G);
            }

            lMap.get(L).remove(P);
            if (lMap.get(L).isEmpty()) {
                lMap.remove(L);
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
recommend G x : x==1 : 알고리즘G중 가장 어려운거/문제번호 큰거 \ x==-1: 알고리즘G중 가장 쉬운거/문제번호 작은거
-> G순서/난이도/문제번호 중요
recommend2 x : x==1 : 가장 어려운/문제번호 큰거 \ x==-1 가장 쉬운/문제번호 작은거
-> 난이도/문제번호 중요
recommend3 x L : x==1 : 난이도 L보다 크거나 같은것중 가장 쉬운거/문제번호 작은거 \ x==-1: 난이도 L보다 작은거중 가장 어려운거/문제번호 큰거 \ 없으면 -1
-> 난이도/문제번호 중요
add P L G : 난이도L 알고리즘G 번호P인 문제 추가.(번호 중복 불가. 제거된 녀석은 다른 조건으로 들어올수있음)
solved P : 문제번호 P 제거
->
---
2차원배열느낌?
전체 배열은 알고리즘종류 A,B,C...가 인덱스. 내부 배열로 난이도와 문제번호 존재.
 */