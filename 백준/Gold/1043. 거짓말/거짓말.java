/*
 * 문제
 * 1. 진실을 아는 사람 존재
 * 2. 파티에서 거짓을 말하고 싶음
 * 3. 진실을 아는 사람이 파티에 있으면 문제 발생
 * 4. 진실을 내가 말하는 경우 진실이 퍼짐
 * 
 * 풀이
 * 1. N,M입력
 * 2. arr[N+1] 생성
 * 3. init 
 * 4. 진실러들 union => 0인 경우 M출력, 진실러 한명 index저장
 * 5. M번 순회
 * 	5.1. 파티 사람들 union
 * 6. N순회 => find(i) == find(진실러)이면 arr에 true로 변경
 * 7. M을 순회
 * 	7.1. 진실러가 없으면 answer++
 * 8.answre출력 
 */
import java.io.*;
import java.util.*;

public class Main  {
	static int N;
	static int M;
	static int[] parents;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean[] truer = new boolean[N+1];
		init();
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		if(n==0) {
			System.out.println(M);
			return;
		}
		int first = -1;
		for(int i = 0;i<n;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(first==-1) {
				first = temp;
			}else {
				union(first,temp);
			}
			truer[temp] = true;
		}
		List<Integer>[] arrlist = new List[M];
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			arrlist[i] = new ArrayList<>();
			int num = Integer.parseInt(st.nextToken());
			int firstNum = -1;
			for(int j = 0;j<num;j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(firstNum==-1) {
					firstNum=temp;
				}else {
					union(firstNum,temp);
				}
				arrlist[i].add(temp);
			}
		}
		for(int i = 1;i<=N;i++) {
			if(find(first)==find(i)) {
				truer[i] = true;
			}
		}
		int answer = 0;
		A : for(int i = 0;i<M;i++) {
			for(int j : arrlist[i]) {
				if(find(first)==find(j)) {
					continue A;
				}
			}
			answer++;
		}
		System.out.println(answer);
	}
	
	private static void init() {
		parents=new int[N+1];
		for(int i = 1;i<=N;i++) {
			parents[i]=i;
		}
	}
	private static int find(int i) {
		if(parents[i]==i) return i;
		return parents[i]=find(parents[i]);
	}
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA==rootB) return;
		parents[rootA] = rootB;
	}
}