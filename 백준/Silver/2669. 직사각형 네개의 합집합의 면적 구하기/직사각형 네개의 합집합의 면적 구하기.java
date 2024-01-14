/*
 * 1. 100*100배열 생성
 * 2. 받아온 x,y좌표를 통해서 배열 채우기(이중 for문 사용)
 * 3. 배열을 확인해서 면적 구하기
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[100][100];
		for(int i = 0; i< 4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int j = x1 ;j<x2;j++) {
				for(int k = y1; k<y2;k++) {
					board[j][k]=1;
				}
			}
		}
		int answer = 0;
		for(int i=0;i<100;i++) {
			for(int j = 0;j<100;j++) {
				if(board[i][j]==1) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}