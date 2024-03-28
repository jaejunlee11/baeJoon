/*
 * 문제
 * 1. 트리가 존재
 * 2. 트리에 간선 정보가 주어짐
 * 3. 특정 정점에서 특정 정점까지의 최대 길이 구하기
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N+1]생성
 * 3. List[N+1] => arrList생성, + inNode[N+1] 생성
 * 4. answer[N+1][2] 생성
 * 5. arrList 입력
 * 	5.1. inNode[i]++
 * 6. for문 탐색 N
 * 	6.1. inNode[i]가 1인 값들 찾기
 * 		6.1.1. 해당 노드와 연결된 노드 => 
			6.1.1.1. inNode감소(자기도 감소)
 * 			6.1.1.2. 자신 노드의 answer[i][0]+가중치와 해당 노드의 answer[j][0]값과 비교, 더 큰경우 answr[j][0]을 1로 넣고 0값 갱신
 * 			6.1.1.3. 더 작은 경우 answer[j][1] 갱신
 * 6.을 while문으로 돌리기 => inNode가 전부 0일때 까지
 * 7. answer[N+1]의 값들의 합의 최대값 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		List<int[]>[] arrList = new List[N+1];
		int[] inNode= new int[N+1];
		long[][] answer = new long[N+1][2];
		for(int i = 1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			arrList[now] = new LinkedList<>();
			while(true) {
				int next = Integer.parseInt(st.nextToken());
				if(next == -1) break;
				int weight = Integer.parseInt(st.nextToken());
				arrList[now].add(new int[] {next,weight});
				inNode[next]++;
			}
		}
		while(true) {
			boolean flag = true;
			for(int i = 1;i<=N;i++) {
//				Deque<Integer> que = new ArrayDeque<>();
				if(inNode[i]==1) {
					flag= false;
					for(int[] next : arrList[i]) {
						int nextNode = next[0];
						if(inNode[nextNode]==0) continue;
						inNode[i]--;
						inNode[nextNode]--;
						long tempdis = answer[i][0]+next[1];
						if(tempdis>=answer[nextNode][0]) {
							answer[nextNode][1] = answer[nextNode][0];
							answer[nextNode][0] = tempdis;
						}else if(tempdis> answer[nextNode][1]) {
							answer[nextNode][1] = tempdis;
						}
//						System.out.println("indone");
//						System.out.println(Arrays.toString(inNode));
					}
//					for(int t = 1; t<=N;t++) {
//						System.out.println(Arrays.toString(answer[t]));
//					}
//					System.out.println();
//					que.add(i);
				}
//				while(!que.isEmpty()) {
//					int k = que.poll();

//				}
			}
			if(flag) {
				long max = Integer.MIN_VALUE;
				for(int i = 1;i<=N;i++) {
					long temp = answer[i][0]+answer[i][1];
					max = Math.max(temp, max);
				}
				System.out.println(max);
				break;
			}
		}
	}
}