/*
 * 문제
 * 1. N,M(배열판 크기 50 50), K 주어짐 ->6
 * 2. 배열을 r,c를 기준으로 S칸 돌림 -> 시계
 * 3. 다돌린 후에 각행의 합의 최소값 구하기
 * 
 * 풀이
 * 1. N ,M, K 입력 받기
 * 2. arr[N][M]만들기
 * 3. 배열 입력 받기
 * 4. 순열 만들어서 순서 정해주기 -> 배열
 * 6. 최소값 출력
 * 
 * 순열
 * 1. depth도달시 
 *  * 4. for(K)만큼 돌릭 ->6
 * 		4.1. for(S)만큼 돌리기 -> 2500+4*s
 * 			4.1.1. arr[N-j][M-j]부터 방향 설정해서 쭉 돌리기
 * 	5.배열의 각 행 합 구하기
 * 	6.최소갑 업데이트
 * 2. for문으로 K돌리기
 * 
 * 생각할 것
 * 1. 100*50 -> int로 충분
 * 
 * 시간 복잡도
 * 1.  (5000*6 + 2500)* 720 = 3000만 => 충분
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int N;
	static int M;
	static int K;
	static int minValue;
	static int[] picked;
	static boolean[] used;
	static int[][] order;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minValue = Integer.MAX_VALUE;
		picked = new int[K];
		used = new boolean[K];
		order = new int[K][3];
		for(int i = 0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			order[i][0] = Integer.parseInt(st.nextToken())-1;
			order[i][1] = Integer.parseInt(st.nextToken())-1;
			order[i][2] = Integer.parseInt(st.nextToken());
		}
		recur(0);
		System.out.println(minValue);
	}
	
	public static void recur(int depth) {
		if(depth == K) {
			int[][] temp = new int[N][M];
			for(int i =0;i<N;i++) {
				for(int j = 0;j<M;j++) {
					temp[i][j] = arr[i][j];
				}
			}
			for(int i = 0;i<K;i++) {
				int r =  order[picked[i]][0];
				int c =  order[picked[i]][1];
				int s =  order[picked[i]][2];
				loop(r,c,s);
			}
			for(int i = 0;i<N;i++) {
				int tempSum = 0;
				for(int j = 0;j<M;j++) {
					tempSum+=arr[i][j];
				}
				minValue = Math.min(minValue, tempSum);
			}
			for(int i =0;i<N;i++) {
				for(int j = 0;j<M;j++) {
					arr[i][j] = temp[i][j];
				}
			}
		}
		for(int i = 0;i<K;i++) {
			if(used[i]) continue;
			picked[depth] = i;
			used[i] = true;
			recur(depth+1);
			used[i] = false;
		}
	}
	
	public static void loop(int r, int c,int s) {
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		for(int i = 1;i<=s;i++) {
			int nr = r - i;
			int nc = c - i;
			int br = nr;
			int bc = nc;
			int temp = arr[nr][nc];
//			System.out.println(temp);
			//하 우 상 좌
			for(int k = 0;k<4;k++) {
				//2s만큼씩 이동
				for(int j = 0;j<2*i;j++) {
					br = nr;
					bc = nc;
					nr = nr + dir[k][0];
					nc = nc + dir[k][1];
					arr[br][bc] = arr[nr][nc];
				}
			}
			//마지막 값만 이상한 값이 들어있으니 temp로 변경
			arr[r-i][c-i+1] = temp;
//			for(int l = 0;l<N;l++) {
//				System.out.println(Arrays.toString(arr[l]));
//				
//			}System.out.println();
		}
	}
}