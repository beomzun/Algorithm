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

    public static int[][] tmpArr = new int[2][100000];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, n-1);

        for (int i = 0; i < n; i++) {
            bw.write(arr[0][i] + " ");
            bw.write(arr[1][i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    public void mergeSort(int[][] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[][] arr, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int sortedIndex = left;

        while (leftIndex <= mid && rightIndex <= right) {
            if (arr[0][leftIndex] < arr[0][rightIndex]) {
                tmpArr[0][sortedIndex] = arr[0][leftIndex];
                tmpArr[1][sortedIndex++] = arr[1][leftIndex++];
            } else if (arr[0][leftIndex] == arr[0][rightIndex]) {
                if (arr[1][leftIndex] < arr[1][rightIndex]) {
                    tmpArr[0][sortedIndex] = arr[0][leftIndex];
                    tmpArr[1][sortedIndex++] = arr[1][leftIndex++];
                } else {
                    tmpArr[0][sortedIndex] = arr[0][rightIndex];
                    tmpArr[1][sortedIndex++] = arr[1][rightIndex++];
                }
            } else {
                tmpArr[0][sortedIndex] = arr[0][rightIndex];
                tmpArr[1][sortedIndex++] = arr[1][rightIndex++];
            }
        }

        if (leftIndex > mid) {
            for (int i = rightIndex; i <= right; i++) {
                tmpArr[0][sortedIndex] = arr[0][i];
                tmpArr[1][sortedIndex++] = arr[1][i];
            }
        } else {
            for (int i = leftIndex; i <= mid; i++) {
                tmpArr[0][sortedIndex] = arr[0][i];
                tmpArr[1][sortedIndex++] = arr[1][i];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[0][i] = tmpArr[0][i];
            arr[1][i] = tmpArr[1][i];
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}