/*
 * 문제
 * 1. 2048게임
 * 2. 판 크기와 판이 주어짐
 * 3. 5번 이동해서 만들 수 있는 최대 숫자 구하기
 * 
 * 풀이
 * 1. N 입력
 * 2. arr[N][N]생성
 * 3. arr입력 받기
 * 4. dfs돌리기
 * 	4.1. 상, 하, 좌, 우 선택
 * 	4.2. 같은 숫자가 겹치면 합치기
 * 	4.3. 다른 숫자가 있으면 쌓이기
 * 5. 최대 숫자 출력
 * 
 * dfs(depth, 최대 숫자, 이전 이동 방향 ,판)
 * 0. 최대숫자 * 2^(5-depth) <=answer면 return;
 * 1. depth ==5
 * 	1.1. answer와 최대 숫자 비교해서 갱신
 * 2. for문 4방향
 * 	2.1. 이전 이동 방향은 pass
 * 	2.2. 판 복사
 * 	2.3. 복사판 이동 => 숫자 갱신때 최대숫자 갱신 
 * 	2.4. dfs(depth+1, 최대 숫자 , 현재 이동방향,복사판)
 * 
 * 복사판 이동
 * 1. 이동방향의 반대 부터 탐색 -> 오른쪽 이동 = (N-1~0)
 * 2. 이동방향으로 이동 시키기 => 0으로 변경 flag는 true로 시작 
 * 	2.1. 벽에 부딪힌 경우 해당 위치에 숫자 두기 + flag = true 
 * 	2.2. 0이 아닌 것을 만난 경우
 * 		2.2.1. 숫자가 같은 경우 flag=true인 경우 
 * 			2.2.1.1. 해당 칸에 *2로 변경
 * 			2.2.1.2. flag = false로 변경
 * 		 2.2.2. 숫자가 다른 경우  or flag=false인 경우 
 * 			2.2.2.1. 해당칸 전칸에 해당 숫자 두기 + flag = true
 * 		
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] board;
	static int answer;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		int bigNum = 0;
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(bigNum<board[i][j]) bigNum = board[i][j];
			}
		}
		answer = bigNum;
		dfs(0,bigNum,-1,board);
		System.out.println(answer);
	}
	static void dfs(int depth, int bigNum,int beforeDir, int[][] map) {
		if(bigNum * (int)Math.pow(2, 10-depth)<=answer) return;
		if(depth==10) {
			if(answer<bigNum) answer = bigNum;
			return;
		}
		for(int k = 0;k<4;k++) {
//			if(k==beforeDir) continue;
			int[][] temp = new int[N][N];
			for(int i = 0;i<N;i++) {
				temp[i] = map[i].clone();
			}
			int num = move(temp,bigNum,k);
//			System.out.println( "횟수" + depth+"방향"+k);
//			for(int i = 0 ;i<N;i++) {
//				System.out.println(Arrays.toString(temp[i]));
//			}
//			System.out.println();
			dfs(depth+1,num,k,temp);
		}
	}
	static int move(int[][] temp,int bigNum,int moveDir) {
		for(int i = 0 ;i<N;i++) {
			boolean flag = true;
			if(moveDir==0) {
				for(int j = N-1;j>=0;j--) {
					int r = i;
					int c = j;
					int num = temp[r][c];
					temp[r][c] = 0;
					if(num==0) continue;
					int nr = r + dir[moveDir][0];
					int nc = c + dir[moveDir][1];
					while(true) {
//						System.out.println("move" + nr+" "+nc);
						if(nr<0 || nc<0 || nr>=N || nc>=N ) {
							temp[nr-dir[moveDir][0]][nc-dir[moveDir][1]] = num;
							flag = true;
							break;
						}
						if(temp[nr][nc]==0) {
							nr  = nr + dir[moveDir][0];
							nc = nc  + dir[moveDir][1];
							continue;
						}
						if(temp[nr][nc]==num && flag==true) {
							temp[nr][nc] = num*2;
							if(temp[nr][nc]>bigNum) bigNum = temp[nr][nc];
							flag = false;
							break;
						}
						if(temp[nr][nc]!=0) {
							temp[nr-dir[moveDir][0]][nc-dir[moveDir][1]] = num;
							flag = true;
							break;
						}
					}
				}
			}else if(moveDir==1){
				for(int j = N-1;j>=0;j--) {
					int r = j;
					int c = i;
					int num = temp[r][c];
					temp[r][c] = 0;
					if(num==0) continue;
					int nr = r + dir[moveDir][0];
					int nc = c + dir[moveDir][1];
					while(true) {
//						System.out.println("move" + nr+" "+nc);
						if(nr<0 || nc<0 || nr>=N || nc>=N ) {
							temp[nr-dir[moveDir][0]][nc-dir[moveDir][1]] = num;
							flag = true;
							break;
						}
						if(temp[nr][nc]==0) {
							nr  = nr + dir[moveDir][0];
							nc = nc  + dir[moveDir][1];
							continue;
						}
						if(temp[nr][nc]==num && flag==true) {
							temp[nr][nc] = num*2;
							if(temp[nr][nc]>bigNum) bigNum = temp[nr][nc];
							flag = false;
							break;
						}
						if(temp[nr][nc]!=0) {
							temp[nr-dir[moveDir][0]][nc-dir[moveDir][1]] = num;
							flag = true;
							break;
						}
					}
				}
			}else if(moveDir==2){
				for(int j = 0;j<N;j++) {
					int r = i;
					int c = j;
					int num = temp[r][c];
					temp[r][c] = 0;
					if(num==0) continue;
					int nr = r + dir[moveDir][0];
					int nc = c + dir[moveDir][1];
					while(true) {
//						System.out.println("move" + nr+" "+nc);
						if(nr<0 || nc<0 || nr>=N || nc>=N ) {
							temp[nr-dir[moveDir][0]][nc-dir[moveDir][1]] = num;
							flag = true;
							break;
						}
						if(temp[nr][nc]==0) {
							nr  = nr + dir[moveDir][0];
							nc = nc  + dir[moveDir][1];
							continue;
						}
						if(temp[nr][nc]==num && flag==true) {
							temp[nr][nc] = num*2;
							if(temp[nr][nc]>bigNum) bigNum = temp[nr][nc];
							flag = false;
							break;
						}
						if(temp[nr][nc]!=0) {
							temp[nr-dir[moveDir][0]][nc-dir[moveDir][1]] = num;
							flag = true;
							break;
						}
					}
				}
			}else if(moveDir==3){
				for(int j = 0;j<N;j++) {
					int r = j;
					int c = i;
					int num = temp[r][c];
					temp[r][c] = 0;
					if(num==0) continue;
					int nr = r + dir[moveDir][0];
					int nc = c + dir[moveDir][1];
					while(true) {
//						System.out.println("move" + nr+" "+nc);
						if(nr<0 || nc<0 || nr>=N || nc>=N ) {
							temp[nr-dir[moveDir][0]][nc-dir[moveDir][1]] = num;
							flag = true;
							break;
						}
						if(temp[nr][nc]==0) {
							nr  = nr + dir[moveDir][0];
							nc = nc  + dir[moveDir][1];
							continue;
						}
						if(temp[nr][nc]==num && flag==true) {
							temp[nr][nc] = num*2;
							if(temp[nr][nc]>bigNum) bigNum = temp[nr][nc];
							flag = false;
							break;
						}
						if(temp[nr][nc]!=0) {
							temp[nr-dir[moveDir][0]][nc-dir[moveDir][1]] = num;
							flag = true;
							break;
						}
					}
				}
			}
		}
		return bigNum;
	}
}