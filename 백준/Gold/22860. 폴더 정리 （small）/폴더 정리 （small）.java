import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> parents = new HashMap<>();
        String[] tmp = new String[N + M];
        //폴더 세팅
        for(int i=0;i<N+M;i++) {
            tmp[i] = br.readLine();

            st = new StringTokenizer(tmp[i]);
            String parent = st.nextToken();
            String name = st.nextToken();
            st.nextToken();

            //부모 설정
            parents.put(name, parent);
        }

        Map<String, Map<String, Integer>> library = new HashMap<>();    //폴더명 / 파일명, 파일 개수
        //개수 파악
        for(int i=0;i<N+M;i++) {
            st = new StringTokenizer(tmp[i]);
            String parent = st.nextToken();
            String name = st.nextToken();
            boolean isFolder = Integer.parseInt(st.nextToken()) == 1;

            if (isFolder) {
                continue;
            }

            while(true) {
                //부모 폴더 존재
                if (library.containsKey(parent)) {
                    library.get(parent).put(name, library.get(parent).getOrDefault(name, 0) + 1);
                } else {
                    Map<String, Integer> child = new HashMap<>();
                    child.put(name, 1);
                    library.put(parent, child);
                }

                if (parent.equals("main")) {
                    break;
                }
                parent = parents.getOrDefault(parent, "main");
            }
        }

        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        for(int i=0;i<Q;i++) {
            String[] path = br.readLine().split("/");
            String last = path[path.length - 1];
            if (!library.containsKey(last)) {
                sb.append(0).append(" ").append(0).append("\n");
            } else {
                int count = 0;
                for (String file : library.get(last).keySet()) {
                    count += library.get(last).get(file);
                }
                sb.append(library.get(last).size()).append(" ").append(count).append("\n");
            }
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
폴더에는 여러 폴더와 파일이 존재한다.
폴더/파일의 정보가 주어졌을 때, 폴더의 정보를 묻는 쿼리에 내부파일의 종류와 개수를 출력하라
---
총 폴더 개수 / 총 파일 개수
상위 폴더이름, 폴더/파일 이름, 폴더 여부(폴더면 1)
쿼리 개수
main 부터의 폴더 경로 정보
 */