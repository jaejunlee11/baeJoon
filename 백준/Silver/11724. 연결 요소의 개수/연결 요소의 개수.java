/*
 * 문제
 * 1. 방향이 없는 그래프 주어짐
 * 2. 정점N, 간선 M개 존재
 * 3. 몇 덩이리인지 구하기
 * 
 * 풀이
 * 1. N,M입력
 * 2. N개의 서로소 집합 생성
 * 3. 간선을 입력 받으며 union
 * 4. 마지막에 서로소 집합의 갯수를 확인
 */
import java.io.*;
import java.util.*;

public class Main {
	static int parents[];
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		init();
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		int count = 0;
		for(int i = 1;i<=N;i++) {
			if(parents[i]==i) count++;
		}
		System.out.println(count);
	}
	static void init() {
		for(int i = 1;i<=N;i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
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