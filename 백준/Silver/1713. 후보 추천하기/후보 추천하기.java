import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int Q = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time = new int[101];
        Map<Integer, Integer> votes = new HashMap<>();  //후보번호, 획득 수
        TreeMap<Integer, Set<Integer>> alt = new TreeMap<>();     //획득수, 후보번호 set
        for(int i=0;i<Q;i++) {
            int num = Integer.parseInt(st.nextToken());
            //투표받은적이 있다면
            if (votes.containsKey(num)) {
                int count = votes.get(num);

                alt.get(count).remove(num);
                if (alt.get(count).isEmpty()) {
                    alt.remove(count);
                }

                if (alt.containsKey(count + 1)) {
                    alt.get(count + 1).add(num);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(num);
                    alt.put(count + 1, set);
                }

                votes.put(num, votes.get(num) + 1);
            } else {//받은적이 없다면
                time[num] = i+1;
                //사진첩이 풀이면
                if(votes.size()==N) {
                    int minCount = alt.firstKey();
                    int minTime = i+1;
                    int target = 0;
                    for (int past : alt.get(minCount)) {
                        if(time[past] < minTime) {
                            minTime = time[past];
                            target = past;
                        }
                    }
                    alt.get(minCount).remove(target);
                    if (alt.get(minCount).isEmpty()) {
                        alt.remove(minCount);
                    }
                    votes.remove(target);
                }

                votes.put(num, 1);
                if (alt.containsKey(1)) {
                    alt.get(1).add(num);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(num);
                    alt.put(1, set);
                }
            }
        }

        int[] answer = new int[Math.min(N, votes.size())];
        int idx=0;
        for (int num : votes.keySet()) {
            answer[idx] = num;
            idx++;
        }
        Arrays.sort(answer);

        StringBuilder sb = new StringBuilder();
        for(int num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
최종후보 수
전체 추천 수
추천번호
---
추천받으면 등록됨. 사진이 꽉찼으면 투표수 적은 후보 삭제. 적은 후보가 둘 이상이면 먼저 게시된 후보 삭제
최종후보 번호 오름차순 출력
---
투표수 관리 treemap => 획득수, 후보번호 set
후보수 관리 map => 후보번호, 획득수
 */