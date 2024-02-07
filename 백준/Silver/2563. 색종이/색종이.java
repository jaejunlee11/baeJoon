/*
 * 문제
 * 1. 색종이 쌓기
 * 2. 색종이가 가린 넓이 구하기
 * 
 * 풀이
 * 1. 100 * 100 배열 만들기 -> arr[100][100]
 * 2. 왼쪽 변 -1 ~ 외쪽변+9 => 아래쪽 변  -1 ~ 아래쪽변 +9를 1로 채우기
 * 3. 1의 숫자 세기
 * 
 * 시간 복잡도
 * 1. 100*100 + 100*100 =>2만 충분
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[100][100];
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for(int j = r-1;j<r+9;j++) {
				for(int k = c-1; k<c+9;k++) {
					board[j][k]=1;
				}
			}
		}
		int answer = 0;
		for(int i = 0;i<100;i++) {
			for(int j = 0;j<100;j++) {
				if(board[i][j]==1) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}