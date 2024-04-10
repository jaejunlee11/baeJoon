/*
 * 문제
 * 1. 캠퍼스가 존재
 * 2. D분 동안 산책
 * 3. D분 후에는 되돌아 와야함
 * 4. D분 동안 산책 가능한 경우의 수
 * 
 * 풀이
 * 1. N입력
 * 2. dp[N+1][8]생성
 * 	2.1. 0 : 정보과학관, 1 : 전산관, 2 : 미래관 , 3: 신양관, 4: 한경직기념관, 5 : 진리관, 6 : 학생회관, 7 : 형남공학관
 * 3. dp[0][0] = 1
 * 4. dp[i][0] = dp[i-1][1] + dp[i-1][2];
 * 5. dp[i][1] = dp[i-1][0] + dp[i-1][2] + dp[i-1][3];
 * 6. dp[i][2] = dp[i-1][0] + dp[i-1][1] + dp[i-1][3] + dp[i-1][4];
 * 7. dp[i][3] = dp[i-1][1] + dp[i-1][2] + dp[i-1][4] + dp[i-1][5];
 * 8. dp[i][4] = dp[i-1][2] + dp[i-1][3] + dp[i-1][5] + dp[i-1][7];
 * 9. dp[i][5] = dp[i-1][3] + dp[i-1][4] + dp[i-1][6];
 * 10.dp[i][6] = dp[i-1][5] + dp[i-1][7];
 * 11.dp[i][7] = dp[i-1][4] + dp[i-1][6];
 * 12 dp[N][0]출력 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] dp = new long[N+1][8];
		dp[0][0] = 1;
		for(int i = 1;i<=N;i++) {
			dp[i][0] = (dp[i-1][1] + dp[i-1][2])%1000000007;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2] + dp[i-1][3])%1000000007;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][3] + dp[i-1][4])%1000000007;
			dp[i][3] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4] + dp[i-1][5])%1000000007;
			dp[i][4] = (dp[i-1][2] + dp[i-1][3] + dp[i-1][5] + dp[i-1][7])%1000000007;
			dp[i][5] = (dp[i-1][3] + dp[i-1][4] + dp[i-1][6])%1000000007;
			dp[i][6] = (dp[i-1][5] + dp[i-1][7])%1000000007;
			dp[i][7] = (dp[i-1][4] + dp[i-1][6])%1000000007;
		}
			System.out.println(dp[N][0]);
	}
}