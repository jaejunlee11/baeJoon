/*
 * 1. 4방향 탐색용 dir생성 {{1,0},{0,-1},{-1,0},{0,1}}
 * 2. 1번 cctv -> 한방향 탐색 for문으로 4개 다 돌리
 * 3. 2번 cctv -> 양방향 탐색 (0,2) (1,3) 묶어서 돌리기 
 * 4. 3번 cctv -> 두방향 탐색 (0,1) (1,2) (2,3) (3,0)
 * 5. 4번 cctv -> 3방향 탐색 (1,2,3) (2,3,4) (3,4,1) (4,1,2)
 * 6. 5번 cctv -> 4방향 탐색 (1,2,3,4)
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[][] dir = {{1,0},{0,-1},{-1,0},{0,1}};
	static int[][] board;
	static int N;
	static int M;
	static int minNum = Integer.MAX_VALUE;

	public static boolean rangeCheck(int r,int c) {
		if(r >= N || r <= -1 || c <= -1|| c>= M) return false;
		return true;
	}
	public static int whereCctv(int w,int[][] arr) {
		for(int i = 0;i<8;i++) {
			if(arr[i][0]==w) {
				return i;
			}
		}
		return 0;
	}
	public static void bfs(int[] cctvNums,int[][] cctvArray) {
//		System.out.println("-----------------------------------");
//		for(int i = 0;i<N;i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
		if(cctvNums[1]!=0) {
			int w = whereCctv(1,cctvArray);
			int r = cctvArray[w][1];
			int c = cctvArray[w][2];
			cctvArray[w][0] = 0;
			for(int k =0;k<4;k++) {
				int[][] tempBoard = new int[N][M];
				for(int i = 0; i < tempBoard.length; i++) {
					tempBoard[i] = board[i].clone();
				}
				cctvNums[1]--;
				cctv1(k,r,c);
				bfs(cctvNums,cctvArray);
				board = tempBoard;
				cctvNums[1]++;	
			}
			cctvArray[w][0] = 1;
		}else if(cctvNums[2]!=0) {
			int w = whereCctv(2,cctvArray);
			int r = cctvArray[w][1];
			int c = cctvArray[w][2];
			cctvArray[w][0] = 0;
			for(int k =0;k<2;k++) {
				int[][] tempBoard = new int[N][M];
				for(int i = 0; i < tempBoard.length; i++) {
					tempBoard[i] = board[i].clone();
				}
				cctvNums[2]--;
				cctv2(k,r,c);
				bfs(cctvNums,cctvArray);
				board = tempBoard;
				cctvNums[2]++;
			}
			cctvArray[w][0] = 2;
		}else if(cctvNums[3]!=0) {
			int w = whereCctv(3,cctvArray);
			int r = cctvArray[w][1];
			int c = cctvArray[w][2];
			cctvArray[w][0] = 0;
			for(int k =0;k<4;k++) {
				int[][] tempBoard = new int[N][M];
				for(int i = 0; i < tempBoard.length; i++) {
					tempBoard[i] = board[i].clone();
				}
				cctvNums[3]--;
				cctv3(k,r,c);
				bfs(cctvNums,cctvArray);
				board = tempBoard;
				cctvNums[3]++;
			}
			cctvArray[w][0] = 3;
		}else if(cctvNums[4]!=0) {
			int w = whereCctv(4,cctvArray);
			int r = cctvArray[w][1];
			int c = cctvArray[w][2];
			cctvArray[w][0] = 0;
			for(int k =0;k<4;k++) {
				int[][] tempBoard = new int[N][M];
				for(int i = 0; i < tempBoard.length; i++) {
					tempBoard[i] = board[i].clone();
				}
				cctvNums[4]--;
				cctv4(k,r,c);
				bfs(cctvNums,cctvArray);
				board = tempBoard;
				cctvNums[4]++;
			}
			cctvArray[w][0] = 4;
		}else if(cctvNums[5]!=0) {
			int w = whereCctv(5,cctvArray);
			int r = cctvArray[w][1];
			int c = cctvArray[w][2];
			cctvArray[w][0] = 0;
			int[][] tempBoard = new int[N][M];
			for(int i = 0; i < tempBoard.length; i++) {
				tempBoard[i] = board[i].clone();
			};
			cctvNums[5]--;
			cctv5(r,c);
			bfs(cctvNums,cctvArray);
			board = tempBoard;
			cctvNums[5]++;
			cctvArray[w][0] = 5;
		}else if(cctvNums[5]==0) {
			int temp = zeroFind();
			if(minNum>temp) minNum = temp;
			return;
		}
	}

	public static void cctv1(int k,int r,int c) {
		int nr = r + dir[k][0];
		int nc = c + dir[k][1];
		A : while(rangeCheck(nr,nc)) {
			switch(board[nr][nc]) {
			case 0:{
				board[nr][nc]=-1;
				nr = nr + dir[k][0];
				nc = nc + dir[k][1];
				break;
			}
			case -1:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: {
				nr = nr + dir[k][0];
				nc = nc + dir[k][1];
				break;
			}
			case 6: break A;
			}
		}
	}

	public static void cctv2(int k,int r,int c) {
		int nr = r + dir[k][0];
		int nc = c + dir[k][1];
		A : while(rangeCheck(nr,nc)) {
			switch(board[nr][nc]) {
			case 0:{
				board[nr][nc]=-1;
				nr = nr + dir[k][0];
				nc = nc + dir[k][1];
				break;
			}
			case -1:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: {
				nr = nr + dir[k][0];
				nc = nc + dir[k][1];
				break;
			}
			case 6: break A;
			}
		}
		nr = r + dir[k+2][0];
		nc = c + dir[k+2][1];
		A : while(rangeCheck(nr,nc)) {
			switch(board[nr][nc]) {
			case 0:{
				board[nr][nc]=-1;
				nr = nr + dir[k+2][0];
				nc = nc + dir[k+2][1];
				break;
			}
			case -1:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: {
				nr = nr + dir[k+2][0];
				nc = nc + dir[k+2][1];
				break;
			}
			case 6: break A;
			}
		}
	}

	public static void cctv4(int k,int r,int c) {
		int nr = r + dir[k][0];
		int nc = c + dir[k][1];
		A : while(rangeCheck(nr,nc)) {
			switch(board[nr][nc]) {
			case 0:{
				board[nr][nc]=-1;
				nr = nr + dir[k][0];
				nc = nc + dir[k][1];
				break;
			}
			case -1:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: {
				nr = nr + dir[k][0];
				nc = nc + dir[k][1];
				break;
			}
			case 6: break A;
			}
		}

		nr = r + dir[(k+1)%4][0];
		nc = c + dir[(k+1)%4][1];
		A : while(rangeCheck(nr,nc)) {
			switch(board[nr][nc]) {
			case 0:{
				board[nr][nc]=-1;
				nr = nr + dir[(k+1)%4][0];
				nc = nc + dir[(k+1)%4][1];
				break;
			}
			case -1:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: {
				nr = nr + dir[(k+1)%4][0];
				nc = nc + dir[(k+1)%4][1];
				break;
			}
			case 6: break A;
			}
		}

		nr = r + dir[(k+2)%4][0];
		nc = c + dir[(k+2)%4][1];
		A : while(rangeCheck(nr,nc)) {
			switch(board[nr][nc]) {
			case 0:{
				board[nr][nc]=-1;
				nr = nr + dir[(k+2)%4][0];
				nc = nc + dir[(k+2)%4][1];
				break;
			}
			case -1:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: {
				nr = nr + dir[(k+2)%4][0];
				nc = nc + dir[(k+2)%4][1];
				break;
			}
			case 6: break A;
			}
		}
	}

	public static void cctv3(int k,int r,int c) {
		int nr = r + dir[k][0];
		int nc = c + dir[k][1];
		A : while(rangeCheck(nr,nc)) {
			switch(board[nr][nc]) {
			case 0:{
				board[nr][nc]=-1;
				nr = nr + dir[k][0];
				nc = nc + dir[k][1];
				break;
			}
			case -1:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: {
				nr = nr + dir[k][0];
				nc = nc + dir[k][1];
				break;
			}
			case 6: break A;
			}
		}

		nr = r + dir[(k+1)%4][0];
		nc = c + dir[(k+1)%4][1];
		A : while(rangeCheck(nr,nc)) {
			switch(board[nr][nc]) {
			case 0:{
				board[nr][nc]=-1;
				nr = nr + dir[(k+1)%4][0];
				nc = nc + dir[(k+1)%4][1];
				break;
			}
			case -1:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: {
				nr = nr + dir[(k+1)%4][0];
				nc = nc + dir[(k+1)%4][1];
				break;
			}
			case 6: break A;
			}
		}
	}

	public static void cctv5(int r,int c) {
		int nr = r + dir[0][0];
		int nc = c + dir[0][1];
		A : while(rangeCheck(nr,nc)) {
			switch(board[nr][nc]) {
			case 0:{
				board[nr][nc]=-1;
				nr = nr + dir[0][0];
				nc = nc + dir[0][1];
				break;
			}
			case -1:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: {
				nr = nr + dir[0][0];
				nc = nc + dir[0][1];
				break;
			}
			case 6: break A;
			}
		}

		nr = r + dir[1][0];
		nc = c + dir[1][1];
		A : while(rangeCheck(nr,nc)) {
			switch(board[nr][nc]) {
			case 0:{
				board[nr][nc]=-1;
				nr = nr + dir[1][0];
				nc = nc + dir[1][1];
				break;
			}
			case -1:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: {
				nr = nr + dir[1][0];
				nc = nc + dir[1][1];
				break;
			}
			case 6: break A;
			}
		}

		nr = r + dir[2][0];
		nc = c + dir[2][1];
		A : while(rangeCheck(nr,nc)) {
			switch(board[nr][nc]) {
			case 0:{
				board[nr][nc]=-1;
				nr = nr + dir[2][0];
				nc = nc + dir[2][1];
				break;
			}
			case -1:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: {
				nr = nr + dir[2][0];
				nc = nc + dir[2][1];
				break;
			}
			case 6: break A;
			}
		}

		nr = r + dir[3][0];
		nc = c + dir[3][1];
		A : while(rangeCheck(nr,nc)) {
			switch(board[nr][nc]) {
			case 0:{
				board[nr][nc]=-1;
				nr = nr + dir[3][0];
				nc = nc + dir[3][1];
				break;
			}
			case -1:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: {
				nr = nr + dir[3][0];
				nc = nc + dir[3][1];
				break;
			}
			case 6: break A;
			}
		}
	}

	//board내 0 갯수 탐색
	public static int zeroFind() {
		int count = 0;
		for(int i = 0;i<N;i++) {
			for (int j = 0; j<M;j++) {
				if(board[i][j]==0) count++;
			}
		}
		return count;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		//cctv들의 갯수를 담는 배열
		int[] cctvNums = new int[6];
		int[][] cctvArray = new int[8][3];
		int cctvCount = 0;
		//cctv찾기 + 보드 채우기
		for(int i = 0;i<N;i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0 ;j<M;j++) {
				int tempNum = Integer.parseInt(st1.nextToken());
				board[i][j] = tempNum;
				if(tempNum>0 && tempNum<6) {
					cctvNums[tempNum]++;
					cctvArray[cctvCount][0] = tempNum;
					cctvArray[cctvCount][1] = i;
					cctvArray[cctvCount++][2] = j;
				}
			}
		}
		bfs(cctvNums,cctvArray);
		System.out.println(minNum);
	}
}

