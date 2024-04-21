/*
 * 문제
 * 1. 선분 놓기
 * 2. 사이클 생기면 생긴 턴 출력
 * 3. 아니면 그냥 0 출력
 * 
 * 풀이
 * 1. n,m입력
 * 2. parents[N]생성
 * 3. for문 돌기
 * 	3.1. a,b 유니온
 * 	3.2. false면 i+1출력 
 * 4. 0출력 
 */
import java.io.*;
import java.util.*;
public class Main {
	static int[] parents;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		init();
		for(int i =0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!union(a,b)) {
				System.out.println(i+1);
				return;
			}	
		}
		System.out.println(0);
	}
	private static void init() {
		parents = new int[N];
		for(int i =0;i<N;i++) {
			parents[i]  = i;
		}
	}
	
	private static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a]=find(parents[a]);
	}
	
	private static boolean union(int a,int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA==rootB) return false;
		parents[rootA] = rootB;
		return true;
	}
}