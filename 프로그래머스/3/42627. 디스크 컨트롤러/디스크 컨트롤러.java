import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        PriorityQueue<Process> process = new PriorityQueue<>(Comparator.comparingInt(p -> p.request));
        PriorityQueue<Process> memory = new PriorityQueue<>(Comparator.comparingInt(p -> p.time));
        
        for (int i = 0; i < jobs.length; i++) {
            process.add(new Process(jobs[i][0], jobs[i][1]));
        }
        
        // 작업 목록 큐, 작업 중인 큐 둘중 하나라도 남아있다면 작업이 남은 것 
        while (!process.isEmpty() || !memory.isEmpty()) {
            // 작업이 남아있고 해당 요청이 들어온 상황이라면 memory에 올리기 
            while (!process.isEmpty() && process.peek().request <= time) {
                memory.add(process.poll());
            }
            
            // 메모리 비어있다면 다음 작업이 들어올 시간 될 때까지 대기 
            if (memory.isEmpty()) {
                time = process.peek().request;
            } else {
                Process p = memory.poll();
                time += p.time;
                answer += (time - p.request);
            }
            
        }
        
        return (answer / jobs.length);
    }
    
    public static class Process {
        int request;
        int time;
        
        public Process(int request, int time) {
            this.request = request;
            this.time = time;
        }
    }
}