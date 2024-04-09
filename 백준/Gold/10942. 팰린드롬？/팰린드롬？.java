/*
 * 문제
 * 1. 배열이 주어짐
 * 2. 배열의 범위를 줌
 * 3. 해당 값이 팰린드롬인지 판단
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N]생성
 * 3. arr 채우기
 * 4. dp[N][N]생성
 * 5. for문 돌기 N까지
 * 	5.1. for문 돌기 N-1부터 i까지
 * 		5.1.0. dp[i][j] != 0 이면 continue
 * 		5.1.1. dfs(i,j);
 * 6. M입력
 * 7. for문 돌기 M까지
 * 	7.1. dp[a-1][b-1]출력 => -1이면 0
 * 
 * dfs(i,j)
 * 0. i>j이면 return 1;
 * 1. arr[i]!=arr[j]인 경우 return dp[i][j] = -1
 * 2. arr[i]==arr[j]인 경우 return dp[i][j] = dfs(i-1,j-1);
 * 
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[]arr;
	static int[][] dp;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0;i<N;i++) {
			for(int j = N-1;j>=i;j--) {
				if(dp[i][j]!=0) continue;
				dfs(i,j);
			}
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i =0 ;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(dp[a-1][b-1]==-1) {
				sb.append("0\n");
			}else {
				sb.append("1\n");
			}
		}
		System.out.println(sb);
	}
	private static int dfs(int i, int j) {
		if(i>j) return 1;
//		System.out.println(i +" " + j);
		if(arr[i]!=arr[j]) return dp[i][j] = -1;
		if(arr[i]==arr[j]) return dp[i][j] = dfs(i+1,j-1);
		return 0;
	}
}