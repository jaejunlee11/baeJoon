/*
 * 문제
 * 1. 섬과 바다가 주어짐
 * 2. 팔방으로 이동 가능
 * 3. 인접한 것 끼리 섬
 * 4. 섬의 갯수 구하기
 * 
 * 풀이
 * 1. while문 돌기
 * 2. w, h 입력 받기 -> 둘 다 0이면 break
 * 3. 배열 만들기 -> arr[h][w]
 * 4. 배열 입력 받기
 * 5. 배열의 모든 요소들을 체크 이중 for문 -> count = 0 으로 시작
 * 	5.1. 1을 만나는 경우 -> count++후  dfs 돌리기
 * 6. count 출력
 * 
 * dfs(r,c)
 * 1. 들어왔을 때 해당 arr[r][c]를 0으로 변경
 * 2. for문 돌리기 8방향
 * 	2.1. arr[r+dir[k]][c+dir[k]]가 0인지 확인 continue
 * 	2.2. dfs(r+dir[k],c+dir[k])
 * 
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int w;
	static int h;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h ==0) {
				System.out.println(sb);
				return;
			}
			arr = new int[h][w];
			for(int i = 0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ;j<w;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			for(int i = 0;i<h;i++) {
				for(int j = 0;j<w;j++) {
					if(arr[i][j]==0) continue;
					count++;
					dfs(i,j);
				}
			}
			sb.append(count+"\n");
		}
	}
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
	static void dfs(int r,int c) {
		arr[r][c] = 0;
		for(int k = 0;k<8;k++) {
			int nr = r + dir[k][0];
			int nc = c + dir[k][1];
			if(nr<0 || nr>=h || nc<0 ||nc>=w || arr[nr][nc]==0) continue;
			dfs(nr,nc);
		}
	}
}