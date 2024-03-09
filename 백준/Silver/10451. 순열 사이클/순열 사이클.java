/*
 * 문제
 * 1. 1~N까지 정수 존재
 * 2.  사이클 몇개인지 구하기
 * 
 * 풀이
 * 1. 테케 입력
 * 2. N입력
 * 3. init
 * 4. for문을 돌면서 union(i, 입력값)
 * 5. 사이클 출력
 */
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++) {
			N = Integer.parseInt(br.readLine());
			init();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =1;i<=N;i++) {
				union(i,Integer.parseInt(st.nextToken()));
			}
			int count= 0;
			for(int i=1;i<=N;i++) {
				if(find(i)==i)count++;
			}
			System.out.println(count);
		}
	}
	static void init() {
		parents = new int[N+1];
		for(int i =1 ;i<=N;i++) {
			parents[i]=i;
		}
	}
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a]=find(parents[a]);
	}
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parents[rootA]=rootB;
		return true;
	}
}