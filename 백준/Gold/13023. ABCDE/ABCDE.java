/*
 * 문제
 * 1. N명이 알고리즘 캠프에 참가 0 ~ N-1
 * 2. 1-2-3-4-5가 이어지는 것이 있는지 체크
 * 
 * 풀이
 * 1. N,M입력 받기
 * 2. arr 리스트[N+1]
 * 3. 간선 채우기 -> arr[i].add(j) arr[j].add(i)
 * 4. 모든 친구들 탐색
 * 	4.0. visited 체크
 * 	4.1. dfs로 탐색 ->  true면 1 출력, flase면 0 출력
 * 
 * dfs
 * 1. 깊이가 5가되면 true
 * 2. for(리스트)
 * 	2.1. visited확인
 * 	2.2. visited해주기
 * 	2.3. dfs
 * 	2.4. visited해제
 * 
 * 시간 복잡도
 * 1.터질듯
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static List<Integer>[] listArray;
	static boolean[] visited;
	static boolean answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		listArray = new List[N];
		for(int i = 0;i<N;i++) {
			listArray[i] = new ArrayList<Integer>();
		}
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			listArray[a].add(b);
			listArray[b].add(a);
		}
		visited = new boolean[N];
		for(int i = 0;i<N;i++) {
			visited[i]=true;
			dfs(0,i);
			if(answer) {
				System.out.println(1);
				return;
			}
			visited[i]=false;
		}
		System.out.println(0);
	}
	
	static void dfs(int depth,int node) {
		if(depth==4) {
			answer = true;
			return;
		}
		for(int i : listArray[node]) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(depth+1,i);
			visited[i] = false;
		}
		return;
	}
}