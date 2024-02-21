/*
 * 문제
 * 1. 판에 배추가 존재
 * 2. 배추가 이어져 있으면 지렁이 한마리면 충분
 * 3. 지렁이가 몇 마리 필요한가
 * 
 * 풀이
 * 1.T입력 -> 테스트 케이스
 * 2.M,N입력. K 배추 입력
 * 3.arr[N][M]만들기
 * 4. 배추 채우기
 * 5. visited배열 생성
 * 6. for문으로 배추 찾기
 * 	6.1. visited면 PASS
 * 	6.2. que에 담기 -> bfs돌리기 -> count++
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case =0;test_case<T;test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][M];
			for(int i = 0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[b][a] =1;
			}
			boolean[][] visited = new boolean[N][M];
			int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
			int count = 0;
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<M;j++) {
					if(visited[i][j]) continue;
					visited[i][j] = true;
					if(arr[i][j]==1) {
						count++;
						Deque<int[]> que = new ArrayDeque<>();
						que.add(new int[] {i,j});
						while(!que.isEmpty()) {
							int[] loc = que.poll();
							for(int k = 0;k<4;k++) {
								int nr = loc[0] + dir[k][0];
								int nc = loc[1] + dir[k][1];
								if(nr<0 || nc <0 || nr>=N || nc>=M) continue;
								if(visited[nr][nc]) continue;
								if(arr[nr][nc]==1) {
									que.add(new int[] {nr,nc});
									visited[nr][nc] = true;
								}
							}
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}