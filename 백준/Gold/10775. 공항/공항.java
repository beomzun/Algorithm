import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        TreeSet<Integer> restGates = new TreeSet<>();
        for(int i=1;i<=G;i++) {
            restGates.add(i);
        }

        int count=0;
        for(int i=0;i<P;i++) {
            int nowNum = Integer.parseInt(br.readLine());
            Integer maxNum = restGates.floor(nowNum);
            if(maxNum==null) {
                break;
            }
            restGates.remove(maxNum);
            count++;
        }

        System.out.println(count);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
신승원 생일ㅊㅊ. 박승원 부자인듯. 공항을 선물로 증정.
공항 게이트는 G개. P개의 비행기가 순서대로 도착.
각 비행기가 도킹할수있는 최대 게이트번호가 주어짐.
최대로 비행기 도킹시키는 개수.
먼놈부터 배치하기.
1 1 3 4 일 때 게이트가 4개라면, 순서가 상관이 없다면 4 3 1 3개가 가능하지만, 순서가 있기에 최대개수는 1.
TreeSet에서 이번 비행기 최대 게이트번호보다 작은 것 중에 제일 큰 번호 out.
 */