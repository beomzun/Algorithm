import java.util.*;
import java.io.*;

class Solution {
    static boolean[] choose;
    static int max=0;
    ArrayList<Integer> A;
    ArrayList<Integer> B;
    ArrayList<Integer> resultA;
    ArrayList<Integer> resultB;
    Map<Integer, int[]> mapA = new HashMap<>();
    static int[][] Dice;
    
    public int[] solution(int[][] dice) {
        Dice = dice;
        choose = new boolean[dice.length];
        //dfs로 주사위 고르기
        dfs(0,0);
        
        return mapA.get(max);
    }
    
    public void dfs(int now, int count) {
        for(int i=now;i<Dice.length;i++) {
            choose[i]=true;
            if (count == Dice.length / 2 - 1) {
                calculate();
            } else {
                dfs(i+1, count+1);
            }
            choose[i]=false;
        }
    }
    
    public void calculate() {
        // 주사위번호 리스트
        A = new ArrayList<>();
        resultA = new ArrayList<>();
        B = new ArrayList<>();
        resultB = new ArrayList<>();
        
        for(int i=0;i<Dice.length;i++) {
            if(choose[i]) {
                A.add(i);
            } else {
                B.add(i);
            }
        }
        
        //A,B 주사위 합 -> 5개 고른 것들 결과배열에 넣고 정렬
        calculateSum(0, 0, 0);
        Collections.sort(resultA);
        Collections.sort(resultB);
        
        //결과
        countSums();
        
    }
    
    public void calculateSum(int idx, int sumA, int sumB) {
        if(idx==Dice.length/2) {
            resultA.add(sumA);
            resultB.add(sumB);
            return;
        }
        
        for(int i=0;i<6;i++) {
            calculateSum(idx+1, sumA+Dice[A.get(idx)][i], sumB+Dice[B.get(idx)][i]);
        }
    }
    
    public void countSums() {
        int count=0;
        int now=0;
        for(int valA : resultA) {
            for(int i=now;i<resultB.size();i++) {
                if (valA <= resultB.get(i)) {
                    count += i;
                    break;
                } else if (i == resultB.size() - 1 && valA > resultB.get(i)) {
                    count += (i + 1);
                    break;
                }
                now++;
            }
        }
        
        if(count > max) {
            max=count;
            int[] arrA = new int[Dice.length/2];
            for(int i=0;i<A.size();i++) {
                arrA[i] = A.get(i)+1;
            }
            Arrays.sort(arrA);
            mapA.put(count, arrA);
        }
    }
}