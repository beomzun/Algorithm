import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int[] dy = {1,1,-1,-1};
    static int[] dx = {-1,1,1,-1};
    static int N;
    static int[][] board;
    static int max = -1;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
			board = new int[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            
            max = -1;
            //좌우측열 제외, N-3행이 마지막 시작행 \ 왼쪽 아래로 시작
            //모든 순서는 좌하 우하 우상 좌상
            for(int i=0;i<N-2;i++) {
            	for(int j=1;j<N-1;j++) {
                    //무조건 좌하로 한번은 보내야함.
					Set<Integer> set = new HashSet<>();
                    set.add(board[i][j]);
                    dfs(i+1,j-1,0,set, i, j);
                }
            }
            
            bw.write("#"+test_case+" "+max+"\n");
		}
        bw.flush();
        bw.close();
	}
    
    public static void dfs(int nowY, int nowX, int dir, Set<Integer> set, int startY, int startX) {
        if(nowY==startY && nowX==startX) {
        	max = Math.max(max, set.size());
            return;
        }
        
        if(nowY<0||nowY>=N||nowX<0||nowX>=N) {
        	return;
        }
        Set<Integer> nowSet = copySet(set);
        int nowVal = board[nowY][nowX];
        if(nowSet.contains(nowVal)) {
        	return;
        }
        nowSet.add(nowVal);
        dfs(nowY+dy[dir], nowX+dx[dir], dir, nowSet, startY, startX);
        if(dir!=3) {
        	dfs(nowY+dy[dir+1], nowX+dx[dir+1], dir+1, nowSet, startY, startX);
        }
    }
    
    public static Set copySet(Set<Integer> set) {
		Set<Integer> nowSet = new HashSet<>();
        for(int val : set) {
        	nowSet.add(val);
        }
        return nowSet;
    }
}
/*
한 변의 길이가 N인 정사각형 지역.
디저트 카페 투어는 대각선으로 진행됨.
투어에서 같은 숫자를 지나쳐서는 안됨.
왔던 길 돌아가기 안됨.
=> 최대 길이 구하기. 투어 불가하면 -1

50개 케이스에 3초
케이스 하나에 0.06초 => 6백만
최대 N = 20
시작 경우의 수 = N*N = 400
한번 최대로 훑기 = (N-1)*2 + ... + (N-(N-2))* 2 => N-2번 => 38+ 36... + 4 = 42 * 8 = 300

*/