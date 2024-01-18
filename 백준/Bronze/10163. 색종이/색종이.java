/*
 * 1. 색종이 갯수 입력 받기
 * 2. 1001 * 1001 좌표 생성
 * 3. 각 번호에 맞게 배열 채우기
 * 4. 모든 색종이를 만든 후 각 번호 숫자 세기
 * 5. 순서대로 출력
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[1001][1001];
		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			for(int j = x1;j<x1+width;j++) {
				for(int k = y1;k<y1+height;k++){
					board[j][k]=i+1;
				}
			}
		}
		int[] countArr = new int[N+1];
		for(int i = 0;i<1001;i++) {
			for(int j=0;j<1001;j++) {
				countArr[board[i][j]]++;
			}
		}
		for(int i = 1;i<=N;i++) {
			System.out.println(countArr[i]);
		}
	}
}