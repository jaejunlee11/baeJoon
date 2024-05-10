import java.io.*;
import java.util.*;
/*
 * 문제
 * 1. 청소 영역 구하기
 * 2. 현재 칸 청소 => 주변 칸 청소 => 없으면 후진 => 후진 못하면 종료
 * 
 * 풀이
 * 1. N, M 입력
 * 2. r, c, dir 입력 {{-1,0},{0,1},{1,0},{0,-1}}
 * 3. arr[N][M]생성
 * 4. arr채우기
 * 5. visited 생성
 * 6. dfs 돌리기 (r,c,dir)
 * 
 * dfs
 * 1. loc = que.poll
 * 2. for문 돌리기 4,3,2,1
 * 	2.0. 경계 체크
 * 	2.1. nr = r + dir[(k+loc[2]%4)][0] , nc = ..
 * 	2.2. visited확인
 * 	2.3. visited체크
 * 	2.4. dfs(nr,nc,(k+loc[2]%4))
 * 	2.5. return
 * 3. nr = dir[(2+loc[2]%4)][0], ..
 * 4. 경계 체크
 * 	4.1. dfs(nr,nc,dir)
 * 5. return
 */
public class Main {
	static int[][] arr;
	static int N;
	static int M;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[][] visited;
	static int answer = 1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		visited[r][c] = true;
		int d = Integer.parseInt(st.nextToken());
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(r,c,d);
		System.out.println(answer);
	}
	private static boolean dfs(int r, int c, int d) {
//		System.out.println("r: " + r+ " c: "+c + " count: "+answer);
//		for(int i = 0;i<N;i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
		for(int k = 3;k>=0;k--) {
			int nr = r + dir[(k+d)%4][0];
			int nc = c + dir[(k+d)%4][1];
			if(nr>=N || nc>=M || nr<0 || nc<0) continue;
			if(visited[nr][nc]) continue;
			if(arr[nr][nc]==1) continue;
			visited[nr][nc] = true;
			answer++;
			if(dfs(nr,nc,(k+d)%4)) return true;
			return false;
		}
		int nr = r + dir[(2+d)%4][0];
		int nc = c + dir[(2+d)%4][1];
		if(nr>=N || nc>=M || nr<0 || nc<0) return true;
		if(arr[nr][nc]==1) return true;
		if(dfs(nr,nc,d)) return true;
		return false;
	}
}