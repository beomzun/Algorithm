import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {

    public static String[] tmp = new String[500000];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        mergeSort(arr, 0, n - 1);

        String[] ans = new String[n];
        int idx = -1;

        for (int i = 0; i < m; i++) {
            String key = br.readLine();
            if (binarySearch(arr, key, 0, n - 1)) {
                ans[++idx] = key;
            }
        }

        mergeSort(ans, 0, idx);

        bw.write(idx + 1 + "\n");
        for (int i = 0; i <= idx; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(String[] arr, int left, int mid, int right) {
        int leftIdx = left;
        int rightIdx = mid + 1;
        int sortIdx = left;
        while (leftIdx <= mid && rightIdx <= right) {
            if (arr[leftIdx].compareTo(arr[rightIdx]) <= 0) {
                tmp[sortIdx++] = arr[leftIdx++];
            } else {
                tmp[sortIdx++] = arr[rightIdx++];
            }
        }
        if (leftIdx > mid) {
            for (int i = rightIdx; i <= right; i++) {
                tmp[sortIdx++] = arr[i];
            }
        } else {
            for (int i = leftIdx; i <= mid; i++) {
                tmp[sortIdx++] = arr[i];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }

    public static boolean binarySearch(String[] arr, String key, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (key.equals(arr[mid])) {
                return true;
            } else if (key.compareTo(arr[mid]) < 0) {
                return binarySearch(arr, key, low, mid - 1);
            } else {
                return binarySearch(arr, key, mid + 1, high);
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}