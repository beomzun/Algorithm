import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        for(String s : operations) {
            st = new StringTokenizer(s);
            String comm = st.nextToken();
            if(comm.equals("I")) {
                int num = Integer.parseInt(st.nextToken());
                asc.add(num);
                desc.add(num);
            } else {
                if(asc.isEmpty()) {
                    st.nextToken();
                    continue;
                }
                if(Integer.parseInt(st.nextToken())==1) {
                    asc.remove(desc.remove());
                } else {
                    desc.remove(asc.remove());
                }
            }
        }
        
        if(asc.isEmpty()) {
            return new int[]{0,0};
        }
        return new int[]{desc.peek(), asc.peek()};
    }
}