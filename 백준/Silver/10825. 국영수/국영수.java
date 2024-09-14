import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Student> students = new PriorityQueue<>((s1, s2) -> {
            if (s1.kor == s2.kor) {
                if (s1.eng == s2.eng) {
                    if (s1.math == s2.math) {
                        return s1.name.compareTo(s2.name);
                    }
                    return s2.math - s1.math;
                }
                return s1.eng - s2.eng;
            }
            return s2.kor - s1.kor;
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students.add(new Student(name, kor, eng, math));
        }
        while (!students.isEmpty()) {
            bw.write(students.remove().name + "\n");
        }
        bw.flush();
        bw.close();
    }
}
class Student {
    String name;
    int kor;
    int eng;
    int math;

    Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
