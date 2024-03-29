/*
 * 문제
 * 1. 치즈가 존재
 * 2. 치즈가 바깥과 2변 이상 노출 되어있으면 녹은
 * 3. 다 녹는데 걸리는 시간은?
 * 
 * 플이
 * 1. N,M입력
 * 2. arr[N][M]생성
 * 3. arr채우기 => cheeseCount
 * 3. cheeseque 생성 => 0,0넣어주기
 * 4. while돌리기 => time
 * 	4.0. time++
 * 	4.1.bfs로 탐색 =>0타고 이동
 * 		4.1.1. 1을 만나면 +1해주기
 * 		4.1.2. 2를 만나면 치즈큐에 담아주기 + cheeseCount-- => 0이되면 time출력 후 종료
 * 
 * bfs
 * 1. que에 cheeseQue 넣기
 * 2. cheeseQue 새로 생성
 * 3. wile돌리기
 * 	3.1. que에서 꺼내기
 * 	3.2. 4방 탐색
 * 		3.2.1. 경계체크
 * 		3.2.2. visited체크
 * 		3.2.3. 값이 0인 경우=> visited 후 큐에 넣기 , 값이 1인 경우 => 해당값 +1, 값이 2인 경우 => 0으로 변경 후 visited체크 후 cheeseque에 넣기
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int cheeseCount = 0;
		for(int i = 0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) cheeseCount++;
			}
		}
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		int time = 0;
		Deque<int[]> cheeseQue = new ArrayDeque<>();
		cheeseQue.add(new int[] {0,0});
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		while(true) {
			time++;
			Deque<int[]> que = cheeseQue;
			cheeseQue = new ArrayDeque<>();
			while(!que.isEmpty()) {
				int[] loc = que.poll();
				for(int k = 0;k<4;k++) {
					int nr = loc[0]+dir[k][0];
					int nc = loc[1]+dir[k][1];
					if(nr<0||nc<0||nr>=N||nc>=M) continue;
					if(visited[nr][nc]) continue;
					if(arr[nr][nc]==0) {
						visited[nr][nc] = true;
						que.add(new int[] {nr,nc});
						arr[nr][nc] =0;
					}
					else if(arr[nr][nc]==2) {
						visited[nr][nc] = true;
						cheeseQue.add(new int[] {nr,nc});
						arr[nr][nc] =0;
						cheeseCount--;
						if(cheeseCount==0) {
							System.out.println(time);
							return;
						}
					}else if(arr[nr][nc]==1) {
						arr[nr][nc] =2;
					}
				}
			}
		}
	}
}