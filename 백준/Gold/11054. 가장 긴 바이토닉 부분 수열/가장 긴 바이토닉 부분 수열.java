
/*
 * 1. N 입력 받기
 * 2. arr 배열 채우기 ->arr[N]
 * 3. dp배열 만들기 -> dp[N][]
 * 4. 배열 돌기
 * 	4.1. dp[N][0] -> arr[N]넣기
 * 	4.2. dp[N][1] -> arr[N] 보다 dp[앞에 것들][0]보다 작은 값 중에 dp[앞에것들][1] 중 최대값 구하기 +1 등록
 * 	4.3 dp[N][2] -> arr[N] 보다 dp[앞에 것들][0] 보다 큰 값 중에 dp[앞에 것들][1], [2] 중 최대값 구하기 +1 등록
 * 5. dp[N][2]중 최대값 구하기
 */	
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N+1][3];
		for(int i = 1;i<=N;i++) {
			dp[i][0] = arr[i];
			int max = 0;
			for(int j = 1;j<i;j++) {
				if(arr[i]>dp[j][0]) {
					if(max<dp[j][1]) {
						max = dp[j][1];
					}
				}
			}
			dp[i][1] = max +1;
			int max2 = 0;
			for(int j = 1;j<i;j++) {
				if(arr[i]<dp[j][0]) {
					if(max2<dp[j][2]) {
						max2 = dp[j][2];
					}
					if(max2<dp[j][1]) {
						max2 = dp[j][1];
					}
				}
			}
			dp[i][2] = max2 +1;
		}
		int answer = 0;
		for(int i = 1;i<=N;i++) {
			if(answer<dp[i][2]) {
				answer = dp[i][2];
			}else if(answer<dp[i][1]) {
				answer = dp[i][1];
			}
			
		}
		System.out.println(answer);
	}
}
