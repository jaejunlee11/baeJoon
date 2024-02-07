/*
 * 문제
 * 1. n^2의 방 존재 -> n=1000 -> 1000000
 * 2. 각 방에 번호가 존재
 * 3. 다음 방의 번호가 +1일때만 이동 가능
 * 4. 이동이 가능한 최대 값, 시작 방 번호 출력
 * 
 * 풀이
 * 1. 첫번째 방을 +1 방향으로 dfs를 통해서 탐색 => forward dfs
 * 2. 끝에 도달한 경우 -1 방향으로 dfs탐색 back dfs
 * 3. 끝에 도달한 경우 최대값과 방의 번호를 업데이트
 * 4. 마지막 탐색을 종료한 이후 방번호 + 최대값 출력
 * 
 * dfs
 * 1. 
 * 2. 4방향으로 돌림
 * 	2.1. nr = r+dir[k]
 * 	2.2. 경계 체크 및 visited체크 => continue
 * 	2.3. 아래 부분에 flag세우기 
 * 3. flag를 못 받고 온놈이 4방향 다 못 채운 놈
 * 	3.1. max및 최소 값 업데이
 */
import java.io.*;
import java.util.*;


public class Solution {
	static int max = Integer.MIN_VALUE;
	static int tempMax = Integer.MIN_VALUE;
	static int start = 0;
	static int realStart = 0;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int N;
	static int[][] arr;
	static boolean[][] visited;
public static void main(String[] args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	for(int test_case = 1;test_case<=T;test_case++) {
		max = Integer.MIN_VALUE;
		tempMax = Integer.MIN_VALUE;
		start = 0;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i= 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(visited[i][j]) continue;
				tempMax = Integer.MIN_VALUE;
				
				visited[i][j]=true;
				forWarddfs(1,i,j,arr[i][j]);
				backWarddfs(0,i,j,arr[i][j]);
			}
		}
		System.out.println("#"+test_case + " " +start+ " "+ max);
	}
}
public static void forWarddfs(int depth,int r, int c, int num) {
	boolean flag = true;
	for(int k = 0;k<4;k++) {
		int nr = r+dir[k][0];
		int nc= c+dir[k][1];
		if(nr<0 || nc<0 || nr>=N || nc>=N || arr[nr][nc] != (num+1) ) continue;
//		System.out.println("nr " + nr+ " nc "+nc);
		flag=false;
		visited[nr][nc] = true;
		forWarddfs(depth+1,nr,nc,num+1);
	}
	if(flag) {
//		System.out.println("flag" + depth+"for");
		tempMax = depth;
	}
}
public static void backWarddfs(int depth,int r, int c, int num) {
	boolean flag = true;
	for(int k = 0;k<4;k++) {
		int nr = r+dir[k][0];
		int nc= c+dir[k][1];
		if(nr<0 || nc<0 || nr>=N || nc>=N || arr[nr][nc] != (num-1) ) continue;
		flag=false;
		visited[nr][nc] = true;
		backWarddfs(depth+1,nr,nc,num-1);
	}
	if(flag) {
//		System.out.println("flag" + depth + "back");
		tempMax = tempMax + depth;
		if(tempMax>max) {
			max = tempMax;
			start = num;
		}else if(tempMax == max) {
			start = Math.min(start, num);
		}
		
	}
}
}