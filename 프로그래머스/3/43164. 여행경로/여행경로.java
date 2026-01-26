import java.util.*;
class Solution {
    // 몇번 티켓 사용했는가
    boolean[] visited;
    // 티켓 그래프
    Map<String, ArrayList<Ticket>> graph = new HashMap<>();
    
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        answer[0] = "ICN";
        
        visited = new boolean[tickets.length];
        
        int idx = 0;
        for(String[] ticket : tickets) {
            String start = ticket[0];
            if(!graph.containsKey(start)) {
                graph.put(start, new ArrayList<>());
            }
            graph.get(start).add(new Ticket(idx++, ticket[1]));
        }
        
        for(String key: graph.keySet()) {
            Collections.sort(graph.get(key), Comparator.comparing(t->t.dest));
        }
        
        for(int i=0;i<graph.get("ICN").size();i++) {
            if(dfs("ICN",i,1)) {
                break;
            }
        }
        
        return answer;
    }
    
    // 어디서, 공항의 몇번째 티켓, 뎁스
    public boolean dfs(String start, int idx, int depth) {
        visited[graph.get(start).get(idx).idx] = true;
        String dest = graph.get(start).get(idx).dest;
        answer[depth] = dest;
        
        if(depth==answer.length-1) {
            return true;
        }
        
        if(!graph.containsKey(dest)) {
            visited[graph.get(start).get(idx).idx] = false;
            return false;
        }
        
        for(int i=0;i<graph.get(dest).size();i++) {
            if(visited[graph.get(dest).get(i).idx]) {
                continue;
            }
            
            if(dfs(dest, i, depth+1)) {
                return true;
            }
        }
        
        visited[graph.get(start).get(idx).idx] = false;
        return false;
    }
}
class Ticket{
    int idx;
    String dest;
    Ticket(int idx, String dest) {
        this.idx = idx;
        this.dest = dest;
    }
}
/*
항상 인천에서 출발
모든 티켓 사용
가능 경로 두개이상 시 알파벳 앞순서
---
공항별 티켓 존재

*/