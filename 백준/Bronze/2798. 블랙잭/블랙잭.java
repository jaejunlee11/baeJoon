/*
 * 문제
 * 1. 카드 수 주어짐 =>N, 넘지말아야할 수 => M
 * 2. 3장 뽑기
 * 3. 최대값
 * 
 * 풀이
 * 1. 조합으로 N장 중 3장 뽑기
 * 2. 3장 차면 가까운 값 정하기
 * 
 * 시간 복잡도
 * 1. 100 * 99 *98 => 차고 넘침
 * 
 * 고려할 것
 * 1. int로 충분
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int answer = Integer.MIN_VALUE;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st =  new StringTokenizer(br.readLine());
		for(int i= 0 ;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		recur(0,0,0);
		System.out.println(answer);
		
	}
	public static void recur(int depth, int start, int sum) {
		if(sum>M) return;
		if(depth == 3) {
			answer = Math.max(answer, sum);
			return;
		}
		for(int i =start ;i<N;i++) {
			recur(depth+1,i+1, sum+arr[i]);
		}
	}
}