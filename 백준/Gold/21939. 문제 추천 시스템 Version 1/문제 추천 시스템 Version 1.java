/*
 * 문제
 * 1. 문제들이 난이도가 존재
 * 2. recommend로 가장 어려운 혹은 가장 쉬운 문제를 출력
 * 3. add로 문제 추가
 * 4. solved로 문제 제거
 * 
 * 풀이
 * 1. N입력
 * 2. Prioriyt 큐 2개 생성 => 오름, 내림 + 번호도, visited[100000][100]생성
 * 3. for돌리기 => N
 * 	3.1. que1, que2에 넣기 + visited 체크
 * 4.M입력
 * 5.for문 돌기
 * 	5.1. add시 que1,que2에 넣기 + visited체크
 * 	5.2  recommend 1시 que1에서 peek => visited가 false면 poll 후 다음 것 뽑기
 * 	5.3. solved시 visited[P] 전부 false화
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> que1 = new PriorityQueue<>((o1,o2)->{ if(o1[1]==o2[1]) {
			return o1[0]-o2[0];
		}else {
			return o1[1]-o2[1];
		}});
		PriorityQueue<int[]> que2 = new PriorityQueue<>((o2,o1)->{ if(o1[1]==o2[1]) {
			return o1[0]-o2[0];
		}else {
			return o1[1]-o2[1];
		}});
		boolean[][] visited = new boolean[100001][101];
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			que1.add(new int[] {p,l});
			que2.add(new int[] {p,l});
			visited[p][l] = true;
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<M;i++) {
			String order = br.readLine();
			String[] orders = order.split(" ");
			if(orders[0].equals("add")) {
				int p = Integer.parseInt(orders[1]);
				int l = Integer.parseInt(orders[2]);
				que1.add(new int[] {p,l});
				que2.add(new int[] {p,l});
				visited[p][l] = true;
			}else if(orders[0].equals("recommend")){
				if(orders[1].equals("1")) {
					while(true) {
						int[] problem = que2.peek();
						int p = problem[0];
						int l = problem[1];
						if(!visited[p][l]) {
							que2.poll();
							continue;
						}
						sb.append(p+"\n");
						break;
					}
				}else {
					while(true) {
						int[] problem = que1.peek();
						int p = problem[0];
						int l = problem[1];
						if(!visited[p][l]) {
							que1.poll();
							continue;
						}
						sb.append(p+"\n");
						break;
					}
				}
			}else {
				int p = Integer.parseInt(orders[1]);
				for(int l = 1;l<=100;l++) {
					visited[p][l]=false;
				}
				
			}
		}
		System.out.println(sb);
	}
}