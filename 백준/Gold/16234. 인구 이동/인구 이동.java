/*
 * 문제
 * 1. N*N 땅존재
 * 2. 국경선이 만나고 L명 이상 R명 이하이면 국경선을 염
 * 3. 국경선이 인접 열려있으면 연합
 * 4. 연합이 끝나면 똑같이 인구가 나눠짐
 * 5. 이동이 끝나는 날짜
 * 
 *  풀이
 *  1. N, L,R입력
 *  2. arr[N][N] 생성
 *  3. arr 채우기
 *  4. while 돌기
 *  	4.1. for문으로 arr 돌기
 *  		4.1.1. visited면 pass
 *  		4.1.2. sum=0 + bfs 탐색 => 4방 탐색을 진행하면서 L,R차이 확인, 다른 que에 담으면서 진행 (이때 flag)+ 값 합치기
 *  		4.1.3. 다른 que를 순회하면서 값을 꺼내고 sum/que사이즈로 채우기
 *  	4.2. flag가 true면 break; 아니면 day++, 
 *  5. day 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for(int i = 0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		int day = 0;
		while(true) {
			boolean flag = false;
			boolean[][] visited = new boolean[N][N];
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					if(visited[i][j]) continue;
					int sum = 0;
					Deque<int[]> que = new ArrayDeque<>();
					Deque<int[]> quer = new ArrayDeque<>();
					sum+=arr[i][j];
					visited[i][j]=true;
					que.add(new int[] {i,j});
					while(!que.isEmpty()) {
						int[] loc = que.poll();
						quer.add(loc);
						int r = loc[0];
						int c = loc[1];
						for(int k = 0;k<4;k++) {
							int nr = r + dir[k][0];
							int nc = c + dir[k][1];
							if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
							if(visited[nr][nc]) continue;
							int temp = Math.abs(arr[nr][nc]-arr[r][c]);
							if(temp<=R && temp>=L) {
								visited[nr][nc] = true;
								sum+=arr[nr][nc];
								que.add(new int[] {nr,nc});
//								System.out.println(nr + " " + nc);
								flag = true;
							}
						}
					}
					int size = quer.size();
					int cal = sum/size;
					while(!quer.isEmpty()) {
						int[] loc = quer.poll();
						arr[loc[0]][loc[1]] = cal;
					}
				}
			}
			if(flag) {
				day++;
			}else {
				break;
			}
		}
		System.out.println(day);
	}
}