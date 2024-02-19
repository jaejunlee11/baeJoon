/*
 * 문제
 * 1. 정점의 수와 간선의 수가 주어짐
 * 2. 간선이 주어짐
 * 3. 간선을 모두 입력 받은 이후 케이스 번호와 트리의 수를 출력
 * 4. 0 0을 입력 받으면 종료
 * 
 * 풀이
 */
import java.io.*;
import java.util.*;

public class Main {
	public static boolean[] visited;
	public static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = 0;
		StringBuilder sb = new StringBuilder();
		while(true) {
			caseNum++;
//			if(caseNum==10) break;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N==0 && M == 0) break;
			if(M==0) {
				if(N==1) {
					sb.append("Case "+caseNum+": There is one tree.\n");
					continue;
				}
				sb.append("Case "+caseNum+": A forest of "+N+" trees.\n");
				continue;
			}
//			int[][] arr = new int[N+1][N+1];
			arr = new ArrayList[N+1];
			for(int i = 1;i<=N;i++) {
				arr[i] = new ArrayList<Integer>();
			}
			visited = new boolean[N+1];
			for(int i = 0 ;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a].add(b);
				arr[b].add(a);
			}
			int treeCount = 0;
			for(int i = 1;i<=N;i++) {
				if(visited[i]) continue;
				if(!dfs(0,i)) treeCount+=1;
			}
			sb.append("Case "+caseNum+": ");
			if(treeCount ==0) {
				sb.append("No trees.\n");
			}else if(treeCount==1) {
				sb.append("There is one tree.\n");
			}else {
				sb.append("A forest of "+(treeCount)+" trees.\n");
			}
		}
		System.out.println(sb);
	}
	private static boolean dfs(int parent,int child) {
		if(visited[child])
			return true;
		visited[child] = true;
		boolean flag = false;
		for(int i : arr[child]) {
			if(parent == i) continue;
			if(dfs(child,i)) {
				flag = true;
			}
		}
		return flag;
	}
}