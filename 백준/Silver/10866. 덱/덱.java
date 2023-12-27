import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {

    public static int[] tmpArr = new int[1000000];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) {
                case "push_front":
                    int front = Integer.parseInt(st.nextToken());
                    deque.addFirst(front);
                    break;
                case "push_back":
                    int back = Integer.parseInt(st.nextToken());
                    deque.addLast(back);
                    break;
                case "pop_front":
                    try {
                        bw.write(deque.removeFirst() + "\n");
                    } catch (NoSuchElementException e) {
                        bw.write(-1 + "\n");
                    }
                    break;
                case "pop_back":
                    try {
                        bw.write(deque.removeLast() + "\n");
                    } catch (NoSuchElementException e) {
                        bw.write(-1 + "\n");
                    }
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;
                case "front":
                    try {
                        bw.write(deque.getFirst() + "\n");
                    } catch (NoSuchElementException e) {
                        bw.write(-1 + "\n");
                    }
                    break;
                case "back":
                    try {
                        bw.write(deque.getLast() + "\n");
                    } catch (NoSuchElementException e) {
                        bw.write(-1 + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}