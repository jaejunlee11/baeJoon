/*
 * 문제
 * 1. N, M 입력 -> 100000최대
 * 2. N개의 수 입력 -> 최대 1000
 * 3. 구간 입력 -> i,j
 * 
 * 풀이
 * 1. N,M입력
 * 2. N+1배열 만들기
 * 3. 배열 입력 받으면서 이전 값에 해당 값을 더하면서 합을 넣기
 * 4. arr[0]=0 , arr[i] = arr[i-1] + 입력 받은 값 넣어주기
 * 4. i,j입력 받기 -> 배열[i] - 배열[j-1]
 * 
 * 
 * 시간 복잡도
 * 1.대략 30만
 * 
 * 
 * 체크리스트
 * 1. 오버플로우 -> 최대 100000 * 1000 -> 안남 int 가능
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine()); 
		for(int i = 1;i<=N;i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		for(int k = 0;k<M;k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(arr[j]-arr[i-1]);
		}
	}
}