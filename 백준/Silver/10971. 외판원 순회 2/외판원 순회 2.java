/*
 * 문제
 * 1. 도시들이 존재
 * 2. N-1개의 도시를 돌고 돌아와야함
 * 3. 최소 비용 구하기
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N+1][N+1]생성
 * 3. arr채우기
 * 4. visited[N+1]생성
 * 5. visited[1] = true
 * 6. dfs돌리기
 * 
 * dfs(depth, v, cost)
 * 0. cost>=answer면 return
 * 1. depth == N-1일때
 * 	1.1. arr[v][1]이 0이면 retrun;
 * 	1.2. cost + arr[v][1] 후 answer 갱신
 * 2. for(2~N)
 * 	2.1. arr[v][i] ->0이면 continue
 * 	2.2. vistited[i]면 continue
 * 	2.3. visited체크
 * 	2.4. dfs(depth+1,i,cost+arr[v][i]
 * 	2.5. visited복구
 * 
 * 시간 복잡도
 * 10! * 10에 백트랙킹 => 충분
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	static int answer;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		for(int i = 1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =1 ;j<=N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N+1];
		visited[1] = true;
		answer = Integer.MAX_VALUE;
		dfs(0,1,0);
		System.out.println(answer);
	}
	static void dfs(int depth, int v, int cost) {
		if(cost>=answer) return;
		if(depth==N-1) {
			if(arr[v][1]==0) {
				return;
			}
			if(answer > cost+arr[v][1]) {
				answer = cost + arr[v][1];
			}
			return;
		}
		for(int i = 2;i<=N;i++) {
			if(visited[i]) continue;
			if(arr[v][i]==0) continue;
			visited[i] = true;
			dfs(depth+1,i,cost+arr[v][i]);
			visited[i] = false;
		}
	}
}