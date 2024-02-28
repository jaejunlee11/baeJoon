/*
 * 문제
 * 1. 맨 앞 2집과 맨 끝 2집은 색이 다름
 * 2. 2칸 떨어진 집은 서로 색이 다름
 * 3. 각 집을 색칠하는 비용이 주어짐
 * 4. 집을 전부 칠할 때 최소 비용 구하기
 * 
 * 풀이
 * 1. N입력
 * 2. prices[N+1][3]생성 => 채우기 
 * 3. dp[N+1][3]생성
 * 4. dp[1][0] = prices[1][0], ..
 * 5. dp[2][0] = dp[1][1],dp[1][2] 중 최소 + prices[1][0] ..
 * 6. dp[i][0] = dp[i-1][1], dp[i-1][2] 중 최소 +prices[i[0]
 * 7. N까지 반복 후 dp[N][0] , dp[N][1], dp[N][2]중 최소 출력 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][3];
		for(int i = 1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N+1][3];
		dp[1][0] = arr[1][0];
		dp[1][1] = arr[1][1];
		dp[1][2] = arr[1][2];
		for(int i =2;i<=N;i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + arr[i][2];
		}
		int temp = Math.min(dp[N][0], dp[N][1]);
		System.out.println(Math.min(dp[N][2], temp));
	}
}