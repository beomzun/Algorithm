import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static int[] numbers;
    static int[] operator = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static char[] order;
    static char EMPTY = ' ';

    public void solution() throws IOException {
        input();
        spot();

        System.out.println(max + "\n" + min);
    }

    public void spot() {
        putPlus(0, 0);
    }
    public void putPlus(int idx, int count) {
        if (count == operator[0]) {
            putMinus(0,0);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            if (order[i] == EMPTY) {
                order[i]='+';
                putPlus(i + 1, count + 1);
                order[i]=EMPTY;
            }
        }
    }
    public void putMinus(int idx, int count) {
        if (count == operator[1]) {
            putMulti(0,0);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            if (order[i] == EMPTY) {
                order[i]='-';
                putMinus(i + 1, count + 1);
                order[i]=EMPTY;
            }
        }
    }
    public void putMulti(int idx, int count) {
        if (count == operator[2]) {
            putDiv(0,0);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            if (order[i] == EMPTY) {
                order[i]='*';
                putMulti(i + 1, count + 1);
                order[i]=EMPTY;
            }
        }
    }
    public void putDiv(int idx, int count) {
        if (count == operator[3]) {
            calculate();
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            if (order[i] == EMPTY) {
                order[i]='/';
                putDiv(i + 1, count + 1);
                order[i]=EMPTY;
            }
        }
    }
    public void calculate() {
        int result = numbers[0];

        for (int i = 0; i < N - 1; i++) {
            if (order[i] == '+') {
                result += numbers[i + 1];
                continue;
            }
            if (order[i] == '-') {
                result -= numbers[i + 1];
                continue;
            }
            if (order[i] == '*') {
                result *= numbers[i + 1];
                continue;
            }
            result /= numbers[i + 1];
        }

        min = Math.min(min, result);
        max = Math.max(max, result);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        order = new char[N-1];

        for (int i = 0; i < N - 1; i++) {
            order[i] = EMPTY;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i]=Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
최대 수 11개 -> 연산자 10개 -> 10C3 * 7C3 * 4C2 = 120 * 35 * 6 = 120 * 210 = 25200
 */