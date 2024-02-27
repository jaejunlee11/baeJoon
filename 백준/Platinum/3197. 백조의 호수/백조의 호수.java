/*
 * 문제
 * 1. 빙하와 일반땅이 존재
 * 2. 빙하가 일반땅과 접촉하면 빙하가 녹음(가로 세로)
 * 3. 사람은 일반땅에서만 이동 가능(가로 세로)
 * 4. 사람이 만날 수 있게 되는데 얼마나 걸리는가
 * 
 * 풀이
 * 1. R,C입력 -> 가로 세로(1500)
 * 2. arr[R][C]생성
 * 3. arr채우기 -> L위치 기록(1명만)
 * 4. while돌리기 
 *  4.0. L부터 .을 통해서 bfs탐색 후 다른 L에 도착시  -> count출력 후 종료
 * 	4.1. count++
 * 	4.2. 판을 전부 탐색
 * 	4.3. X인 구역을 4방 탐색하여 주변에 .또는 L이 있으면 check
 * 	4.4. check인 구역 녹이기
 * 
 * bfs
 * 1. L위치 que에 담기
 * 2. visited체크
 * 3. while -> 큐 빌때 까지
 * 	3.1. poll
 * 	3.2. 4방 탐색 -> visited후 que에 넣기
 * 
 * 시간 복잡도
 * 1. (1500 * 1500 * 4 + 1500 * 1500) * 1500 => 270억?
 * 2. 판이 전부 빙하로 차는 것은 아님 + 모든 빙하를 4방 탐색하지는 않음 + bfs도 항상 모든 판을 탐색하지 않음 => 충분할 듯
 * 
 * 시간초과 발생하는 듯
 * 다른 풀이
 * 1. 녹을 빙하를 미리 큐에 담아 놓기?
 * 2. 다음 빙하는 녹은 빙하와 닿아있는 빙하
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] arr = new char[R][C];
		int lR = 0;
		int lC = 0;
		for(int i = 0;i<R;i++) {
			String temp = br.readLine();
			for(int j = 0;j<C;j++) {
				char letter = temp.charAt(j);
				if(letter == 'L') {
					lR = i;
					lC = j;
				}
				arr[i][j] = letter;
			}
		}
		boolean[][] iceVisited = new boolean[R][C];
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		Deque<int[]> iced = new ArrayDeque<>();
		for(int i = 0;i<R;i++) {
			A : for(int j = 0;j<C;j++) {
				if(arr[i][j]=='X') {
					for(int k = 0;k<4;k++) {
						int nr = i + dir[k][0];
						int nc = j + dir[k][1];
						if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
						if(arr[nr][nc]=='.' || arr[nr][nc] == 'L') {
							iced.add(new int[] {i,j});
							iceVisited[i][j] = true;
							continue A;
						}
					}
				}
			}
		}

		int count = 0;
		Deque<int[]> que = new ArrayDeque<>();
		que.add(new int[] {lR,lC});
		boolean[][] visited = new boolean[R][C];
		visited[lR][lC] = true;
		while(true) {
			boolean[][] visited2 = new boolean[R][C];
			Deque<int[]> que2 = new ArrayDeque<>(); //que2의 생성 위치 변경
			while(!que.isEmpty()) {
					int[] loc = que.poll();
					int r = loc[0];
					int c = loc[1];
					for(int k = 0;k<4;k++) {
						int nr = r + dir[k][0];
						int nc = c + dir[k][1];
						if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
						if(visited[nr][nc]) continue;
						if(arr[nr][nc]=='.') {
							visited[nr][nc] = true;
							que.add(new int[] {nr,nc});
						}else if(arr[nr][nc]=='X' && visited2[nr][nc]==false) {
							visited2[nr][nc] = true;
							que2.add(new int[] {nr,nc});
						}
						if(arr[nr][nc] == 'L') {
							System.out.println(count);
							return;
						}
					}
			}
			que = que2;
			count++;
			Deque<int[]> ice = new ArrayDeque<>();
			while(!iced.isEmpty()) {
				int[] loc = iced.poll();
				int r = loc[0];
				int c = loc[1];
				arr[r][c]='.';
				for(int k = 0;k<4;k++) {
					int nr = r + dir[k][0];
					int nc = c + dir[k][1];
					if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
					if(iceVisited[nr][nc]) continue;
					if(arr[nr][nc]=='X') {
						iceVisited[nr][nc] = true;
						ice.add(new int[] {nr,nc});
					}
				}
			}
			iced = ice;
		}
	}
}