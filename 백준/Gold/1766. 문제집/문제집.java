/*
 * 문제
 * 1. 문제가 N개 존재
 * 2. 먼저 푸는 것이 좋은 문제는 먼저 풀기
 * 3. 동일한 우선순위의 경우 쉬운문제 먼저 풀기
 * 
 * 풀이
 * 1. N,M입력
 * 2. List[N+1] 생성, count[N+1]
 * 3. arrList[i]에 ArrayList생성
 * 4. M번 for문 돌기
 * 	4.1. arrList채우기 + count[b]++
 * 5.while문 돌기
 * 	5.1. count배열에서 0인 값 찾기 + que에 넣기 + count감소
 * 	5.2. que 순회 + que값 출력 
 * 		5.2.1. arrList[a] foreach돌기 
 * 			5.2.1.1. count[b]--;
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] arrList = new List[N+1];
		int[] count = new int[N+1];
		for(int i = 1 ;i<=N;i++) {
			arrList[i] = new ArrayList<>();
		}
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arrList[a].add(b);
			count[b]++;
		}
		StringBuilder sb =new StringBuilder();
		A : while(true) {
			for(int i =1;i<=N;i++) {
				if(count[i]==0) {
					count[i]--;
					sb.append(i + " ");
					for(int b : arrList[i]) {
						count[b]--;
					}
					continue A;
				}
			}
			break;
		}
		System.out.println(sb);
	}
}