/*
 * 문제
 * 1. 3개 문자열 존재
 * 2. LCS구하기
 * 
 * 풀이
 * 1. s1,s2,s3입력
 * 2. dp[s1길이+1][s2L+1][s3L+1]생성
 * 3. for문 돌리기 => s1길이
 * 	3.1. for문 돌리기 => s2의 길이
 * 		3.1.1. for문 돌리기 => s3의 길이
 * 			3.1.1.1. a = s1.charAt(i) , b = s2 , c =s3
 * 			3.1.1.2. a==b==c일때 => dp[i][j][k] = dp[i-1][j-1][k-1]+1
 * 4. dp[s1L][s2L][s3L]출력
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();
		int s1L = s1.length();
		int s2L = s2.length();
		int s3L = s3.length();
		int[][][] dp = new int[s1L+1][s2L+1][s3L+1];
		for(int i = 1;i<=s1L;i++) {
			for(int j =1;j<=s2L;j++) {
				for(int k = 1;k<=s3L;k++) {
					if(s1.charAt(i-1)==s2.charAt(j-1) && s1.charAt(i-1)==s3.charAt(k-1)) {
						dp[i][j][k] = dp[i-1][j-1][k-1]+1;
					}else {
						dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i][j-1][k]);
						dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k-1]);
						dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-1][k]);
						dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-1][k-1]);
						dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k-1]);
					}
				}
			}
		}
		System.out.println(dp[s1L][s2L][s3L]);
	}
}