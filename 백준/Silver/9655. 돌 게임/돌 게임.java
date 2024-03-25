/*
 * 문제
 * 1. 돌이 있음
 * 2. 1,3개 가져감
 * 3. 최선을 다 할때 승리하는쪽
 * 
 * 아이디어
 * 1. 1인 경우 => 선턴
 * 2. 3인 경우 => 선턴 
 * 3. 2인 경우 => 후턴
 * 4. 4인 경우 => 후턴
 * 5. 5인 경우 => 선턴
 * 6. i인 경우 => i-3,i-1이 후턴 승리면 선턴 승리, 아니면 후턴 승리 
 * 
 * 풀이
 * 1. n입력
 * 2. dp[N+1]생성
 * 3. dp[1] = true
 * 4. dp[2] = false
 * 5. dp[3] = true
 * 6. if(dp[i-3] && dp[i-1]) dp[i] = false => 아닌 경우 true
 * 7.dp[n]이 true면 SK, flas면 CY출력 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] dp = new boolean[N+1];
		if(N==1) {
			System.out.println("SK");
			return;
		}
		if(N==2) {
			System.out.println("CY");
			return;
		}
		if(N==3) {
			System.out.println("SK");
			return;
		}
		dp[1] = true;
		dp[2] = false;
		dp[3] = true;
		for(int i = 4;i<=N;i++) {
			if(!(dp[i-3]&&dp[i-1])) {
				dp[i] = true;
			}
		}
		if(dp[N]) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}
	}
}