/*
 * 문제
 * 1. 그림이 주어짐 -> RGB로 이루어져있음
 * 2. 같은 색상이 상하좌우로 인접 -> 같은 구역 
 * 
 * 풀이
 * 1.그림판 크기 N 입력
 * 2. 그림판 arr[N][N]생성 + check배열 생성 check[N][N]
 * 3. 그림판 입력 받기 -> R,G,B
 * 4. for문으로 모든 좌표 순회
 * 	4.0.check안된 점 que에 넣기 + count++ + check하기
 * 		4.1. bfs돌리기
 * 			4.1.1. que에서 꺼내기 ->R,G,B
 * 			4.1.2. for문 돌면서 4방 탐색 -> 같은 색이면 check후 que에 담기
 * 
 * dfs풀이
 * 1.그림판 크기 N 입력
 * 2. 그림판 arr[N][N]생성 + check배열 생성 check[N][N]
 * 3. 그림판 입력 받기 -> R,G,B
 * 4. for문으로 모든 좌표 순회
 * 	4.1.check된 좌표 pass
 * 	4.2. dfs(i,j,색)
 * 
 * 
 * dfs(r,c,색)
 * 0. 해당 좌표 check처리
 * 1. for문으로 4방 탐색
 * 	1.1. check인경우 pass, 같은 색이 아닌 경우 pass
 * 	1.2. dfs(nr,nc)
 * 시간 복잡도
 * 1. 100 * 100 -> 충분
 */
import java.io.*;
import java.util.*;

public class Main {
	static char[][] arr;
	static int N;
	static boolean[][] checked;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for(int i = 0 ;i<N;i++) {
			String temp = br.readLine();
			for(int j = 0;j<N;j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		checked = new boolean[N][N];
		int answer = 0;
		for(int i = 0 ;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(checked[i][j]) continue;
				bfs(i,j);
				answer++;
			}
		}
		System.out.print(answer+" ");
		checked = new boolean[N][N];
		answer = 0;
		for(int i = 0 ;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(checked[i][j]) continue;
				bfs2(i,j);
				answer++;
			}
		}
		System.out.println(answer);
	}
	static void bfs(int r, int c) {
		Deque<int[]> que = new ArrayDeque<>();
		que.add(new int[] {r,c});
		checked[r][c]= true;
		while(!que.isEmpty()) {
			int[] loc = que.poll();
			int a = loc[0];
			int b = loc[1];
			char color = arr[a][b];
			for(int k = 0;k<4;k++) {
			int nr = a +dir[k][0];
			int nc = b + dir[k][1];
			if(nr<0 || nc<0 || nr >= N || nc >= N) continue;
			if(arr[nr][nc]!=color) continue;
			if(checked[nr][nc]) continue;
			checked[nr][nc]= true;
			que.add(new int[] {nr,nc});
		}
		}
		
	}
	static void bfs2(int r, int c) {
		Deque<int[]> que = new ArrayDeque<>();
		que.add(new int[] {r,c});
		checked[r][c]= true;
		while(!que.isEmpty()) {
			int[] loc = que.poll();
			int a = loc[0];
			int b = loc[1];
			char color = arr[a][b];
			for(int k = 0;k<4;k++) {
			int nr = a +dir[k][0];
			int nc = b + dir[k][1];
			if(nr<0 || nc<0 || nr >= N || nc >= N) continue;
			if(arr[nr][nc]!='B') {
				if(color=='B') continue;
			}
			if(arr[nr][nc]=='B') {
				if(!(color=='B')) continue;
			}
			if(checked[nr][nc]) continue;
			checked[nr][nc]= true;
			que.add(new int[] {nr,nc});
		}
		}
		
	}
}