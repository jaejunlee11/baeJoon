/*
 * 문제
 * 1. 배열 크기 N,M => 300,돌리는 수 R =>1000
 * 2. R만큼 돌리기
 * 
 * 풀이 
 * 1. 각 위치에 맞게 이동
 * 	1.1. 가장 바깥 부터 -> 한줄씩 땡기면서 계싼 (N/2,M/2지점까지)
 * 2. 출력
 * 
 * 시간 복잡도
 * 1. 300 * 300 * 1000 => 9천만 =>나가리
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr= new int[N][M];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int pick = Math.min(M, N);
		//N이 나눠 떨어지는경우
		//N/2개의 박스 존재
		for(int i = 0;i<pick/2;i++) {
			for(int r = 0;r<R;r++) {
				int pr = i;
				int pc = i;
				int temp1 = arr[pr][pc];//넣어야하는 임시 저장 수
				int temp2 =0; //사라져버리는 다음 수
				int k =0;
				//가장 바깥 박스 부터 이동
				for(int j = 0;j<((N-2*i)*2+(M-2*i)*2-4);j++) {
					int nr = pr + dir[k%4][0];
					int nc = pc + dir[k%4][1];
					if(nc-i<0 || nr-i < 0 || nr+i>=N || nc+i>=M ) {
						k++;
						nr = pr + dir[k%4][0];
						nc = pc + dir[k%4][1];
					}
					temp2 = arr[nr][nc];
					arr[nr][nc] = temp1;
					temp1 = temp2;
					pr = nr;
					pc = nc;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<N;i++) {
			for(int j = 0 ;j<M;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}