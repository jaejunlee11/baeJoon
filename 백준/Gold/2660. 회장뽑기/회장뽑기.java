/*
 * 문제
 * 1. 회장 선출
 * 2. 최대한 가까이에서 모든 사람을 알면 회장
 * 
 * 풀이
 * 1. N입력
 * 2. List[N+1]생성=> 각 lsit생성
 * 3. list[a].add(b) + list[b].add(a)
 * 4. N명 for문 돌기
 * 	4.1. 레벨별 bfs돌기 => answerArr에 기록 + 최소값 갱신
 * 5. answerArr순회하여 후보 수와 후보 리스트출력
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] arrList = new List[N+1];
		for(int i = 1;i<=N;i++) {
			arrList[i] = new ArrayList<>();
		}
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==-1 && b ==-1) {
				break;
			}
			arrList[a].add(b);
			arrList[b].add(a);
		}
		List<Integer> answerList = new ArrayList<>();
		int answer = Integer.MAX_VALUE;
		for(int i = 1;i<=N;i++) {
			Deque<Integer> que = new ArrayDeque();
			boolean visited[] = new boolean[N+1];
			que.add(i);
			int time = 0;
			while(!que.isEmpty()) {
				int size = que.size();
				if(size==0) break;
				time++;
				while(size-- >0) {
					int now = que.poll();
					visited[now] =true;
					for(int go : arrList[now]) {
						if(visited[go])continue;
						visited[go] =true;
						que.add(go);
					}
				}
			}
			if(time<answer) {
				answerList = new ArrayList<>();
				answerList.add(i);
				answer = time;
			}else if(time==answer) {
				answerList.add(i);
			}
		}
		System.out.println(answer-1 + " " + answerList.size());
		for(int i : answerList) {
			System.out.print(i +" ");
		}
	}
}