import java.io.*;
import java.util.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String key, val;
        for (int i = 0; i < test; i++) {
            int count = 0;
            int n = Integer.parseInt(br.readLine());
            //n번 집합
            Map<Integer, ArrayList<String>> listMap = new HashMap<>();
            //몇 번 집합인가
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                key = st.nextToken();
                val = st.nextToken();

                // 두 친구 중 최소 한 명이 이미 속해있다면
                if (map.containsKey(key) || map.containsKey(val)) {
                    if (map.get(key) == null) {
                        map.put(key, map.get(val));
                        listMap.get(map.get(val)).add(key);
                    } else if (map.get(val) == null) {
                        map.put(val, map.get(key));
                        listMap.get(map.get(key)).add(val);
                    } else if (!map.get(key).equals(map.get(val))) { //두 친구가 기존에 다른 쪽에 속해있었다면
                        if (listMap.get(map.get(key)).size() > listMap.get(map.get(val)).size()) {
                            listMap.get(map.get(key)).addAll(listMap.remove(map.get(val)));
                            for (String s : listMap.get(map.get(key))) {
                                map.put(s, map.get(key));
                            }
                        } else {
                            listMap.get(map.get(val)).addAll(listMap.remove(map.get(key)));
                            for (String s : listMap.get(map.get(val))) {
                                map.put(s, map.get(val));
                            }
                        }
                    }
                } else {
                    listMap.put(++count, new ArrayList<>());
                    listMap.get(count).add(key);
                    listMap.get(count).add(val);
                    map.put(key, count);
                    map.put(val, count);
                }
                bw.write(listMap.get(map.get(key)).size() + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}