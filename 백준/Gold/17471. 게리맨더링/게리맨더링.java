/*
 * 문제
 * 1. N개의 구역 존재
 * 2. 연결된 구역을 선태 가능
 * 3. 두 구역의 차의 최소값 구하기
 * 
 * 풀이
 * 1. N 입력 받기 
 * 2. arr[N+1]생성
 * 3. arr 배열 채우기
 * 4. 간선 배열 만들기 List[] => 채우기 
 * 5. 부분 집합으로 1개의 구 결정하기
 * 6. 서로소 집합용 배열 만들기 parents[N+1]
 * 7. picked가 되지 않은 원소들을 피해가며 union
 * 8. 각 원소들이 전부 같은 parents를 가지면 두 구의 차를 확인
 * 
 *  부분 집합
 *  1. depth ==10
 *  	1.1. 실행
 *  2. picked[dpeht]=true
 *  3. recur(depth+1)
 *  4. picked[depth] = false
 *  5. recur(depth+1)
 *  
 *  시간 복잡도
 *  1. 1024 * (45 + 45 +10) * 5000 = 5000만
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int N;
	static List<Integer>[] listArr;
	static boolean[] picked;
	static int[] parents;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		listArr = new List[N+1];
		for(int i = 1;i<=N;i++) {
			listArr[i] = new ArrayList<Integer>();
		}
		for(int i = 1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			for(int j = 0;j<temp;j++) {
				listArr[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		parents = new int[N+1];
		picked = new boolean[N];
		recur(0);
		if(answer==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
 	}
	static void recur(int depth) {
		if(depth==N) {
			int count = 0;
			for(int i=0;i<N;i++) {
				if(picked[i]) count++;
			}
			if(count==0 || count ==N) return;
			init();
			for(int i = 0;i<N;i++) {
				if(picked[i]) {
					for(int a : listArr[i+1]) {
						if(picked[a-1]) {
							union(i+1,a);
						}
					}
				}else {
					for(int a : listArr[i+1]) {
						if(!picked[a-1]) {
							union(i+1,a);
						}
					}
				}
			}
//			System.out.println(Arrays.toString(picked));
//			System.out.println(Arrays.toString(parents));
			int pickParent = -1;
			int unpickParent = -1;
			int pickSum = 0;
			int unpickSum = 0;
			for(int i =0;i<N;i++) {
				if(picked[i]) {
					if(pickParent==-1) {
						pickParent = parent(i+1);
					}else {
						if(pickParent!=parent(i+1)) {
							return;
						}
					}
					pickSum += arr[i+1];
				}else {
					if(unpickParent==-1) {
						unpickParent = parent(i+1);
					}else {
						if(unpickParent!=parent(i+1)) {
							return;
						}
					}
					unpickSum += arr[i+1];
				}
			}
//			System.out.println(pickSum+" "+unpickSum);
			answer = Math.min(Math.abs(unpickSum - pickSum), answer);
			return;
		}
		picked[depth] = true;
		recur(depth+1);
		picked[depth] = false;
		recur(depth+1);
	}
	
	static void init() {
		for(int i = 1;i<=N;i++) {
			parents[i]=i;
		}
	}
	static int parent(int a) {
		if(parents[a]==a) return a;
		return parents[a] = parent(parents[a]);
	}
	static boolean union(int a, int b) {
		int rootA = parent(a);
		int rootB = parent(b);
		if(rootA == rootB) return false;
		parents[rootA] = rootB;
		return true;
	}
}