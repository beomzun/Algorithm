import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age == o2.age) {
                    return o1.order - o2.order;
                }
                return o1.age-o2.age;
            }
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            pq.add(new Person(age, i, name));
        }

        while(!pq.isEmpty()) {
            Person person = pq.remove();
            bw.write(person.age + " " + person.name + "\n");
        }

        bw.flush();
        bw.close();
    }
}
class Person {
    int age;
    int order;
    String name;
    Person(int age, int order, String name) {
        this.age = age;
        this.order = order;
        this.name = name;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}