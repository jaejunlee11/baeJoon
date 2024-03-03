/*
 * 문제
 * 1. 구슬이 들어있는 판존재
 * 2. 판을 기울여서 구슬을 이동
 * 3. 파란 구슬이 들어가면 안됨
 * 4. 빨간 구슬을 최소 몇번안에 넣을 수 있는가
 * 
 * 풀이
 * 1. N.M입력
 * 2. arr[N][M]생성
 * 3. # -> -1, . ->0, R ->1, B ->2, o->3으로 arr채우기
 * 4. 중복 순열 만들기
 * 	4.1. 만든 순열에 맞게 판 이동
 * 
 * 중복 순열
 * 1. depth ==10
 * 	1.1. for(10까지)
 * 		1.1.1. 판 이동시키기 -> 1리턴
 * 			1.1.2. answer = 이동 횟수 => break
 * 		1.1.2. 2리턴 -> 즉시 종료
 * 		1.1.3. 3리턴 -> 그대로 진행
 * 2. for(4방향)
 * 	2.0. 이전 이동 방향과 일치시 continue;
 * 	2.1. picked[depth]=i
 * 	2.2. dfs(depth+1,i)
 * 
 * 판이동 시키기
 * 1. 2위치 찾기
 * 2. dir방향으로 이동
 * 	2.1. -1을 만나는 경우 이전 좌표에 2위치
 * 	2.2. 3을 만나는 경우 return 2;
 * 	2.3. 1을 만나는 경우 check 이후 이동 => -1을 만나면 전전 좌표에 두기
 * 3. 1위치 찾기
 * 4.dir방향으로 이동
 * 	4.1. -1을 만나는 경우 이전 좌표에 1위치
 * 	4.2. 3을 만나는 경우 return 1;
 * 	4.3. 2을 만나는 경우 check 이후 이동 => -1을 만나면 전전 좌표에 두기
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[] picked;
	static int answer;
	static int rR = 0;
	static int rC = 0;
	static int bR = 0;
	static int bC = 0;
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0 ;i<N;i++) {
			String temp = br.readLine();
			for(int j = 0 ;j<M;j++) {
				if(temp.charAt(j)=='#') arr[i][j] = -1;
				if(temp.charAt(j)=='.') arr[i][j] = 0;
				if(temp.charAt(j)=='O') arr[i][j] = 3;
				if(temp.charAt(j)=='R') {
					rR = i;
					rC = j;
				}
				if(temp.charAt(j)=='B') {
					bR = i;
					bC = j;
				}
			}
		}
		picked = new int[10];
		answer = Integer.MAX_VALUE;
		recur(0,-1);
		if(answer==Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}
	static void recur(int depth,int dir) {
		if(depth==10) {
			int temprR = rR;
			int temprC = rC;
			int tempbR = bR;
			int tempbC = bC;
			for(int i = 0 ;i<10;i++) {
				if(move(picked[i])==2) {
					break;
				}
				if(move(picked[i])==1) {
					if(i+1<answer) answer = i+1;
					break;
				}
			}
			rR = temprR;
			rC = temprC;
			bR = tempbR;
			bC = tempbC;
			return;
		}
		for(int k=0;k<4;k++) {
			if(dir==k) continue;
			picked[depth] = k;
			recur(depth+1,k);
		}
	}
	static int move(int arrow) {
		//파랑공
		int nr = bR + dir[arrow][0];
		int nc = bC + dir[arrow][1];
		boolean flag = false;
		while(true) {
			if(nr==rR && nc ==rC) {
				flag=true;
			}
			if(arr[nr][nc]==0) {
				nr = nr + dir[arrow][0];
				nc = nc + dir[arrow][1];
				continue;
			}
			if(arr[nr][nc]==3) {
				return 2;
			}
			if(arr[nr][nc]==-1) {
				if(flag) {
					bR = nr - dir[arrow][0]*2;
					bC = nc - dir[arrow][1]*2;
					break;
				}else {
					bR = nr - dir[arrow][0];
					bC = nc - dir[arrow][1];
					break;
				}
			}
		}
		//빨간공
		nr = rR + dir[arrow][0];
		nc = rC + dir[arrow][1];
		while(true) {
			if(nr==bR && nc ==bC) {
				if(flag) {
					rR = nr + dir[arrow][0];
					rC = nc + dir[arrow][1];
				}else {
					rR = nr - dir[arrow][0];
					rC = nc - dir[arrow][1];
				}
				break;

			}
			if(arr[nr][nc]==0) {
				nr = nr + dir[arrow][0];
				nc = nc + dir[arrow][1];
				continue;
			}
			if(arr[nr][nc]==3) {
				return 1;
			}
			if(arr[nr][nc]==-1) {
				rR = nr - dir[arrow][0];
				rC = nc - dir[arrow][1];
				break;
			}
		}
		return 0;
	}
}