/*
 * 1. N 입력 받기
 * 2. arr 배열 만들기 및 입력 받기
 * 3. dp 배열 만들기 -> dp[N+1][2]
 * 4. arr배열 순회	
 * 	4.1. N일 때 -> dp[N][0] = 해당 값, dp를 순회하면서 dp[][1]값이 제일 큰 값에 자신 값 더하기
 * 5. dp[][1]의 최대값 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr=  new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N+1][2];
		for(int i = 1;i<=N;i++) {
			dp[i][0] = arr[i];
			int max = 0;
			for(int j = 1 ; j<=N;j++) {
				if(dp[j][0]<arr[i] && max<dp[j][1]) {
					max = dp[j][1];
				}
			}
			dp[i][1] = max + arr[i]; 
		}
		int answer =0 ;
		for(int i = 1;i<=N;i++) {
			if(answer<dp[i][1]) {
				answer = dp[i][1];
			}
		}
		System.out.println(answer);
	}
}