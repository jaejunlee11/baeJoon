/*
 * 문제
 * 1. 동전들이 존재
 * 2. 동전을 사용해서 특정 금액을 만들 수 있는가지수
 * 
 * 풀이
 * 1. 테케 입력
 * 2. 동전 가지수 입력
 * 3. arr[N]생성
 * 4. dp[M+1][N+1]생성
 * 5. arr채우기 + dp[M+1][해당값] =1 로 채우기 
 * 6. dp돌기 2중 for문 => 1~M, 0~N
 * 	6.1. dp[i][j] = dp[i][j-1] + dp[i-arr[j]][j]
 * 	6.2. i가 arr[j]보다 작거나 같은 경우 pass
 * 7. dp[M][0]출력 
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i = 0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			int[][] dp = new int[M+1][N+1];
			for(int i = 0;i<N;i++) {
				if(arr[i]>M)continue;
				dp[arr[i]][i] = 1;
			}
			for(int i = 1;i<=M;i++) {
				for(int j =N-1;j>=0;j--) {
					if(arr[j]>=i) continue;
					dp[i][j] = dp[i][j+1]+dp[i-arr[j]][j];
				}
			}
			System.out.println(dp[M][0]);
		}
	}
}