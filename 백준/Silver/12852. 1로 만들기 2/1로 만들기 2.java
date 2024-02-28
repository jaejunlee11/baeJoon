/*
 * 문제
 * 1. x 3으로 나누기
 * 2. x 2로 나누기
 * 3. x 1빼기
 * 
 * 풀이
 * 1. N입력
 * 2. dp[N+1][2]생성
 * 3. dp[1][0] = 1 //어디서 오는지
 * 4. dp[1][1] = 0 //연산 횟수
 * 5. dp[i][0] = dp[i-1][1], dp[i/2][1]비교 => 더작은 것의 인덱스 저장 //i가 2로 나누어질 때
 * 6. dp[i][1]도 채우기
 * 7. 마지막에 dp[N][0]를 따라가면서 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][2];
		dp[1][0] = 1;
		dp[1][1] = 0;
		for(int i = 2;i<=N;i++) {
			if(i%6==0) {
				if(dp[i-1][1]<dp[i/2][1]) {
					if(dp[i-1][1]<dp[i/3][1]) {
						dp[i][0] = i-1;
						dp[i][1] = dp[i-1][1] +1;
					}else {
						dp[i][0] = i/3;
						dp[i][1] = dp[i/3][1] +1;
					}
				}else {
					if(dp[i/2][1] < dp[i/3][1]){
						dp[i][0] = i/2;
						dp[i][1] = dp[i/2][1] +1;
					}else {
						dp[i][0] = i/3;
						dp[i][1] = dp[i/3][1] +1;
					}
				}
				continue;
			}
			if(i%2==0) {
				if(dp[i-1][1]<dp[i/2][1]) {
					dp[i][0] = i-1;
					dp[i][1] = dp[i-1][1] +1;
				}else {
					dp[i][0] = i/2;
					dp[i][1] = dp[i/2][1] +1;
				}
				continue;
			}
			if(i%3==0) {
				if(dp[i-1][1]<dp[i/3][1]) {
					dp[i][0] = i-1;
					dp[i][1] = dp[i-1][1] +1;
				}else {
					dp[i][0] = i/3;
					dp[i][1] = dp[i/3][1] +1;
				}
				continue;
			}
			dp[i][0] = i-1;
			dp[i][1] = dp[i-1][1] +1;
		}
//		for(int i = 1;i<=N;i++) {
//			System.out.print(Arrays.toString(dp[i]));
//		}
//		System.out.println();
		System.out.println(dp[N][1]);
		while(true) {
			System.out.print(N+" ");
			if(N==1) return;
			N = dp[N][0];
		}
	}
}