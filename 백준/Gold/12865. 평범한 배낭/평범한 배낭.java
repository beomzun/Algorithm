import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Solution {

    class Pack {
        int weigh;
        int value;
        public Pack(int weigh, int value) {
            this.weigh = weigh;
            this.value = value;
        }
    }

    static Pack[] tmp = new Pack[100];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Pack[] arr = new Pack[n];
        int[] ans = new int[k + 1];
        int weigh, value;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weigh = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());
            arr[i] = new Pack(weigh, value);
        }
        //무게 오름차순 정렬
        mergeSort(arr, 0, n - 1);

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= arr[i].weigh; j--) {
                ans[j] = Math.max(ans[j], arr[i].value + ans[j - arr[i].weigh]);
                max = Math.max(max, ans[j]);
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    public static void mergeSort(Pack[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(Pack[] arr, int left, int mid, int right) {
        int lidx = left;
        int ridx = mid + 1;
        int sidx = left;
        while (lidx <= mid && ridx <= right) {
            if (arr[lidx].weigh < arr[ridx].weigh) {
                tmp[sidx++] = arr[lidx++];
            } else {
                tmp[sidx++] = arr[ridx++];
            }
        }
        if (lidx > mid) {
            for (int i = ridx; i <= right; i++) {
                tmp[sidx++] = arr[i];
            }
        } else {
            for (int i = lidx; i <= mid; i++) {
                tmp[sidx++] = arr[i];
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}