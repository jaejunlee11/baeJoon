/*
 * 문제
 * 1. 판 -> N,M 100아허 쩍수
 * 2. 연산 6개
 * 	2.1. 상하 반전
 * 	2.2. 좌우 반전
 * 	2.3. 90도 우회전
 * 	2.4. 90도 좌회전
 * 	2.5. 4개로 나누고 우회전
 * 	2.6. 4개로 나누고 좌회전
 * 
 * 풀이
 * 1. 판 크기, 연산 수 입력
 * 2. 판 입력 -> arr[N][M]
 * 3. 연산 입력 한줄 -> control[R]
 * 4. 연산 실행 
 * 	4.1. 1인 경우 -> 크기가 같은 배열 생성 => 채우기(copy[i][j] = arr[M-1-i][N]) => 바꿔치기
 * 	4.2. 2인 경우 -> 크기가 같은 배열 생성 => 채우기(copy[i][j] = arr[M][N-1-ㅓ]) => 바꿔치기
 * 	4.3. 3인 경우 -> M,N서로 바꿔주기 => copy[N][M] 생성 => 채우기(copy[i][j] = arr[j][M-1-i]) => 바꿔치기
 * 	4.4. 4인 경우 ->  M,N서로 바꿔주기 => copy[N][M] 생성 => 채우기(copy[i][j] = arr[N-1-j][i]) => 바꿔치기
 * 	4.5. 5,6인 경우 -> 크기가 같은 배열 생성 => que만들기 => 1/4를 순서대로 넣어주기 => 복사 배열에 넣기 => 바꿔치기
 * 5. 출력
 * 
 * 시간 복잡도
 * 1. 10000*1000*(20까지) 허용 => 가능은 할듯
 * 
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<R;i++) {
			int control = Integer.parseInt(st.nextToken());
			switch( control ){
			case 1:{
				one();
				break;
			}
			case 2: {
				two();
				break;
			}
			case 3: {
				three();
				break;
			}
			case 4: {
				four();
				break;
			}
			case 5: {
				five();
				break;
			}case 6: {
				six();
				break;
			}
			
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void one(){
		int[][] copy = new int[N][M];
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				copy[i][j] = arr[N-1-i][j];
			}
		}
		arr = copy;
	}
	
	public static void two(){
		int[][] copy = new int[N][M];
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				copy[i][j] =  arr[i][M-1-j];
			}
		}
		arr = copy;
	}
	
	public static void three(){
		int temp = N;
		N=M;
		M=temp;
		int[][] copy = new int[N][M];
		for(int i = 0;i<M;i++) {
			for(int j = 0;j<N;j++) {
				copy[j][M-1-i] =  arr[i][j];
			}
		}
		arr = copy;
	}
	
	public static void four(){
		int temp = N;
		N=M;
		M=temp;
		int[][] copy = new int[N][M];
		for(int i = 0;i<M;i++) {
			for(int j = 0;j<N;j++) {
				copy[N-1-j][i] =  arr[i][j];
			}
		}
		arr = copy;
	}
	
	public static void six(){
		int[][] copy = new int[N][M];
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(i<N/2) {
					if(j<M/2) {
						copy[i][j] =  arr[i][j+M/2];
					}else {
						copy[i][j] =  arr[i + N/2][j];
					}
				}else {
						if(j<M/2) {
							copy[i][j] =  arr[i-N/2][j];
					}else {
						copy[i][j] =  arr[i][j-M/2];
					}
				}
			}
		}
		arr = copy;
	}
	
	public static void five(){
		int[][] copy = new int[N][M];
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(i<N/2) {
					if(j<M/2) {
						copy[i][j] =  arr[i+N/2][j];
					}else {
						copy[i][j] =  arr[i][j-M/2];
					}
				}else {
						if(j<M/2) {
							copy[i][j] =  arr[i][j+M/2];
					}else {
						copy[i][j] =  arr[i-N/2][j];
					}
				}
			}
		}
		arr = copy;
	}
}