/*
 * 문제
 * 1. 기차가 존재
 * 2. 기차는 상,하,좌,우로 이동가능
 * 3. 기차는 회전도 가능 but 3*3지역에 아무것도 없어야함
 * 4. 기차의 길이는 항상 3
 * 5. 1은 벽, 0은 갈 수 있는 곳
 * 6. EEE에 도착하는 최소 거리
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N][N]생성, startR, startC, startA, endR,endC,endA
 * 3. arr채우기
 * 	3.1. B or E를 만나는 경우
 * 	3.2. 4방 탐색 => B가 상하에 있는 경우  startR,C세팅 + startA = 1, 아닌경우0
 * 4. que생성
 * 5. visited1[N][N]
 * 6. visited2[N][N]
 * 7. que에 startR,startC,startA담기, count = 0
 * 8. while돌리기 => que 빌때 까지
 * 	9. queSize체크, count++
 * 	10. while돌리기 => queSize만큼
 * 		11. loc = que.poll
 * 		12. loc[2] == 0인 경우
 * 			12.1 상하 탐색
 * 				12.1.1. int nr = r+dir[], int nc = c+dir
 * 				12.1.2. 경계 체크
 * 				12.1.3. arr[nc-1][nr], arr[nc][nr], arr[nc+1][nr] 이 1이면 continue
 * 			12.2. 좌우 탐색
 * 				12.2.1. int nr = r+dir[], int nc = c+dir
 * 				12.2.2. nr+1, nr-1 경계 체크
 * 				12.2.3. arr[nc][nr+1], arr[nc][nr-1] 1이면 continue
 * 			12.3. 회전 체크 => lotate = {}생성
 * 				12.3.1. 경계 체크
 * 				12.3.2. 1체크 continue
 * 		
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int startR = -1;
		int startC = -1;
		int startA = -1;
		int endR = -1;
		int endC = -1;
		int endA = -1;
		for(int i = 0;i<N;i++) {
			String temp = br.readLine();
			for(int j = 0;j<N;j++) {
				if(temp.charAt(j)=='B' && startA==-1) {
					if(j+1<N && temp.charAt(j+1)=='B') {
						startR=i;
						startC=j+1;
						startA=0;
					}else {
						startR=i+1;
						startC=j;
						startA=1;
					}
				}
				if(temp.charAt(j)=='E' && endA==-1) {
					if(j+1<N && temp.charAt(j+1)=='E') {
						endR=i;
						endC=j+1;
						endA=0;
					}else {
						endR=i+1;
						endC=j;
						endA=1;
					}
				}
				if(temp.charAt(j)=='1') {
					arr[i][j]=1;
				}
			}
		}
		//회전용 dirR
		int[][] dirR = {{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1}};
		//-상용 dirU0
		int[][] dirU0 = {{-1,-1},{-1,0},{-1,1}};
		//-하용 dirD0
		int[][] dirD0 = {{1,-1},{1,0},{1,1}};
		//l좌용 dirL1
		int[][] dirL1 = {{-1,-1},{0,-1},{1,-1}};
		//l우용 dirR1
		int[][] dirR1 = {{-1,1},{0,1},{1,1}};
		// - 
		boolean visited1[][] = new boolean[N][N];
		// l
		boolean visited2[][] = new boolean[N][N];
		Deque<int[]> que = new ArrayDeque<>();
		que.add(new int[] {startR,startC,startA});
		int count = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			count++;
			while(size-- >0) {
				int[] loc = que.poll();
				int r = loc[0];
				int c = loc[1];
				int a = loc[2];
				
//				for(int i = 0;i<N;i++) {
//					System.out.println(Arrays.toString(visited2[i]));
//				}
//				System.out.println();
				// - 
				if(a==0) {
					A : for(int k = 0;k<5;k++) {
						//상
						if(k==0) {
							for(int x = 0;x<3;x++) {
								int nr = r + dirU0[x][0];
								int nc = c + dirU0[x][1];
								if(nc>=N || nr>=N || nc<0 || nr<0) continue A;
								if(arr[nr][nc]==1) continue A;
							}
							if(visited1[r-1][c]) continue A;
							visited1[r-1][c] = true;
							que.add(new int[] {r-1,c,0});
							if((r-1)==endR && c == endC && endA==0) {
								System.out.println(count);
								return;
							}
						}
						//하
						if(k==1) {
							for(int x = 0;x<3;x++) {
								int nr = r + dirD0[x][0];
								int nc = c + dirD0[x][1];
								if(nc>=N || nr>=N || nc<0 || nr<0) continue A;
								if(arr[nr][nc]==1) continue A;
							}
							if(visited1[r+1][c]) continue A;
							visited1[r+1][c] = true;
							que.add(new int[] {r+1,c,0});
							if((r+1)==endR && c == endC && endA==0) {
								System.out.println(count);
								return;
							}
						}
						//좌
						if(k==2) {
							
							int nr = r;
							int nc = c -2;
							if(nc>=N || nr>=N || nc<0 || nr<0) continue A;
							if(visited1[r][c-1]) continue A;
							visited1[r][c-1] = true;
							if(arr[nr][nc]==1) continue A;
							que.add(new int[] {r,c-1,0});
							if(r==endR && (c-1) == endC && endA==0) {
								System.out.println(count);
								return;
							}
						}
						//우
						if(k==3) {
							int nr = r;
							int nc = c +2;
//							System.out.println(nr+" "+nc);
//							for(int i = 0;i<N;i++) {
//							System.out.println(Arrays.toString(visited2[i]));
//						}
//						System.out.println();
							if(nc>=N || nr>=N || nc<0 || nr<0) continue A;
							if(visited1[r][c+1]) continue A;
							visited1[r][c+1] = true;
							if(arr[nr][nc]==1) continue A;
							que.add(new int[] {r,c+1,0});
//							System.out.println(r+" "+c+1);
							if(r==endR && (c+1) == endC && endA==0) {
								System.out.println(count);
								return;
							}
						}
						//회전
						if(k==4) {
							if(visited2[r][c]) continue A;
							for(int x = 0;x<8;x++) {
								int nr = r + dirR[x][0];
								int nc = c + dirR[x][1];
								if(nc>=N || nr>=N || nc<0 || nr<0) continue A;
								if(arr[nr][nc]==1) continue A;
							}
							que.add(new int[] {r,c,1});
							if(r==endR && c == endC && endA==1) {
								System.out.println(count);
								return;
							}
						}
					}
				}else
					// l
				{
					A : for(int k = 0;k<5;k++) {
						//좌
						if(k==0) {
							for(int x = 0;x<3;x++) {
								int nr = r + dirL1[x][0];
								int nc = c + dirL1[x][1];
								if(nc>=N || nr>=N || nc<0 || nr<0) continue A;
								if(arr[nr][nc]==1) continue A;
							}
							if(visited2[r][c-1]) continue A;
							visited2[r][c-1] = true;
							que.add(new int[] {r,c-1,1});
							if(r==endR && (c-1) == endC && endA==1) {
								System.out.println(count);
								return;
							}
						}
						//우
						if(k==1) {
							for(int x = 0;x<3;x++) {
								int nr = r + dirR1[x][0];
								int nc = c + dirR1[x][1];
								if(nc>=N || nr>=N || nc<0 || nr<0) continue A;
								if(arr[nr][nc]==1) continue A;
							}
							if(visited2[r][c+1]) continue A;
							visited2[r][c+1] = true;
							que.add(new int[] {r,c+1,1});
							if(r==endR && (c+1) == endC && endA==1) {
								System.out.println(count);
								return;
							}
						}
						//상
						if(k==2) {
							
							int nr = r -2;
							int nc = c;
							if(nc>=N || nr>=N || nc<0 || nr<0) continue A;
							if(visited2[r-1][c]) continue A;
							visited2[r-1][c] = true;
							if(arr[nr][nc]==1) continue A;
							que.add(new int[] {r-1,c,1});
							if((r-1)==endR && c == endC && endA==1) {
								System.out.println(count);
								return;
							}
						}
						//하
						if(k==3) {
							int nr = r+2;
							int nc = c;
							if(nc>=N || nr>=N || nc<0 || nr<0) continue A;
							if(visited2[r+1][c]) continue A;
							visited2[r+1][c] = true;
							if(arr[nr][nc]==1) continue A;
							que.add(new int[] {r+1,c,1});
							if((r+1)==endR && c == endC && endA==1) {
								System.out.println(count);
								return;
							}
						}
						//회전
						if(k==4) {
							if(visited1[r][c]) continue A;
							for(int x = 0;x<8;x++) {
								int nr = r + dirR[x][0];
								int nc = c + dirR[x][1];
								if(nc>=N || nr>=N || nc<0 || nr<0) continue A;
								if(arr[nr][nc]==1) continue A;
							}
							que.add(new int[] {r,c,0});
							if(r==endR && c == endC && endA==0) {
								System.out.println(count);
								return;
							}
						}
					}
				}
			}
		}
		System.out.println(0);
	}
}