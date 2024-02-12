/*
 * 문제
 * 1. 0부터 N까지의 수를 더해서 N이 되오록 만들기
 * 2. 덧셈의 숫자가 변해도 다른 것
 * 
 * 풀이
 * 1. K개의 상자에 N개의 공을 담는 것
 * 2. N+K-1CN
 * 3. dp[][]
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[][] dp = new long[N+K][N+K];
		for(int i = 0;i<N+K;i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		for(int i = 1;i<N+K;i++) {
			for(int j = 1;j<N+K;j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%1000000000;
			}
		}
		System.out.println(dp[N+K-1][K-1]%1000000000);
	}
}