import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

    public static int[] tmpArr = new int[300000];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arr, 0, n - 1);

        int dif = 0;
        int minus = (int) Math.round(0.15 * n);
        for (int i = minus; i < n - minus; i++) {
            dif += arr[i];
        }
        dif = Math.round((float) dif / (n - 2 * minus));
        bw.write(dif + "\n");
        bw.flush();
        bw.close();
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {
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