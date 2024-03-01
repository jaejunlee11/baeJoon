/*
 * 문제
 * 1. 최소 스패닝 트리 만들기
 * 2. 모든 정점을 연결하면서 가중치의 합이 최소 
 * 
 * 풀이
 * 1. V, E입력
 * 2. List<int[]>[] lines생성
 * 3. lines[i] = ArrayList<int[]();생성
 * 4. 입력 받기 -> lines[i].add(new int[] {v,w});
 * 5. priorityQueue생성 -> 가중치로 정렬시키게 해놓음 
 * 6. visited배열 생성
 * 7. que에 0,0넣음
 * 8. que가 빌때까지 돌리기 
 * 	8.1. que에서 poll -> 간선의 가중치를 기준으로 정렬됨으로 무조건 최소가 뽑힘
 * 		8.1.1. 만약 해당 정점이 이미 visited면 다음꺼 뽑음 
 * 		8.1.2. visited 체크 + 간선의 가중치를 answer에 더 해주
 * 	8.2. 해당 정점과 연결된 간선들 중 visted체크가 되지 않은 간선을 전부 넣음
 * 	8.3. 만약 전부 visted가 전부 visited면 종료 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<long[]>[] listArr = new List[V+1];
		for(int i = 1;i<=V;i++) {
			listArr[i] = new ArrayList<>();
		}
		for(int i = 0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			listArr[a].add(new long[] { b,c});
			listArr[b].add(new long[] { a,c});
		}
		PriorityQueue<long[]> que = new PriorityQueue<>((o1,o2)->Long.compare(o1[1], o2[1]));
		que.add(new long[] {1,0});
		boolean[] visited = new boolean[V+1];
		visited[0] = true;
//		visited[1] = true;
		long answer = 0;
		while(!que.isEmpty()) {
			long[] tempE = que.poll();
			int v = (int)tempE[0];
			if(visited[v]) continue;
			answer += tempE[1];
			visited[v] = true;
			for(long[] edge : listArr[v]) {
				if(visited[(int)edge[0]]) continue;
				que.add(edge);
			}
		}
		System.out.println(answer);
	}
}