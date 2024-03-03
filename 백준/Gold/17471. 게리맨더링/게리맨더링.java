/*
 * 문제
 * 1. 선거구 뽑기
 * 2. 선거구는 연결되어있어야함
 * 3. 두 선거구의 수가 비슷한 것의 차 출력
 * 
 * 풀이
 * 1. N 입력
 * 2. arr[N+1]생성 및 채우기 
 * 3. List<Integer> listArr생성 
 * 4. listArr채우기
 * 5. 부분집합으로 뽑기 
 * 
 * 부분집합
 * 1. depth==N
 * 	1.1. all false나 true제외
 * 	1.2. 아무 true bfs탐색 => flag세우기 -> 또들어오면 실패 
 * 	1.3. 아무 false bfs탐색 => flag세우기 -> 또들어오면 실패
 * 	1.4. 도착 시 각 합의 차 구하기
 * 2. picked[depth] =true
 * 3. recur(depth+1)
 * 4. picked[depth] = false
 * 5. recur(depth+1)
 * 
 * bfs
 * 1. que에 넣기 ->visited처리 
 * 2. while que빌때 까지
 * 	2.1. que꺼내기	+ 선거구 합 더해주기 
 * 	2.2. 연결된 곳
 * 	2.3. visted면 pass
 * 	2.4. visted체크 + que에 넣기 
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static List<Integer>[] listArr ;
	static boolean[] picked;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		listArr = new List[N+1]; 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			listArr[i] = new ArrayList<>();
		}
		for(int i =1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			for(int j = 0;j<temp;j++) {
				listArr[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		picked = new boolean[N+1];
		recur(1);
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}
	static void recur(int depth) {
		if(depth==N+1) {
			boolean[] visited = new boolean[N+1];
			boolean flagT = false;
			boolean flagF = false;
			int sumT = 0;
			int sumF = 0;
			for(int i = 1;i<=N;i++) {
				if(picked[i]) {
					if(visited[i])continue;
					if(flagT) return;
					flagT=true;
					visited[i] = true;
					Deque<Integer> que = new ArrayDeque<>();
					que.add(i);
					while(!que.isEmpty()) {
						int v = que.poll();
						sumT += arr[v];
						for(int nv : listArr[v]) {
							if(visited[nv]) continue;
							if(!picked[nv]) continue;
							visited[nv] = true;
							que.add(nv);
						}
					}
				} else if(!picked[i]) {
					if(visited[i])continue;
					if(flagF) return;
					flagF = true;
					visited[i] = true;
					Deque<Integer> que = new ArrayDeque<>();
					que.add(i);
					while(!que.isEmpty()) {
						int v = que.poll();
						sumF += arr[v];
						for(int nv : listArr[v]) {
							if(visited[nv]) continue;
							if(picked[nv]) continue;
							visited[nv] = true;
							que.add(nv);
						}
					}
				}
			}
//			System.out.println(sumF + " " + sumT);
			if(flagT && flagF) {
				if(answer>Math.abs(sumF-sumT)) answer = Math.abs(sumF-sumT);
			}
			return;
		}
		picked[depth] = true;
		recur(depth+1);
		picked[depth] = false;
		recur(depth+1);
	}
}