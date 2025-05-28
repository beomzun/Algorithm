import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            TreeSet<Integer> set = new TreeSet<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                int price = Integer.parseInt(st.nextToken());
                Integer ceil = set.ceiling(price);
                if(ceil!=null) {
                    set.remove(ceil);
                }
                set.add(price);
            }

            sb.append("Case #").append(t).append("\n");
            int res = set.size()>=K?1:0;
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
N거래일 / K번 구매 / 직전 가격보다 상승했을때만 구매 가능
N,K,가격이 주어졌을떄 위 조건이 가능하다면 1 불가하다면 0 출력
 */