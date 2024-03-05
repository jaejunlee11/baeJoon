/*
 * 문제
 * 1. 1 타일과 00타일 존재
 * 2. N이 주어질때 몇가지의 2진순열이 가능한지 구하기
 * 
 * 풀이
 * 1. dp[1][1] = 1, dp[1][0] = 0
 * 2. dp[2][1] = 1, dp[2][0] = 1
 * 3. dp[3][1] = 2, dp[3][0] = 1
 * 4. dp[i][1] = dp[i-1]합, dp[i][0] = dp[i-2]합
 * 5. for문 돌리기
 * 6.dp[N][0] + dp[N][1]출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N==1) {
			System.out.println(1);
			return;
		}
		if(N==2) {
			System.out.println(2);
			return;
		}
		long dp[][] = new long[N+1][2];
		dp[1][1] = 1;
		dp[1][0] = 0;
		dp[2][1] = 1;
		dp[2][0] = 1;
		for(int i =3;i<=N;i++) {
			dp[i][0] = (dp[i-2][0]+dp[i-2][1])%15746;
			dp[i][1] = (dp[i-1][0]+dp[i-1][1])%15746;
		}
		System.out.println((dp[N][0]+dp[N][1])%15746);
	}
}