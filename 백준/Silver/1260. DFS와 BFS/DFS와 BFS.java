/*
 * 문제
 * 1. dfs로 탐색
 * 2. bfs로 탐색 결과 출력
 * 
 * 풀이
 * 0. visited배열 생성
 * 1. 정점 갯수 N, 간선 갯수 M, 탐색 시작 정점 V입력
 * 3. 간선이 되어있는지 확인할 배열 lines[N+1][N+1]생성
 * 4. 돌면서 lines에 lines[i][j] lines[j][i] true로 채우기
 * 5. dfs 돌기
 * 6. bfs 돌기
 * 
 * dfs(v)
 * 1. for()돌기 N만큼 돌기
 * 	1.1. visited는 pass, lines[v][i] == false면 pass
 * 	1.2. visited해주기
 * 	1.3. dfs(i)
 * 
 * bfs(v)
 * 0. que만들기
 * 1. while(que빌때까지 돌기)
 * 	1.1. for()돌기 N만큼
 * 	1.2. visited는 pass, lines[v][i] == false면 pass
 * 	1.3. que에 담기
 * 	1.4. visited해주기
 * 
 *------------------------------------------------------------
 * 풀이
 * 0. visited배열 생성
 * 1. 정점 갯수 N, 간선 갯수 M, 탐색 시작 정점 V입력
 * 3. 간선이 되어있는지 확인할 리스트를 담을 배열 List[] lines[N+1]생성 -> 배열안에 arrayList넣어주기
 * 4. 돌면서 lines에 lines[i]에 j를 넣기, lines[j]에 i를 넣기
 * 5. dfs 돌기
 * 6. bfs 돌기
 * 
 * dfs(v)
 * 1. for() lines[v] foreach로 돌기
 * 	1.1. visited는 pass
 * 	1.2. visited해주기
 * 	1.3. dfs(i)
 * 
 * bfs(v)
 * 0. que만들기
 * 1. while(que빌때까지 돌기)
 * 	1.1. for() lines[v] foreach로 돌기
 * 	1.2. visited는 pass
 * 	1.3. que에 담기
 * 	1.4. visited해주기
 */
import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] arr;
	static int N;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		arr= new List[N+1];
		for(int i = 1;i<=N;i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 0;i<M;i++) {
			st =  new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		for(int i = 1;i<=N;i++) {
			Collections.sort(arr[i]);
		}
		visited = new boolean[N+1];
		visited[V] = true;
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
	}
	public static void dfs(int v) {
		System.out.print(v+" ");
		for(int i : arr[v]) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(i);
		}
	}
	
	public static void bfs(int v) {
		Deque<Integer> que = new ArrayDeque<>();
		que.add(v);
		visited[v] = true;
		while(!que.isEmpty()) {
			int x= que.poll();
			System.out.print(x+" ");
			for(int i : arr[x]) {
				if(visited[i]) continue;
				que.add(i);
				visited[i] = true;
			}
		}
	}
}