/*
 * 1. N 입력 -> arr[N] 생성
 * 2. arr 입력 받기
 * 3. dp[N][2]생성
 * 4. N -> dp[N][0] => arr[N] , dp[N][1] => for문을 돌면서 dp[][0]가 현재 값 보다 작을 때 dp[][1] 중 제일 큰값 + 1
 * 5. 최대값 찾고 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =1 ;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N+1][2];
		for(int i = 1;i<=N;i++) {
			dp[i][0] = arr[i];
			int max = 0;
			for(int j = 0;j<=N;j++) {
				if(dp[i][0]<dp[j][0] && max<dp[j][1]) {
					max = dp[j][1];
				}
			}
			dp[i][1] = max+1;
		}
		int answer = 0;
		for(int i = 1;i<=N;i++) {
			if(dp[i][1]>answer) {
				answer = dp[i][1];
			}
		}
		System.out.println(answer);
	}
}