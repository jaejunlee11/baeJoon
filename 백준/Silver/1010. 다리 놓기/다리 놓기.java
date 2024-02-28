/*
 * 문제
 * 1. 서쪽 N개
 * 2. 동쪽 M개
 * 3. 다리를 겹치지 않게 설치
 * 4. 경우의 수 구하기
 * 
 * 풀이
 * 1. T 입력
 * 2. a, b입력
 * 3. 조합(b,a) or 조합(b,b-a) => 만약 b/2보다 a가 큰 경우 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[T][2];
		int max = 0;
		for(int t = 0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[t][0] = a;
			arr[t][1] = b;
			if(max<b) max =b;
		}
		long[][] dp = new long[max+1][max+1];
		for(int i = 0;i<=max;i++) {
			for(int j = 0 ;j<=max;j++) {
				if(i==j) {
					dp[i][j] = 1;
				}
				else if(j==0) {
					dp[i][j] = 1;
				}else if(i<j){
					
				}else {
					dp[i][j] = dp[i-1][j]+ dp[i-1][j-1];
				}
			}
		}
		for(int t = 0;t<T;t++) {
			System.out.println(dp[arr[t][1]][arr[t][0]]);
		}
	}
}