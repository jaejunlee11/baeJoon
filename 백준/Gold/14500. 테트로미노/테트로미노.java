/*
 * 문제
 * 1. 판이 존재
 * 2. 판에 숫자들이 존재
 * 3. 테트리 미노 한개를 둬서 최대 점수 가져오기
 * 
 * 풀이
 * 1. N,M입력
 * 2. arr[N][M]생성
 * 3. arr채우기
 * 4. arr전부 순회
 * 	4.1. dfs를 depth 4까지 탐색하여 합의 최대값 갱신
 * 	4.2. 중심을 기준으로 3방 탐색 진행 후 최대값 갱신
 * 5. 최대값 출력
 * 
 * dfs(depth,sum)
 * 1. depth==4
 * 	1.1. sum리턴
 * 2.for 4방탐색
 * 	2.1. 경계체크 
 * 	2.2. visited체크
 * 	2.3. dfs(depth+1,sum+arr[nr][nc]
 * 	2.4. visited헤제
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int answer;
	static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
	static int N;
	static int M;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr  = new int[N][M];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MIN_VALUE;
		visited = new boolean[N][M];
		for(int i = 0 ;i<N;i++) {
			for(int j = 0;j<M;j++) {
				visited[i][j] = true;
				dfs(0,i,j,0);
				A : for(int k = 0;k<4;k++) {
					int tempSum =arr[i][j];
					for(int l = 0;l<3;l++) {
						int nr = i + dir[(l+k)%4][0];
						int nc = j + dir[(l+k)%4][1];
						if(nr<0 || nc < 0 || nr>=N || nc>= M) continue A;
						tempSum += arr[nr][nc];
					}
					
					if(tempSum>answer) answer = tempSum;
				}
				visited[i][j] = false;
			}
		}
		System.out.println(answer);
	}
	static void dfs(int depth,int r, int c, int sum) {
		if(depth==4) {
			if(sum>answer) answer = sum;
			return;
		}
		for(int k = 0;k<4;k++) {
			int nr = r + dir[k][0];
			int nc = c + dir[k][1];
			if(nr<0 || nc < 0 || nr>=N || nc>= M) continue;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(depth+1,nr,nc,sum+arr[nr][nc]);
			visited[nr][nc] = false;
		}
	}
}