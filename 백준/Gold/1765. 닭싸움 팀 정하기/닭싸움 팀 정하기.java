import java.util.*;
import java.io.*;
class Solution {
    int[] parent;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        boolean[][] isRival = new boolean[N+1][N+1];
        for(int i=1;i<=N;i++) {
            parent[i] = i;
        }
        for(int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (s.equals("F")) {
                union(a,b);
            } else {
                isRival[a][b] = true;
                isRival[b][a] = true;
            }
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if (isRival[i][j]) {
                    for(int k=1;k<=N;k++) {
                        if (isRival[j][k]) {
                            union(i, k);
                        }
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i=1;i<=N;i++) {
            parent[i] = find(parent[i]);
            set.add(parent[i]);
        }
        System.out.println(set.size());
    }

    public void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if (pA > pB) {
            parent[a] = pB;
        } else {
            parent[b] = pA;
        }
    }
    public int find(int a) {
        if(parent[a]==a) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
친구의 친구는 친구
원수의 원수는 친구
친구면 같은팀, 같은팀은 모두 친구여야함
최대 몇개의 팀이 만들어질수있는가
---
E 1 4 \ 1,2번 팀
F 3 5 \ 3번 팀
F 4 6 \ 4가 존재하므로 2번팀귀속
E 1 2 \ 1이 존재하므로 1과 원수인 2번팀 귀속

1 / 4 - 6 - 2
3 - 5
여기서 E 2 5 가 추가되면 둘 다 존재함.
2는 2번팀 이므로 원수인 1번팀에 귀속
union-find
 */