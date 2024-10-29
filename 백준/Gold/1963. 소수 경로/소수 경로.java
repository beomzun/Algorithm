import java.util.*;
import java.io.*;
class Solution {
    static BufferedWriter bw;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] primeCount = new int[10000];
        //소수면 0 아니면 -1
        for (int i = 2; i <= 9999; i++) {
            if (primeCount[i] == -1) {
                continue;
            }
            for (int j = i * 2; j <= 9999; j += i) {
                primeCount[j] = -1;
            }
        }
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();
            int startNum = Integer.parseInt(start);
            int endNum = Integer.parseInt(end);
            findStart(end, primeCount, endNum, startNum);
        }
        bw.flush();
        bw.close();
    }

    private void findStart(String end, int[] basePrimeCount, int endNum, int startNum) throws IOException {
        if (startNum == endNum) {
            bw.write(0 + "\n");
            return;
        }
        int[] primeCount = Arrays.copyOf(basePrimeCount, basePrimeCount.length);
        Queue<String> primes = new ArrayDeque<>();
        primes.add(end);
        while (!primes.isEmpty()) {
            String base = primes.remove();
            int baseNum = Integer.parseInt(base);
            for (int i = 0; i < 4; i++) {
                char[] tmp = base.toCharArray();
                for (int j = i == 0 ? 1 : 0; j < 10; j++) {
                    tmp[i] = Character.forDigit(j, 10);
                    int tmpNum = Integer.parseInt(String.valueOf(tmp));
                    if (primeCount[tmpNum] == 0) {
                        if (tmpNum == endNum) {
                            continue;
                        }
                        primeCount[tmpNum] = primeCount[baseNum] + 1;
                        if (tmpNum == startNum) {
                            bw.write(primeCount[tmpNum] + "\n");
                            return;
                        }
                        primes.add(String.valueOf(tmpNum));
                    }
                }
            }
        }
        bw.write("Impossible\n");
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
