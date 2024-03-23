/*
 * 문제
 * 1. 집들이 붙어있으면 단지
 * 2. 단지들의 수와 각 단지의 아파트 숫자 출력
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N][N]생성
 * 3. arr채우기
 * 4. for문돌리기
 * 	4.1. 1을 만나면 visited확인 
 * 	4.2. dfs(위치)돌리기 => 갯수 리턴 
 * 	4.3. list에 담기
 * 5.리스트 사이즈 출력
 * 6. 리스트 정령 후 출력
 * 
 * dfs(r,c)
 * 0. answr = 0
 * 1. 4방 탐색
 * 	1.1. range check
 * 	1.2. visited check
 * 	1.3. answer += (dfs(nr,nc)+1)
 * 2. return answer
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0;i<N;i++) {
			String temp = br.readLine();
			for(int j = 0;j<N;j++) {
				arr[i][j] = temp.charAt(j) -'0';
			}
		}
		visited = new boolean[N][N];
		List<Integer> answer = new ArrayList<>();
		for(int i =0 ;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(visited[i][j]) continue;
				if(arr[i][j]==0) continue;
				visited[i][j] =true;
				int count = dfs(i,j)+1;
				answer.add(count);
			}
		}
		System.out.println(answer.size());
		Collections.sort(answer);
		for(int i : answer) {
			System.out.println(i);
		}
	}
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static int dfs(int r,int c) {
		int count =0;
		for(int k = 0;k<4;k++) {
			int nr = r +dir[k][0];
			int nc = c +dir[k][1];
			if(nr>=N || nc >=N || nr<0 || nc<0) continue;
			if(arr[nr][nc]==0) continue;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
			count += (dfs(nr,nc)+1);
		}
		return count;
	}
}