/*
 * 문제
 * 1. 문자가 잇음
 * 2. 문자를 팰린드롬 분할
 * 3. 필랜드롬으로 분할할 때 최대한 적은수로 이루어져야함
 * 
 * 풀이
 * 1. 문자 입력 받기
 * 2. 문자열 길이 N
 * 3. dp[N][N]생성
 * 4. for문 돌리기 => N-1~0
 * 	4.1. for문 돌리기  => N-1~i
 * 		4.1.1. i+1==j 일때 temp.charAt(i)==temp.charAt(j)이면 dp[i][j] = 1 아니면 0
 * 		4.1.2. i==j이면 dp[i][j]=1
 * 		4.1.3. temp.charAt(i)==temp.charAt(j)이고 dp[i][j] = dp[i+1][j-1]
 * 5. dp2[N+1] 생성
 * 6. dp2[1] = 1
 * 7. for문 돌리기 2~N
 * 	7.1. for문 돌리기1~j+1
 * 		7.1.0. temp = MAX
 * 		7.1.1. if(dp[i-1][j] == 1) temp 갱신 
 * 	7.2. dp2[j] = temp;
 * 
 * dfs(i,count)
 * 1. count가 최소값보다 같거나 크면 return
 * 2. i==N이면 count갱신
 * 3. for문 돌리기 N-1~i
 * 	3.1. dp[i][j]==1이면 dfs(j+1,count+1)
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;
	static int N;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		N = temp.length();
//		System.out.println(N);
		dp = new int[N][N];
		for(int i = N-1;i>=0;i--) {
			for(int j = N-1;j>=i;j--) {
				if(i+1==j) {
					if(temp.charAt(i)==temp.charAt(j)) {
						dp[i][j]=1;
					}
				}else if(i==j){
					dp[i][j]=1;
				}else if(temp.charAt(i)==temp.charAt(j)){
					dp[i][j] = dp[i+1][j-1];
				}
			}
		}
//		dfs(0,0);
		int[] dp2 = new int[N+1];
		dp2[1]=1;
		for(int j = 2;j<=N;j++) {
			int tempNum = Integer.MAX_VALUE;
			for(int i = 0;i<j;i++) {
				if(dp[i][j-1] == 1) {
					tempNum = Math.min(tempNum, dp2[i]);
				}
			}
			dp2[j] = tempNum+1;
		}
		System.out.println(dp2[N]);
	}
	private static boolean dfs(int i,int count) {
		if(count>=answer) return false;
		if(i==N) {
			answer = Math.min(answer, count);
			return true;
		}
		for(int j =N-1;j>=i;j--) {
			if(dp[i][j]==1) {
				if(dfs(j+1,count+1)) return true;
			}
		}
		return false;
	}
}