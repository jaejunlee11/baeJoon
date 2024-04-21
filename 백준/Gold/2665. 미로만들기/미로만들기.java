/*
 * 문제
 * 1. 칸이 존재
 * 2. 막힌 곳도 존재
 * 3. 최대한 막힌 곳을 덜 뚫고 이동
 * 4. 몇번 뚫었는지 출력
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N][N]생성
 * 3. arr 채우기
 * 4. que1생성 
 * 5. que2생성
 * 6. que1에 0,0담기
 * 7. while돌기 + count=1에서 시작 
 * 	7.1. while돌기 =>que1이 빌때 까지
 * 		7.1.0. que에서 poll
 * 		7.1.1. for 사방 탐색
 * 			7.1.1.1. 경계 체크
 * 			7.1.1.2. visited체크 
 * 			7.1.1.2. arr이 1이면 que1에 담기, 아니면 que2에 담기
 * 			7.1.1.3. r,c 가 N-1,N-1이면 1이면 count 출력 후 종료, 아니면 count+1출력 후 종료
 * 	7.2. count++, que1=que2, que2초기화 
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for(int i = 0;i<N;i++) {
			String temp = br.readLine();
			for(int j = 0;j<N;j++) {
				arr[i][j] = (temp.charAt(j)-'0');
			}
		}
		Deque<int[]>que1 = new ArrayDeque();
		Deque<int[]>que2 = new ArrayDeque();
		que1.add(new int[] {0,0});
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		boolean[][] visited = new boolean[N][N];
		int count = 0;
		while(true) {
			while(!que1.isEmpty()) {
				int[] loc = que1.poll();
				int r = loc[0];
				int c = loc[1];
				for(int k = 0;k<4;k++) {
					int nr = r + dir[k][0];
					int nc = c +dir[k][1];
					if(nr>=N || nc>=N || nr<0 || nc<0) continue;
					if(visited[nr][nc]) continue;
					visited[nr][nc] = true;
					if(arr[nr][nc]==1) {
						que1.add(new int[] {nr,nc});
						if(nr==N-1&&nc==N-1) {
							System.out.println(count);
							return;
						}
					}else {
						que2.add(new int[] {nr,nc});
						if(nr==N-1&&nc==N-1) {
							System.out.println(count+1);
							return;
						}
					}
				}
			}
			count++;
			que1 = que2;
			que2 = new ArrayDeque();
		}
	}
}