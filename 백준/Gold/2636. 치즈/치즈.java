/*
 * 문제
 * 1. 치즈가 존재
 * 2. 치즈가 막혀있으면 안녹음
 * 3. 아닌 경우 사라짐
 * 4. 치즈가 녹는데 걸리는 시간과 마지막 치즈에 갯수 출력
 * 
 * 풀이
 * 1. 치즈판의 크기 입력 N,M
 * 2. 치즈판 배열 만들기 -> arr[N][M]
 * 3. 치즈판 채우기
 * 4. 밖과 접촉하는 치즈가 녹음 0,0을 넣음
 * 5. while돌리기 ()
 * 	5.0. 0에 대해서 탐색 시작
 * 		5.0.1. visited체크를 하면서
 * 		5.0.2. 큐2에 1인 친구를 넣기 + visited체크
 * 	5.1. 큐2 size체크 => 저장 0이면 종료
 * 	5.2. 큐로 큐2 이동 
 * 6.저장값 출력
 * 
 * 시간 복잡도 
 * 10000 * 10000 =1억 정도 충분
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i =0 ;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Deque<int[]> que1 = new ArrayDeque<>();
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		boolean[][] visited = new boolean[N][M];
		que1.add(new int[] {0,0});
		visited[0][0] = true;
		int count = 0;
		int time = -1;
		while(true) {
			time++;
			Deque<int[]> que2 = new ArrayDeque<>();
			while(!que1.isEmpty()) {
				int[] loc = que1.poll();
				for(int k = 0;k<4;k++) {
					int nr = loc[0] + dir[k][0];
					int nc = loc[1] + dir[k][1];
					if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
					if(visited[nr][nc]) continue;
					visited[nr][nc]=true;
					if(arr[nr][nc]==1) {
						que2.add(new int[] {nr,nc});
						continue;
					}
					if(arr[nr][nc]==0) que1.add(new int[] {nr,nc});
				}
			}
			if(que2.size()==0) {
				System.out.println(time);
				System.out.println(count);
				return;
			}else {
				count = que2.size();
				que1 = que2;
			}
		}
	}
}