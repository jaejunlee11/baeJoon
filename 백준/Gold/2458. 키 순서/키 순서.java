/*
 * 문제
 * 1. 모두 키가 다른 학생
 * 2. 학생들 끼리 키를 비교
 * 3. 자신의 키를 확실하게 아는 사람의 숫자 구하기
 * 
 * 아이디어
 * 1. 자신에게 나가는 것이 0인 친구들 구하기 => 숫자 체크 
 * 
 * 풀이
 * 1.테케입력
 * 2. N,M입력
 * 3. arrList1, arrList2 => List<Intger>[N+1] 생성
 * 4. arrList입력 => arrList1[a].add(b), arrList[b].add(a)
 * 5. for문 돌리기 N
 * 	5.1. count = 0 
 * 	5.2. que에 i넣기 + visited처리 + count++
 * 	5.3. while que가 빌때 까지
 * 		5.3.1. que에서 꺼내기
 * 		5.3.2. for(arrList1[a])
 * 			5.3.3. visited처리
 * 			5.3.4. que에 담기 + count++
 * 	5.4. 동일 과정 arrList2로 진행
 * 	5.5. count==n-1이면 answer++;
 */
//메모리 :  115,232 kb 시간 : 1,601 ms
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] arrlist1 = new List[N+1];
		List<Integer>[] arrlist2 = new List[N+1];
		for(int i = 1;i<=N;i++) {
			arrlist1[i] = new ArrayList<>();
			arrlist2[i] = new ArrayList<>();
		}

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());

			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arrlist1[b].add(a);
			arrlist2[a].add(b);
		}
		int answer = 0;
		for(int i = 1;i<=N;i++) {
			int count = 1;
			Deque<Integer> que = new ArrayDeque<>();
			boolean[] visited= new boolean[N+1];
			que.add(i);
			visited[i]=true;
			while(!que.isEmpty()) {
				int a = que.poll();
				for(int b : arrlist1[a]) {
					if(visited[b]) continue;
					visited[b] = true;
					count++;
					que.add(b);
				}
			}
			que.add(i);
			while(!que.isEmpty()) {
				int a = que.poll();
				for(int b : arrlist2[a]) {
					if(visited[b]) continue;
					visited[b] = true;
					count++;
					que.add(b);
				}
			}
			if(count==N) answer++;

		}
		System.out.println(answer);
	}
}