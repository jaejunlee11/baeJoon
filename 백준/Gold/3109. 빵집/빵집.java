/*
 * 문제
 * 1. R*C 의 격자 존재 10000 * 500
 * 2. 빵집 존재 -> 첫번째 열, 마지막이 우리 빵집 비어있음
 * 3. 건물에는 파이프 설치 불가
 * 4. 오른쪽, 오른쪽 위 대각, 오른쪽 아래 대각으로 연결 가능 => 무조건 오른쪽
 * 5. 가스관과 빵집을 연결하는 최대 파이프 갯수 구하기
 * 
 * 풀이
 * 1. R,C입력
 * 2. arr[R][C]만들기 및 입력
 * 3. 한열씩 생각 => 각 열에서 최대한 많이 살아 남는 것을 생각
 * 4.for문으로 모든 열 돌기
 * 	4.1. 초기 live[c] = 전부 1
 * 	4.2.0. live를 lived에 복제
 * 	4.2. arr[i][j]의 값이 X인 경우 파이프가 못 감 -> live[j] =0
 * 	4.3. arr[i][j]가 .인 경우 이전 lived[j-1]값이 1이면 1 => lived[j-1]=0, j,j+1까지
 * 5. 최종 live의 갯수 출력 
 */
import java.io.*;
import java.util.*;

public class Main {
	static int R;
	static int C;
	static boolean[][] visited;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[R][C];
		arr = new int[R][C];
		for(int i = 0;i<R;i++) {
			String temp = br.readLine();
			for(int j = 0;j<C;j++) {
				if(temp.charAt(j)=='.') {
					arr[i][j]=0;
				}else {
					arr[i][j]=1;
				}
			}
		}
		int answer = 0;
		for(int i = 0;i<R;i++) {
			if(dfs(0,i))answer++;
		}
		System.out.println(answer);
	}
	static boolean dfs(int depth,int r) {
		if(depth==C-1) {
			return true;
		}
		for(int k =-1;k<2;k++) {
			if(r+k<0 || r+k>=R || arr[r+k][depth+1]==1 || visited[r+k][depth+1]) continue;
			visited[r+k][depth+1] = true;
			if(dfs(depth+1,r+k)) return true;
//			visited[r+k][depth+1] = false;
		}
		return false;
	}
}
//15 15
//.xxxxxxxxxx....
//...x.......xxx.
//...x.......x...
//..xx.......xx..
//...x........xx.
//.x.x......x.x..
//...x......xx...
//.x.x....xxx....
//.x....x.x......
//.x.....xx.x....
//.x..x.xx.......
//.....xx........
//....x..........
//......x........
//...............