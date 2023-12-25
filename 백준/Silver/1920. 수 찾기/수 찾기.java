import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

    public static int[] tmpArr = new int[100000];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] narr = new int[n];
        for (int i = 0; i < n; i++) {
            narr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(narr, 0, n - 1);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            bw.write(binarySearch(narr, 0, n - 1, Integer.parseInt(st.nextToken()))+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static void mergeSort(int[] arr, int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        //분할된 왼쪽 리스트의 시작 변수
        int leftIndex = left;
        //분할된 오른쪽 리스트의 시작 변수
        int rightIndex = mid + 1;
        //정렬된 데이터 저장할 인덱스 변수
        int sortedIndex = left;
        //정렬된 데이터 저장할 임시 배열

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

    public static int binarySearch(int[] arr, int low, int high, int key) {
        int mid;

        if (low <= high) {
            mid = (low + high) / 2;
            if (key == arr[mid]) {
                return 1;
            } else if (key < arr[mid]) {
                return binarySearch(arr, low, mid - 1, key);
            } else {
                return binarySearch(arr, mid + 1, high, key);
            }
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
