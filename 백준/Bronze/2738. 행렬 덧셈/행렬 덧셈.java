/*
 * 풀이
 * 1. N, M 입력
 * 2. Aarr[N][M] 생성
 * 3. arr채우기
 * 4, Barr[N][M] 생성
 * 5. arr채우기 
 * 6. 더해서 출력 
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arrA = new int[N][M];
		int[][] arrB = new int[N][M];
		for(int i= 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arrA[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i= 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arrB[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i= 0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print((arrA[i][j]+arrB[i][j])+" ");
			}
			System.out.println();
		}
	}
}