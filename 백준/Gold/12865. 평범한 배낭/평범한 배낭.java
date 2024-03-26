/*
 * 문제
 * 1. 가방 존재 
 * 2. 가방에 물건 채우기
 * 3. 최대 가치로 채우기
 * 
 * 풀이
 * 1. N,K입력
 * 2. arr[N+1][2]생성
 * 3. arr 채우기
 * 4. dp[N+1][K+1] 생성
 * 5. for문돌리기 1~K
 * 	5.1. for문 돌리기 1~N
 * 		5.1.1. dp[j][i] = max(dp[j-arr[j][0]][i-1]+arr[j][1],dp[j]][i-1])
 * 		5.1.2. 만약 j-arr[j][0]가 음수면 제외
 * 6. dp[N][K]값 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][2];
		for(int i =1 ;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0]= Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[K+1][N+1];
		for(int i = 1;i<=K;i++) {
			for(int j = 1;j<=N;j++) {
				if(i-arr[j][0]<0) {
					dp[i][j] =dp[i][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-arr[j][0]][j-1]+arr[j][1],dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[K][N]);
	}
}