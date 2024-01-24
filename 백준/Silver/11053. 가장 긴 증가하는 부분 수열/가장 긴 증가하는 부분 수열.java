/*
 * 1. N값 입력 받기 arr
 * 2. N+1개짜리 배열 생성
 * 3. for문을 돌면서 arr 배열 채우기 및 최대값 구해 놓기
 * 4. dp 배열 생성 -> dp[N+1][최대값+1]
 * 5. arr 배열을 순회
 * 	5.1. N일 때 dp[N][해당 숫자] = (dp[N-1][해당 숫자 보다 작은 숫자] 중 가장 큰값) + 1
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N+1][2];
		dp[1][0]=arr[1];
		dp[1][1] =1;
		for(int i = 2;i<=N;i++) {
			dp[i][0] = arr[i];
			int max = 0;
			for(int j = 1;j<=N;j++) {
				if(dp[j][0]<dp[i][0]) {
					if(max<dp[j][1]) {
						max = dp[j][1];
					}
				}
			}
			dp[i][1] = max+1;
		}
		int answer = 0;
		for(int i = 1;i<=N;i++) {
			if(answer<dp[i][1]) {
				answer = dp[i][1];
			}
		}
		System.out.println(answer);
	}
}