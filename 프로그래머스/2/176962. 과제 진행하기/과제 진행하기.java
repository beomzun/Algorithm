import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int N = plans.length;
        
        Homework[] homeworks = new Homework[N];
        for(int i=0;i<N;i++) {
            String[] plan = plans[i];
            
            String subject = plan[0];
            String[] times = plan[1].split(":");
            int startTime = Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
            int restTime = Integer.parseInt(plan[2]);
            homeworks[i] = new Homework(subject, startTime, restTime);
        }
        Arrays.sort(homeworks, (h1,h2) -> {
            return h1.startTime-h2.startTime;
        });
        
        Stack<Homework> stack = new Stack<>();
        int finishIdx=0;
        for(int i=0;i<N-1;i++) {
            int now = homeworks[i].startTime;
            if(now+homeworks[i].restTime<=homeworks[i+1].startTime) {
                answer[finishIdx++] = homeworks[i].subject;
                now +=homeworks[i].restTime;
            } else {
                homeworks[i].restTime -= homeworks[i+1].startTime-now;
                stack.push(homeworks[i]);
                now = homeworks[i+1].startTime;
            }
            
            while(!stack.isEmpty() && now<homeworks[i+1].startTime) {
                Homework h = stack.pop();
                if(now+h.restTime<=homeworks[i+1].startTime) {
                    answer[finishIdx++] = h.subject;
                    now+=h.restTime;
                } else {
                    h.restTime -= homeworks[i+1].startTime-now;
                    stack.push(h);
                    now = homeworks[i+1].startTime;
                }
            }
        }
        
        answer[finishIdx++] = homeworks[N-1].subject;
        while(!stack.isEmpty()) {
            answer[finishIdx++] = stack.pop().subject;
        }
        
        return answer;
    }
}
class Homework {
    String subject;
    int startTime;
    int restTime;
    Homework(String subject, int startTime, int restTime) {
        this.subject = subject;
        this.startTime=startTime;
        this.restTime=restTime;
    }
}