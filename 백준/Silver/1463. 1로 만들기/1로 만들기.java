/*
 * 문제
 * 1. x가 3으로 나누어 떨어지면 3으로 나눈다
 * 2. x가 2로 나누어 떨어지면 2로 나눈다
 * 3. 아니면 1을 뺀다.
 * 4. 1을 만드는 최소 연산
 * 
 * 풀이
 * 1. N이 주어짐
 * 2. dp[N+1]생성
 * 3. dp[1] = 1
 * 4. dp[i]
 * 	4.1. i가 2로 나눠지는 경우 dp[i/2] ,dp [i-1]비교
 * 	4.2. i가 3으로 나눠지는 경우 dp[i/3], dp[i-1] 비교
 * 	4.3. i가 6으로 나눠지는 경우 dp[i/3], dp[i/2], dp[i-1] 비교
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		dp[1] =0;
		for(int i =2 ;i<=N;i++) {

			if(i%6==0) {
				int temp = Math.min(dp[i-1], dp[i/2]);
				dp[i] = Math.min(temp, dp[i/3])+1;
				continue;
			}
			if(i%2==0) {
				dp[i] = Math.min(dp[i-1], dp[i/2])+1;
				continue;
			}
			if(i%3==0) {
				dp[i] = Math.min(dp[i-1], dp[i/3])+1;
				continue;
			}
			dp[i] = dp[i-1]+1;
		}
		System.out.println(dp[N]);
	}
}