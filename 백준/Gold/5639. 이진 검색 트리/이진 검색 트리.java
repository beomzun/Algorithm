import java.util.*;
import java.io.*;
class Solution {
    Node root;
    StringBuilder sb = new StringBuilder();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String next = br.readLine();
        if (next == null || next.isEmpty()) {
            return;
        }
        root = new Node(Integer.parseInt(next));
        while(true) {
            next = br.readLine();
            if (next == null || next.isEmpty()) {
                break;
            }
            int val = Integer.parseInt(next);
            put(root, val);
        }

        dfs(root);
        System.out.println(sb);
    }

    public void put(Node now, int val) {
        if (val < now.val) {
            if (now.left == null) {
                now.left = new Node(val);
                return;
            }
            put(now.left, val);
        } else {
            if (now.right == null) {
                now.right = new Node(val);
                return;
            }
            put(now.right, val);
        }
    }

    public void dfs(Node now) {
        if (now == null) {
            return;
        }
        dfs(now.left);
        dfs(now.right);
        sb.append(now.val).append("\n");
    }
}
class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
전위(중좌우)->후위(좌우중)
 */