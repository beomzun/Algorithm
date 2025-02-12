import java.util.*;
class Solution {
    public int solution(int N, int[][] results) {
        Node[] db = new Node[N+1];
        for(int i=1;i<=N;i++) {
            db[i] = new Node();
        }
        
        for(int[] result : results) {
            int win = result[0];
            int lose = result[1];
            db[win].win.add(lose);
            db[lose].lose.add(win);
        }
        
        
        int count=0;
        for(int i=1;i<=N;i++) {
            int sum=0;
            Queue<Integer> q = new ArrayDeque<>();
            Set<Integer> set = new HashSet<>();
            for(int win : db[i].win) {
                if(set.contains(win)) {
                    continue;
                }
                set.add(win);
                q.add(win);
            }
            while(!q.isEmpty()) {
                int now = q.remove();
                for(int child : db[now].win) {
                    if(set.contains(child)) {
                        continue;
                    }
                    set.add(child);
                    q.add(child);
                }
            }
            
            for(int lose : db[i].lose) {
                if(set.contains(lose)) {
                    continue;
                }
                set.add(lose);
                q.add(lose);
            }
            while(!q.isEmpty()) {
                int now = q.remove();
                for(int parent : db[now].lose) {
                    if(set.contains(parent)) {
                        continue;
                    }
                    set.add(parent);
                    q.add(parent);
                }
            }
            if(set.size()==N-1) {
                count++;
            }
        }
        return count;
    }
}
class Node {
    Set<Integer> win = new HashSet<>(); //내가 이긴 배열
    Set<Integer> lose = new HashSet<>();
}
/*
1 승:2
2 승:5패:4,3,1
3 승:2,5 패:4
4 승:3,2,5
5 패:2,4,3,1
*/