/*
 * 문제
 * 1. N M 입력
 * 2. 배열 입력 받기
 * 3. M개의 x1,y1,x2,y2입력
 * 4. 해당 범위의 합을 전부 구하기
 * 풀이
 * 1. N,M입력 받기
 * 2. 배열 입력 받기 arr[][] -> 1줄씩 누적합 계산
 * 5. x1~x2 for문 돌릭
 * 	5.1. arr[i][y2]-arr[i][y1-1] 더하기
 * 6. 출력
 * 
 * 시간 복잡도 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][N+1];
		//가로 누적합
		for(int i = 1 ; i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<=N;j++ ) {
				arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0;k<M;k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int i =x1;i<=x2;i++) {
				sum += (arr[i][y2]-arr[i][y1-1]);
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}
}