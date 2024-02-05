/*
 * 문제
 * 1. 계단 갯수 입력
 * 2. 계단 점수 입력
 * 3. 계단은 1,2씩 올라가기 가능
 * 4. 마지막 계단을 밟아야함
 * 5. 최대 점수 구하기
 * 
 * 풀이
 * 1. 계단 갯수 입력 ->N 300이하
 * 2. 계단 점수 입력 받기 -> arr[N+1]
 * 3. dp 배열 만들기 -> dp[N+1][3] -> 이전것 밟은 경우, 이전 것 안밟은 경우, 이전전것도 밟은 경우
 * 	3.1. dp[N][0] = arr[N], dp[N][1] = arr[N], dp[N][2] = arr[N]
 * 	3.2. dp[N-1][0] = MINVALUE,dp[N-1][1] =dp[N][0],dp[N][2], dp[N-1][2] = arr[N-1]+dp[N][0]
 * 	3.3. dp[i-1][0] = dp[i][1]+arr[i-1], dp[i-1][1] = dp[i][0],dp[i][2], dp[i-1][2] = arr[i-1] + dp[i][0]
 * 4. dp[1]중 최대값 출력
 * 5. 이때 N이 1인 경우와 2인 경우는 바로 출력
 * 
 * 생각해야할 것
 * 1. 형 -> 10000 * 300 => int로 충분
 * 
 * 시간 복잡도
 * 1. 300*3개씩 -> 충분
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		for(int i = 1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if(N==1) {
			System.out.println(arr[1]);
			return;
		}else if(N==2) {
			System.out.println(arr[1]+arr[2]);
			return;
		}
		int[][] dp = new int[N+1][3];
		dp[N][0] = arr[N];
		dp[N][1] = arr[N];
		dp[N][2] = arr[N];
		dp[N-1][0] = Integer.MIN_VALUE;
		dp[N-1][1] = arr[N];
		dp[N-1][2] = arr[N]+arr[N-1];
		for(int i = N-1;i>=2;i--) {
			dp[i-1][0] = dp[i][1]+arr[i-1];
			dp[i-1][1] = Math.max(dp[i][0],dp[i][2]);
			dp[i-1][2] = arr[i-1] + dp[i][0];
		}
		int answer = Math.max(dp[1][0], dp[1][1]);
		answer = Math.max(answer, dp[1][2]);
		System.out.println(answer);
	}
}