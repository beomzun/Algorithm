import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] len = video_len.split(":");
        int length = Integer.parseInt(len[0])*60+Integer.parseInt(len[1]);
        System.out.println(length);
        
        String[] posArr = pos.split(":");
        int answer = Integer.parseInt(posArr[0])*60+Integer.parseInt(posArr[1]);
        System.out.println(answer);
        
        String[] opStart = op_start.split(":");
        int opStartTime = Integer.parseInt(opStart[0])*60+Integer.parseInt(opStart[1]);
        System.out.println(opStartTime);
        
        String[] opEnd = op_end.split(":");
        int opEndTime = Integer.parseInt(opEnd[0])*60+Integer.parseInt(opEnd[1]);
        System.out.println(opEndTime);
        
        for(String command : commands) {
            if(answer>=opStartTime && answer<=opEndTime) {
                answer = opEndTime;
            }
            System.out.println(answer);
            
            if(command.equals("prev")) {
                if(answer<10) {
                    answer=0;
                    continue;
                }
                answer-=10;
            } else if(command.equals("next")) {
                answer+=10;
                if(answer>length) {
                    answer=length;
                }
            }
        }
        if(answer>=opStartTime && answer<=opEndTime) {
                answer = opEndTime;
        }
        System.out.println(answer);
        
        StringBuilder sb = new StringBuilder();
        if(answer/60<10) {
            sb.append("0");
            if(answer/60<1) {
                sb.append("0");
            } else {
                sb.append(answer/60);
            }
        } else {
            sb.append(answer/60);
        }
        sb.append(":");
        answer%=60;
        if(answer<10) {
            sb.append("0");
            sb.append(answer);
        } else {
            sb.append(answer);
        }
        
        return sb.toString();
    }
}
/*
10초 전 or 처음
10초 후 or 마지막
오프닝 스킵 - 오프닝 중간인 경우 무조건 이루어짐
*/