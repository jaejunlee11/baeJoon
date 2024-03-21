/*
 * 문제
 * 1. s1 -> s2 -> ... ->s1으로 돌아가야팀
 * 2. 팀이 안된 사람 수 출력
 * 
 * 
 * 생각
 * 1. 마지막은 무조건 사이클안에 들어갈 수 밖에 없음
 * 2. 들어오는게 여러개인 지점 => 분기점
 * 3. 들어오는게 없는 지점 => 시작점
 * 4. 시작점과 분기점을 체크해 놓기
 * 5. 시작점에서 시작해서 분기점을 만나면 해당 갯수 체크
 * 6. 분기점
 * 
 * 풀이
 * 1. 테케 입력
 * 2. N입력
 * 3. arr[N+1]생성
 * 4. arr채우기 + 들어오는 것 갯수 배열 관리
 * 5. 들어오는게 0개인 점들에서 dfs를 진행하면서 들어오는 갯수--
 * 	5.1. 만약 --를 했을 때 0이면 계속 진행
 * 	5.2. --를 했을 때 1인 경우 정지 
 * 6. 마지막에 배열을 확인해서 0인 것의 갯수 세기
 */
import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
	static int[] arrCount;
	static Deque<Integer> que;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			arrCount = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =1;i<=N;i++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i] = temp;
				arrCount[temp]++;
			}
			que = new ArrayDeque<>();
			for(int i=1;i<=N;i++) {
				if(arrCount[i]==0) {
					que.add(i);
				}
			}
			while(!que.isEmpty()) {
				int i = que.poll();
				dfs(i);
			}
			int answer = 0;
			for(int i = 1;i<=N;i++) {
				if(arrCount[i]==0) {
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
	static void dfs(int node) {
		int nextNode = arr[node];
		if(--arrCount[nextNode] ==0) {
			dfs(nextNode);
		}
	}
}