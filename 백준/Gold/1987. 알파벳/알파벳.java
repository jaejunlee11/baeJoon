/*
 * 문제
 * 1. 세로 R, 가로 C 표 존재
 * 2. 각 칸에 알파벳 존재
 * 3. 말이 좌측 상단에 존재
 * 4. 상하좌우로 말이 이동 가능 -> 이미 밟은 알파벳으로는 이동 불가
 * 
 * 풀이
 * 1. R,C 입력 받기
 * 2. 배열 arr[R][C]만들기
 * 3. 배열 입력 받기 -> 문자
 * 4. checked배열 만들기 -> checked[R][C] -> 첫번째 밟고 있는 것은 미리 check
 * 5. dfs 돌리기
 * 
 * dfs(depth, r,c)
 * 1. for(사방으로 돌리기)
 * 	1.0. 이미 체크 된 것은 pass
 * 	1.1. temp배열에 내가 다음 밟을 문자의 위치들을 기록 + checked 채우기
 * 	1.2. return dfs(depth+1,r,c)
 * 	1.3. temp를 보고 복구
 * 2. flag로 4방이 막혔을 경우 depth를 return
 * 
 * 시간 복잡도
 * 1. 4^26(이동 가능 최대) * 400(맵 초기화)
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int R;
	static int C;
	static int[][] arr;
	static Set<Integer> alpabet;
	static int maxDepth = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		for(int i = 0;i<R;i++) {
			String temp = br.readLine();
			for(int j = 0;j<C;j++) {
				arr[i][j] = temp.charAt(j)-'A';
			}
		}
		alpabet = new HashSet<Integer>();
		alpabet.add(arr[0][0]);
		dfs(1,0,0);
		System.out.println(maxDepth);
	}
	private static void dfs(int depth , int r, int c) {
		maxDepth = Math.max(maxDepth, depth);
		for(int k= 0;k<4;k++) {
			int nr = r+dir[k][0];
			int nc = c + dir[k][1];
			if(nr<0 || nc<0|| nr>=R ||nc>=C) continue;
			if(!alpabet.add(arr[nr][nc])) continue;
			dfs(depth+1,nr,nc);
			alpabet.remove(arr[nr][nc]);
		}
	}
}