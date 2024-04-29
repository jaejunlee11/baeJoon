import java.io.*;
import java.util.*;
/*
 * 문제
 * 1. 도시가 N개 존재
 * 2. 여행 계획이 존재할때 해당 여행 계획이 가능한지 판단
 * 
 * 풀이
 * 1. N입력
 * 2. M입력
 * 3. init()
 * 4. for문 돌리기 N * N
 * 5. union해주기
 * 6. M번 순회
 * 	6.1. parents가 다르면 No 출력
 * 7.Yes 출력 
 */
public class Main {
	static int[] parents;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		init();
		for(int i = 1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1;j<=N;j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					union(i,j);
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = find(Integer.parseInt(st.nextToken()));
		for(int i = 1;i<M;i++) {
			if(root!=find(Integer.parseInt(st.nextToken()))) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	private static void init() {
		parents = new int[N+1];
		for(int i = 1;i<=N;i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a]=find(parents[a]);
	}
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parents[rootA] = rootB;
		return true;
	}
}