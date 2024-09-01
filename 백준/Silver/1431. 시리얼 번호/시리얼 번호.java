import java.util.*;
import java.io.*;
class Solution {
    static String[][] sn;
    static String[][] sorted;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        sn = new String[2][n];
        sorted = new String[2][n];

        for (int i = 0; i < n; i++) {
            String val = br.readLine();
            sn[0][i] = val;
            int sum = 0;
            for (int j = 0; j < val.length(); j++) {
                char num = val.charAt(j);
                if (num >= '0' && num <= '9') {
                    sum += Character.getNumericValue(num);
                }
            }
            sn[1][i] = String.valueOf(sum);
        }

        mergeSort(0, n - 1);

        for (String s : sn[0]) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }

    public void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);

            for (int i = left; i <= right; i++) {
                sn[0][i] = sorted[0][i];
                sn[1][i] = sorted[1][i];
            }
        }
    }

    public void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (priority(l, r)) {
                sorted[0][idx] = sn[0][l];
                sorted[1][idx++] = sn[1][l++];
            } else {
                sorted[0][idx] = sn[0][r];
                sorted[1][idx++] = sn[1][r++];
            }
        }

        if (l > mid) {
            while (r <= right) {
                sorted[0][idx] = sn[0][r];
                sorted[1][idx++] = sn[1][r++];
            }
        } else {
            while (l <= mid) {
                sorted[0][idx] = sn[0][l];
                sorted[1][idx++] = sn[1][l++];
            }
        }
    }

    public boolean priority(int i, int j) {
        //길이 짧은 것
        if (sn[0][i].length() < sn[0][j].length()) {
            return true;
        } else if (sn[0][i].length() > sn[0][j].length()) {
            return false;
        } else {    //합이 작은 것
            if (Integer.parseInt(sn[1][i]) < Integer.parseInt(sn[1][j])) {
                return true;
            } else if (Integer.parseInt(sn[1][i]) > Integer.parseInt(sn[1][j])) {
                return false;
            } else {    //사전 순
                return sn[0][i].compareTo(sn[0][j]) < 0;
            }
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
길이 짧은 것 우선
숫자 합 작은 것 우선
사전 순 -> 숫자가 알파벳보다 우선
 */