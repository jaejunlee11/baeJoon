import java.io.*;
import java.util.*;
/*
 * 문제
 * 1. 지도가 주어짐 => n,m
 * 2. 가로 세로만 이동 가능
 * 3. 0은 못가는 곳, 1은 갈 수 있는 곳, 2는 목표점
 * 4. 0은 0, 1은 목표점과의 거리, 못가는 1은 -1 입력
 * 
 * 풀이
 * 1. n,m 입력
 * 2. arr[n][m]생성, answer[n][m]생성 
 * 3. arr 채우기 => 2인 좌표 저장 sr, sc => answer에 0인 지점 -2 담
 * 4. que생성 => sr,sc담기 ,visited[n][m] 생성 ,sr,sc는 visted처리 
 * 5. while 돌리기 => que 빌 때 까지, count = -1 
 * 	5.1. que 갯수 세기 , count ++
 * 	5.2. for문 돌리기 => que 갯수
 * 		5.2.1. que 에서 꺼내기 => r,c => answer[r][c] = count  
 * 		5.2.2. for문 돌리기 => 4방
 * 			5.2.2.1. 경계 체크 
 * 			5.2.2.2. visited체크
 * 			5.2.2.3. visited처리
 * 			5.2.2.4.  que.add(nr,nc)
 * 6. answer 탐색
 * 	6.1. -2는 0, 0은 -1담기 
 */
public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		int[][] answer = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		int sr = 0;
		int sc = 0;
		for(int i = 0 ;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 2) {
					sr = i;
					sc = j;
				}
				arr[i][j] = temp;
				if(temp == 0) {
					answer[i][j]=-2;
				}
			}
		}
		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.add(new int[] {sr,sc});
		visited[sr][sc] = true;
		int count = -1;
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		while(!que.isEmpty()) {
			int size = que.size();
			count++;
			for(int i = 0;i<size;i++) {
				int[] loc = que.poll();
				answer[loc[0]][loc[1]] = count;
				for(int k = 0;k<4;k++) {
					int nr = loc[0] + dir[k][0];
					int nc = loc[1] + dir[k][1];
					if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
					if(visited[nr][nc]) continue;
					if(arr[nr][nc]==0) continue;
					visited[nr][nc] = true;
					que.add(new int[] {nr,nc});
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<n;i++) {
			for(int j = 0 ;j<m;j++) {
				if(answer[i][j]==0) {
					if(arr[i][j]==2) {
						answer[i][j] = 0;
					}else {
						answer[i][j] = -1;
					}
				}else if(answer[i][j]==-2) {
					answer[i][j]=0;
				}
				sb.append(answer[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}