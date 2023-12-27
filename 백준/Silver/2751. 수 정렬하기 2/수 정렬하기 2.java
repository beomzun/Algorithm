import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {

    public static int[] tmpArr = new int[1000000];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] sort = new int[n];
        for (int i = 0; i < n; i++) {
            sort[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(sort, 0, n - 1);
        for (int i = 0; i < n; i++) {
            bw.write(sort[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int sortedIndex = left;

        while (leftIndex <= mid && rightIndex <= right) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                tmpArr[sortedIndex++] = arr[leftIndex++];
            } else {
                tmpArr[sortedIndex++] = arr[rightIndex++];
            }
        }

        if (leftIndex > mid) {
            for (int i = rightIndex; i <= right; i++) {
                tmpArr[sortedIndex++] = arr[i];
            }
        } else {
            for (int i = leftIndex; i <= mid; i++) {
                tmpArr[sortedIndex++] = arr[i];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmpArr[i];
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}