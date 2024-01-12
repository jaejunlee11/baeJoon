/*
 * 1. 도화지 배열 만들기 -> 크기 100 * 100
 * 2. 검은 종이 입력 받기 -> x,y => x-x+10, y-y+10 채우기
 * 3. 도화지 배열의 1인 부분 계산
*/
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] whiteBoard = new int[100][100];
		for (int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j = 0; j<10;j++) {
				for(int k = 0; k<10;k++) {
					whiteBoard[x+k][y+j] =1;
					whiteBoard[x+j][y+k] =1;	
				}
				
			}
		}
		int sum = 0;
		for(int i = 0; i<100;i++) {
			for(int j = 0; j<100;j++) {
				sum +=whiteBoard[i][j];
			}
		}
		System.out.println(sum);
	}

}