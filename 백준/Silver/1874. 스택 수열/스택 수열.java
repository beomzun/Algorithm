import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static int[] tar;
    public static int max = 0;
    public static int max_id = 0;
    public static int i, j;
    public static Stack<Integer> tmp = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tar = new int[n];
        //목표 수열
        for (i = 0; i < n; i++) {
            tar[i] = Integer.parseInt(br.readLine());
        }
        cal();
        br.close();
    }

    public static void cal() {
        StringBuilder sb = new StringBuilder();
        //NO처리 -> 기준보다 큰 수가 나오기 전까진 내림차순이어야함.
        for (i = 0; i < tar.length; i++) {
            if (tar[i] > max) {
                for (j = max+1; j <= tar[i]; j++) {
                    tmp.push(j);
                    sb.append('+').append('\n');
                }
                max = tar[i];
            } else if(tmp.peek()!=tar[i]) {
                System.out.println("NO");
                return;
            }

            tmp.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}