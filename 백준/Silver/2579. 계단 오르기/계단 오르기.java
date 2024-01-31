/*
1. N입력 받기
2. arr dp[N+1][3] 배열 만들기
3. 배열 입력 받기
4. 배열을 돌기 -> 100 100 0 100 100 0
	4.1. N일 때 -> 전에 먹은 경우, 전전에도 먹은 경우, 전에 안먹은 경우
	4.2. N이 전에 먹은 경우 -> N-1이 전에 안먹은 경우 + 해당 계단 값
	4.3. N이 전전에 먹은 경우 -> N-1이 전에 먹은 경우 + 해당 계단 값
	4.4. N이 전에 안먹은 경우 -> (N-1이 전에 안먹은 경우, N-1이 전전에 먹은 경우의 최대값)
 */ 
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr =new int[N+1][4];
		int[] point = new int[N+1];
		for(int i = 1 ; i <=N;i++) {
			point[i] = Integer.parseInt(br.readLine());
		}
		/* --00--
		 00--00
		 0-0-0-0
		 [00xx]00
		*/
		arr[N][0] = point[N];
		arr[N][1] = point[N];
		arr[N][2] = Integer.MIN_VALUE;
		arr[N][3] = Integer.MIN_VALUE;
		for(int i = N-1 ;i >=1 ;i--) {
			arr[i][0] = Math.max(arr[i+1][2], arr[i+1][3]) + point[i];
			arr[i][1] = arr[i+1][0]+ point[i];
			arr[i][2] = arr[i+1][0];
			arr[i][3] = arr[i+1][1];
		}
		int answer = Math.max(arr[1][0], arr[1][1]);
		answer = Math.max(arr[1][2], answer);
		answer = Math.max(arr[1][3], answer);
		System.out.println(answer);
	}
}