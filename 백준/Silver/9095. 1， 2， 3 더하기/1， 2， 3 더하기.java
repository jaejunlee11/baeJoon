/*
 * 문제
 * 1. 정수를 만드는 방법의 수 출력
 * 
 * 풀이
 * 1. N입력
 * 2. dp[1] = 1
 * 3. dp[2] = 2
 * 4. dp[3] = 4
 * 5. dp[4] = 7
 * 6. dp[i] => dp[i-1]+dp[i-2]+dp[i-3]
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i =4;i<=11;i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		for(int i = 0;i<n;i++) {
			int a = Integer.parseInt(br.readLine());
			System.out.println(dp[a]);
		}
	}
	
}