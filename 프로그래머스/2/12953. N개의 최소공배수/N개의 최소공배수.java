class Solution {
    public int solution(int[] arr) {
        int now = arr[0];
        for(int i=1;i<arr.length;i++) {
            now = getLCM(now, arr[i]);
        }
        return now;
    }
    
    public int getLCM(int a, int b) {
        return a*b / getGCD(a,b);
    }
    
    // 최대공약수 - A=a*d, B=b*d -> A-B = (a-b)*d
    public int getGCD(int a, int b) {
        if(b==0) {
            return a;
        }
        return getGCD(b, a%b);
    }
}

// 100,99,98,97,96,95..86