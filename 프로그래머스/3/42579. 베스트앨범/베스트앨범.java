import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int songCount = genres.length;
        Map<String, Integer> map = new HashMap<>();
        Map<String, PriorityQueue<int[]>> songs = new HashMap<>();
        ArrayList<String> genreList = new ArrayList<>();
        for(int i=0;i<songCount;i++) {
            String genre = genres[i];
            int play = plays[i];
            if(!map.containsKey(genre)) {
                genreList.add(genre);
                songs.put(genre, new PriorityQueue<>((o1,o2)->{
                    if(o2[0]==o1[0]) {
                        return o1[1]-o2[1];
                    }
                    return o2[0]-o1[0];
                }));
            }
            map.put(genre, map.getOrDefault(genre,0)+play);
            songs.get(genre).add(new int[]{play,i});
        }
        Collections.sort(genreList, (g1,g2)->map.get(g2)-map.get(g1));
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(String genre : genreList) {
            PriorityQueue<int[]> nowQ = songs.get(genre);
            int size = nowQ.size();
            for(int i=0;i<Math.min(2,size);i++) {
                answer.add(nowQ.remove()[1]);
            }
        }
        int size = answer.size();
        int[] ans = new int[size];
        for(int i=0;i<size;i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}
/*
노래장르,횟수
장르별 횟수

장르별 두개
장르별 우선순위큐

장르별 총재생수-map

총재생수가 많은 장르부터, 장르 내에서 많이 재생된 노래부터, 번호가 낮은거 부터
*/