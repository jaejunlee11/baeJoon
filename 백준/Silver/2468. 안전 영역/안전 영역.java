/*
 * 문제
 * 1. 비가오면 특정 숫자 이하의 값들은 전부 잠김
 * 2. 잠기지 않은 구역들의 갯수 세기
 * 3. 안전한 영역의 갯수의 최대값 구하기
 * 
 * 풀이
 * 1. N 입력
 * 2. arr[N][N]생성
 * 3. arr 채우기 => 최대값 구하기
 * 4. for문 돌리기 K (1~최대값 까지) count=0으로 매번 초기화
 * 	4.1.1. arr탐색
 * 		4.1.1.1. visited가 아니고 K>arr[i][j]인 경우
 * 		4.1.1.2 bfs 탐색을 하면서 visited 처리
 * 		4.1.1.3. count++
 * 	4.1.2. answer 갱신
 * 5. anser 출력 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int maxValue = 0;
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxValue = Math.max(maxValue, arr[i][j]);
			}
		}
		int answer = 1;
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		for(int k = 1; k<=maxValue;k++) {
			int count = 0;
			boolean[][] visited = new boolean[N][N];
			for(int i = 0 ;i<N;i++) {
				for(int j = 0;j<N;j++) {
					if(visited[i][j]) continue;
					if(arr[i][j]<=k) continue;
					Deque<int[]> que = new ArrayDeque<>();
					que.add(new int[] {i,j});
					visited[i][j] = true;
					while(!que.isEmpty()) {
						int[] loc = que.poll();
						for(int s = 0;s<4;s++) {
							int nr = loc[0] + dir[s][0];
							int nc = loc[1] + dir[s][1];
							if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
							if(visited[nr][nc]) continue;
							if(arr[nr][nc]<=k) continue;
							visited[nr][nc] = true;
							que.add(new int[] {nr,nc});
						}
					}
					count++;
				}
			}
			answer = Math.max(answer, count);
		}
		System.out.println(answer);
	}
}