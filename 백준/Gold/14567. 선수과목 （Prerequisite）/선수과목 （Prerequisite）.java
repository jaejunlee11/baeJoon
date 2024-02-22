
/*
 * 문제
 * 1. 선수과목 조건이 주어짐
 * 2. 모든 과목은 매학기 개살
 * 3. 각 과목을 몇학기에 이수해야 최소로 걸리는지
 * 
 * 풀이
 * 1. 과목 수 N, 선수 조건 수 M입력
 * 2. List<> arr[N+1] 생성 , indegree[N+1], answer[N+1]
 * 3. 간선 입력 받기 arr[i].add(j) + indegree[j]++
 * 4. while 돌리기 -> count++
 * 	4.1. indegree가 0인 값들 answer[] = count => 없으면 종료
 * 	4.2. arr[]에 있는 값들 전부 indegree --
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] arr = new List[N+1];
		int[] inCount = new int[N+1];
		int[] answer = new int[N];
		for(int i =1;i<=N;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			inCount[b]++;
		}
		int time = 0;
		Deque<Integer> que = new ArrayDeque<>();
		while(true) {
			time++;
			for(int i =1 ;i<=N;i++) {
				if(inCount[i]==0) {
					inCount[i]--;
					answer[i-1] = time;
					que.add(i);
				}
			}
			if(que.size()==0) break;
			while(!que.isEmpty()) {
			for(int i =0 ;i<que.size(); i++) {
				for(int j : arr[que.poll()]) {
					inCount[j]--;
				}
			}
			}

		}
		
		StringBuilder sb =new StringBuilder();
		for(int i : answer) {
			sb.append(i+" ");
		}
		System.out.println(sb);


	}
}
