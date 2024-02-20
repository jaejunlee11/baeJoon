/*
 * 문제
 * 1. 학생 수, 비교한 학생 수 주어짐
 * 2. 비교 결과가 주어짐
 * 3. 학생 줄세우기 -> 주어진 순서만 지키면 괜찮음
 * 
 * 풀이
 * 1. 학생수 N입력, 비교 결과 M입력
 * 2. 간선 리스트를 담는 배열 List<>[N+1]생성, 들어오는 것이 없는 노드를 찾기 위해서 숫자를 저장하는 배열 따로 만듬 arr[N+1]
 * 3. M을 돌면서 간선 추가 + arr[뒤쪽값]++
 * 4. while돌기 
 * 	4.1. arr을 순회하면서 0인 값들을 que에 담기 -> 담았던 애들은 check 표시 or -로 바꿔도 괜찮을듯
 * 	4.2. while(que가 빌때까지)
 * 		4.2.1. que값 빼면서 바로 바로 출력
 * 		4.2.1. (que에서 꺼낸 값의 간선 제거) + arr[뒤쪽값]--
 * 	4.3. que에 arr[] 0인 것 넣기
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] listArr = new List[N+1];
		for(int i = 1 ; i<=N;i++) {
			listArr[i] = new ArrayList<Integer>();
		}
		int[] arr= new int[N+1];
		for(int i =0 ;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			listArr[a].add(b);
			arr[b]++;
		}
		StringBuilder sb = new StringBuilder();
		Deque<Integer> que = new ArrayDeque<>();
		while(true) {
			for(int i = 1;i<=N;i++) {
			if(arr[i]==0) {
				que.add(i);
			}
			}
			if(que.isEmpty()) break;
			while(!que.isEmpty()) {
				int v = que.poll();
				arr[v]--;
				sb.append(v+" ");
				for(int i : listArr[v]) {
					arr[i]--;
				}
				
			}
		}
		System.out.println(sb);
	}
}