/*
 * 문제
 * 1. 상사들이 존재
 * 2. 상사는 자신 보다 숫자가 더 작다 
 * 3. 1은 항상 사장
 * 4. 칭찬을 하면 부하의 부하들이 전부 칭찬
 * 5. 1~n의 칭찬 수치 구하기
 * 
 * 풀이
 * 1. N,M입력
 * 2. listArr[N]생성
 * 	2.1. listArr[] 초기화
 * 	2.2. listArr[값].add(i)
 * 3. happy[N]생성
 * 	3.1. happy[값] += 값
 * 4. que 생성
 * 5. que에 {1,0}넣기
 * 6. while => que빌때 까지
 * 	6.1. que에서 꺼내기
 * 	6.2. for(i : listArr[loc[0]])
 * 		6.2.0 happy[i]+=loc[1];
 * 		6.2.1. que.add(i,happy[i])
 * 7. happy 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] listArr = new List[N+1];
		for(int i= 1 ;i<=N;i++) {
			listArr[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(i==1) continue;
			listArr[temp].add(i);
		}
		int[] happy = new int[N+1];
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			happy[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
		}

		boolean[] visited = new boolean[N+1];
		for(int i = 1;i<=N;i++) {
			if(visited[i]) continue;
			Deque<int[]> que = new ArrayDeque<>();
			que.add(new int[] {i,0});
			visited[i] = true;
			while(!que.isEmpty()) {
				int[] loc = que.poll();
				for(int j : listArr[loc[0]]) {
						visited[j] = true;
						happy[j] += loc[1];
						que.add(new int[] {j,happy[j]});
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<=N;i++) {
			sb.append(happy[i]+ " ");
		}
		System.out.println(sb);
	}
}