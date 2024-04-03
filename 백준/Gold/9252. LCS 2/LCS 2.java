/*
 * 문제
 * 1. 문자열 2개 존재
 * 2. 두 문자열의 부분 문자열 중 최장 거리의 숫자와 글자
 * 
 * 풀이
 * 1. String s1, s2입력
 * 2. dp[s1길이+1][s2길이 +1][2]생성
 * 3. for문 돌리기 1~ s1갈이
 * 	3.1. for문 돌릭 1~s2길이
 * 		3.1.1. s1.chartAt(i}==s2.charAt(j)인 경우 => dp[i][j][0] = dp[i][j][0]+1, dp[i][j][1] = 100*dp[i-1][j-1][1] +s1.charAt(i)
 * 		3.1.2. 아닌 경우 => dp[i][j-1][0]>dp[i-1][j][0] => dp[i][j][0] = dp[i][j-1][0], dp[i][j][1] = dp[i][j-1][1]
 * 									else => dp[i][j][0] = dp[i-1][j][0], dp[i][j][1] = dp[i-1][j][1]
 * 4. dp[s1길이][s2길이][0] 출력
 * 5. temp = dp[s1길이][s2길이][1]
 * 6. while(temp>0)
 * 	6.1. sysout ((char)(temp%100))
 * 	6.2. temp /=100
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int s1Len = s1.length();
		int s2Len = s2.length();
		int[][] dp = new int[s1Len+1][s2Len+1];
		for(int i = 1;i<=s1Len;i++) {
			for(int j = 1;j<=s2Len;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					if(dp[i][j-1]>dp[i-1][j]) {
						dp[i][j] = dp[i][j-1];
					}else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}
		int i = s1Len;
		int j = s2Len;
		StringBuilder sb = new StringBuilder();
		while(true) {
			if(i==0 || j==0) break;
			if(dp[i][j]-1==dp[i-1][j-1] && s1.charAt(i-1)==s2.charAt(j-1)) {
				sb.append(s1.charAt(i-1));
				i --;
				j --;
				continue;
			}
			if(dp[i][j]==dp[i][j-1]) {
				j--;
				continue;
			}
			if(dp[i][j]==dp[i-1][j]) {
				i--;
				continue;
			}
		}
		System.out.println(dp[s1Len][s2Len]);
		sb.reverse();
		System.out.println(sb);
	}
}