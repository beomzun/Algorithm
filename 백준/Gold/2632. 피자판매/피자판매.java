import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int customer = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] mDP = new int[M+1];
        for(int i=1;i<=M;i++) {
            mDP[i] = mDP[i - 1] + Integer.parseInt(br.readLine());
        }
        int[] nDP = new int[N+1];
        for(int i=1;i<=N;i++) {
            nDP[i] = nDP[i - 1] + Integer.parseInt(br.readLine());
        }

        //트리맵으로 관리
        TreeMap<Integer, Integer> mMap = new TreeMap<>();
        for(int i=1;i<=M;i++) {
            for(int j=0;j<i;j++) {
                int val = mDP[i]-mDP[j];
                mMap.put(val, mMap.getOrDefault(val, 0) + 1);
            }
        }
        for(int i=1;i<M-1;i++) {
            for(int j=i+2;j<=M;j++) {
                int val = mDP[i] + mDP[M] - mDP[j-1];
                mMap.put(val, mMap.getOrDefault(val, 0) + 1);
            }
        }

        TreeMap<Integer, Integer> nMap = new TreeMap<>();
        for(int i=1;i<=N;i++) {
            for(int j=0;j<i;j++) {
                int val = nDP[i]-nDP[j];
                nMap.put(val, nMap.getOrDefault(val, 0) + 1);
            }
        }
        for(int i=1;i<N-1;i++) {
            for(int j=i+2;j<=N;j++) {
                int val = nDP[i] + nDP[N] - nDP[j-1];
                nMap.put(val, nMap.getOrDefault(val, 0) + 1);
            }
        }

        int count = 0;
        for(int key : mMap.keySet()) {
            if (key > customer) {
                break;
            }
            if(key==customer) {
                count+=mMap.get(key);
                continue;
            }
            count += mMap.get(key) * nMap.getOrDefault(customer-key,0);
        }
        for (int key : nMap.keySet()) {
            if(key==customer) {
                count +=nMap.get(key);
            }
        }

        System.out.println(count);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
두 종류의 피자에서 고객이 요청한 크기의 피자를 만드는 조합
dp 누적합으로 크기 구하고 원형 반영해야됨.
1~t~k~N 이면 -> k~N~1~t 반드시 t는 k-1보다 작아야함. t=k-1인 경우 한판이기 때문.
 */