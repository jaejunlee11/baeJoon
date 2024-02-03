/*
 * 문제
 * 1. 구매하고 싶은 카드팩 수 입력 N 1~1000
 * 2. 각 카드팩 가격 입력 (1~10000)
 * 3. 카드팩을 조합하여 최대 가격 구하기
 * 
 * 풀이
 * 1. 구매하고 싶은 카드팩 수 입력 N
 * 2. 카드팩 가격 배열 prices[N+1]생성
 * 3. 카드팩 가격 입력 받기
 * 4. dp배열 생성 dp[N+1]
 * 	4.1. dp[N] => N개를 만드는 최대 비용
 * 	4.2. dp[1] = prices[1]
 * 	4.3. dp[2] = dp[1] + prices[1] or prices[2]
 * 	4.4. dp[i] = dp[i-1] + prices[1], ...dp[i-j] + prices[j] or prices[i]
 * 5. dp[N] 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for(int i = 1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N+1];
		dp[1] = arr[1];
		for(int i = 2;i<=N;i++) {
			int temp = Integer.MIN_VALUE;
			for(int j = 1;j<=i;j++) {
				temp = Math.max(temp, dp[i-j]+arr[j]);
			}
			dp[i] = temp;
		}
		System.out.println(dp[N]);
	}
}