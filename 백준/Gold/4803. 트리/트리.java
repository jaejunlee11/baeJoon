/*
 * 풀이
 * 1. 모든 원소 값들을 트리로 만듬
 * 2. 모든 간선을 입력 받으면서 union처리 -> 사이클 판단이 된 대표 노드 번호 저장
 * 3. 마지막으로 배열을 확인하며 대표 노드의 수 세기 -> 사이클 판단 안한 트리의 갯수ㄹ
 */
import java.io.*;
import java.util.*;

public class Main {
	public static boolean[] visited;
	static int[] parents;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = 0;
		StringBuilder sb = new StringBuilder();
		while(true) {
			caseNum++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
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
			parents = new int[N+1];
			make();
			visited = new boolean[N+1];
			for(int i = 0 ;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(!union(a,b)) {
					visited[find(a)] = true;
				}
			}
			int treeCount = 0;
			for(int i = 1;i<=N;i++) {
				if(find(i)==i) {
					if(visited[i]) continue;
					treeCount++;
				}
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
	
	public static void make() {
		for(int i = 1;i<=N;i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parents[rootA] = rootB;
		if(visited[rootA]) visited[rootB] = true;
		return true;
	}
}