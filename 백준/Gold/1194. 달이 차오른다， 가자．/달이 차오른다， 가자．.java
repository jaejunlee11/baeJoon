/*
 * 문제
 * 1. . : 이동 가능
 * 2. # : 이동 불가
 * 3. a,b,c,d,e,f : 열쇠
 * 4. A,B,C,D,E,F : 문
 * 5. 0 : 시작점
 * 6. 1 : 탈출 지점
 * 7. 미로를 탈출하는 최소값
 * 
 * 아이디어
 * 1. 레벨별 bfs (r,c, 0,0,0,0,0,0)
 * 2. 열쇠를 얻으면 새로운 판으로 이동
 * 
 * 풀이
 * 1. N,M입력
 * 2. char arr[N][M] 생성, que생성
 * 3. arr 채우기 => 0인 값 => que.add(r,c,0,0,0,0,0,0)넣기
 * 4. visited[N][M][64]생성
 * 5. 레벨별 bfs돌리기
 * 
 * bfs
 * 1. que가 빌때 까지
 * 2. que에서 꺼내기  =>int[]
 * 3. for문 돌리기 => 4방 탐색
 * 	3.1. 32*temp[2]+16*temp[3]+8*temp[4]+4*temp[5]+2*temp[6]+temp[7] => visiting(열쇠판단)
 * 	3.2. 경계체크
 * 	3.3. visited[nr][nc][visiting] 체크
 * 	3.4. visited체크
 * 	3.5. 벽 체크
 * 	3.6. 문인 경우 문에 맞는 temp값 확인 => 0이면 que에 nr,nc, ... 담기
 * 	3.7. 열쇠인 경우 que에 담기 => nr,nc,... 열쇠에 따라 1처리
 * 	3.8. 1인 경우 종료
 * 	3.9. . 인경우 que에 담기 => nr,nc, ....
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		Deque<int[]> que = new ArrayDeque<>();
		for(int i= 0;i<N;i++) {
			String temp = br.readLine();
			for(int j = 0;j<M;j++) {
				arr[i][j] = temp.charAt(j);
				if(arr[i][j]=='0') {
					que.add(new int[] {i,j,0,0,0,0,0,0});
				}
			}
		}
		boolean visited[][][] = new boolean[N][M][64];
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		int count =0;
		while(!que.isEmpty()) {
			int size = que.size();
			count++;
			while(size-- >0) {
				int[] temp = que.poll();
				int visiting = 32*temp[2]+16*temp[3]+8*temp[4]+4*temp[5]+2*temp[6]+temp[7];
				for(int k = 0;k<4;k++) {
					int nr = temp[0] + dir[k][0];
					int nc = temp[1] + dir[k][1];
					if(nr>=N || nc>=M || nr<0 || nc<0) continue;
					if(visited[nr][nc][visiting]) continue;
					visited[nr][nc][visiting] =true;
					char here = arr[nr][nc];
					if(here=='1') {
						System.out.println(count);
						return;
					}
					if(here=='#')continue;
					if(here=='A' && temp[2]==0)continue;
					if(here=='B' && temp[3]==0)continue;
					if(here=='C' && temp[4]==0)continue;
					if(here=='D' && temp[5]==0)continue;
					if(here=='E' && temp[6]==0)continue;
					if(here=='F' && temp[7]==0)continue;
					if(here == 'a'){
						que.add(new int[] {nr,nc,1,temp[3],temp[4],temp[5],temp[6],temp[7]});
					}else if(here == 'b'){
						que.add(new int[] {nr,nc,temp[2],1,temp[4],temp[5],temp[6],temp[7]});
					}else if(here == 'c'){
						que.add(new int[] {nr,nc,temp[2],temp[3],1,temp[5],temp[6],temp[7]});
					}else if(here == 'd'){
						que.add(new int[] {nr,nc,temp[2],temp[3],temp[4],1,temp[6],temp[7]});
					}else if(here == 'e'){
						que.add(new int[] {nr,nc,temp[2],temp[3],temp[4],temp[5],1,temp[7]});
					}else if(here == 'f'){
						que.add(new int[] {nr,nc,temp[2],temp[3],temp[4],temp[5],temp[6],1});
					}else {
						que.add(new int[] {nr,nc,temp[2],temp[3],temp[4],temp[5],temp[6],temp[7]});
					}
				}
			}
		}
		System.out.println(-1);
	}
}