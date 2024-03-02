/*
 * 문제
 * 1. 별자리의 위칠가 이어짐
 * 2. 모든 별을 이으면서 거리가 최소인 것 구하기
 * 
 * 풀이
 * 1. N입력
 * 2. arr[n+1][2]생성
 * 3. 우선순위 큐 adjque<Double[]>생성
 * 4. arr입력 받기
 * 5. adj를 전부 계산해서 가중치와 좌표 넣기
 * 6. MST하기
 * 
 * MST
 * 1. 큐에서 꺼내기
 * 2. union => 성공시 가중치 더하기
 * 3. 전부 합쳐지면 종료
 */
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		double[][] arr = new double[N+1][2];
		for(int i = 1; i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Double.parseDouble(st.nextToken());
			arr[i][1] = Double.parseDouble(st.nextToken());
		}
		PriorityQueue<double[]> que = new PriorityQueue<>((o1,o2)->Double.compare(o1[2], o2[2]));
		for(int i = 1;i<=N;i++) {
			for(int j = 1;j<=N;j++) {
				double dis = Math.sqrt(Math.pow((arr[i][0]-arr[j][0]),2) + Math.pow((arr[i][1]-arr[j][1]),2));
				que.add(new double[] {i,j,dis});
			}
		}
		double answer = 0f;
		init();
		int count = N-1;
		A : while(!que.isEmpty()) {
			double[] temp=que.poll();
			double dis = temp[2];
			int a = (int) temp[0];
			int b = (int) temp[1];
			if(union(a,b)) {
				answer += dis;
				count--;
				if(count==0) {
					System.out.printf("%.2f",answer);
					return;
				}
				
			}

		}
	}
	static void init() {
		parents = new int[N+1];
		for(int i  = 1;i<=N;i++) {
			parents[i]=i;
		}
	}
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parents[rootA] = rootB;
		return true;
	}
}