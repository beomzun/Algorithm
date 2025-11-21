import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int[] out = new int[N+1];
            int[] A = new int[N];
            int[] B = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            int aIdx = 0;
            int bIdx = 0;
            for(int i=0;i<N;i++) {
                while(aIdx<N) {
                    if(out[A[aIdx]]!=0) {
                        aIdx++;
                        continue;
                    }
                    out[A[aIdx]] = 1;
                    aIdx++;
                    break;
                }
                while(bIdx<N) {
                    if(out[B[bIdx]]!=0) {
                        bIdx++;
                        continue;
                    }
                    out[B[bIdx++]] = 2;
                    break;
                }
            }


            for(int i=1;i<=N;i++) {
                if(out[i]==1) {
                    sb.append("A");
                } else {
                    sb.append("B");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}