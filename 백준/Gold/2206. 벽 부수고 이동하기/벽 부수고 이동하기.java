/*
 * 문제
 * 1. N*M 맵 존제
 * 2. 1,1에서 N,M으로 이동하는 최단 경로 찾기(시작 끝 포함)
 * 3. 벽 최대 1개 부수는 것 가능
 * 
 * 풀이
 * 1. N, M입력 받기
 * 2. arr[N][M]생성
 * 3. 배열 입력 받기
 * 4. que생성
 * 5. que에 {0,0,벽 박은 횟수, 이동 횟수}담기
 * 6. while(큐빌때까지) -> visited[][] -> 벽 안박은 사람 전용, visited[][] -> 벽 박은 사람 전용
 * 	6.1. 큐에서 꺼내기
 * 	6.2. for(k->4)
 * 		6.2.0 경계 체크
 * 		6.2. 벽 박은 횟수가 1인 경우
 * 			6.2.1. visited 체크
 * 			6.2.2. 1이 아닌 것이면 qeu에 넣기
 * 		6.3. 벽 박은 횟수가 0인 경우
 * 			6.3.1. visited 체크
 * 			6.3.2. 전부 qeu에 넣기
 * 		6.4. 목적지에 도착한 경우
 * 			6.5. 최소값 업데이트
 * 
 * 시간 복잡도
 * 1. 1000 * 1000 * 3^3 => 2700만쯤?
 * 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr= new int[N][M];
		for(int i = 0;i<N;i++) {
			String temp = br.readLine();
			for(int j = 0;j<M;j++) {
				arr[i][j] = temp.charAt(j)-'0';
			}
		}
		if(N==1 && M==1) {
			System.out.println(1);
			return;
		}
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		boolean visited1[][] = new boolean[N][M];
		boolean visited0[][] = new boolean[N][M];
		Deque<int[]> que = new ArrayDeque<>();
		que.add(new int[] {0,0,0,1});
		visited1[0][0] = true;
		visited0[0][0] = true;
		int answer = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			int[] loc = que.poll();
			int r = loc[0];
			int c = loc[1];
			for(int k = 0;k<4;k++) {
				int nr = r+dir[k][0];
				int nc = c + dir[k][1];
				if(nr<0 || nc<0 ||nr>=N||nc>=M) continue;
				if(loc[2]==1) {
					if(visited1[nr][nc]) continue;
					if(arr[nr][nc]==1) continue;
					if((nr==N-1) && (nc ==M-1)) {
						answer = Math.min(answer, loc[3]);
					}else {
						visited1[nr][nc] = true;
						que.add(new int[] {nr,nc,1,loc[3]+1});
					}
				}else {
					if(visited0[nr][nc]) continue;
					if(arr[nr][nc]==1) {
						if((nr==N-1) && (nc ==M-1)) {
						answer = Math.min(answer, loc[3]);
					}else {
						visited0[nr][nc] = true;
						que.add(new int[] {nr,nc,1,loc[3]+1});
					}
					}else {
						if((nr==N-1) && (nc ==M-1)) {
							answer = Math.min(answer, loc[3]);
						}else {
							visited0[nr][nc] = true;
							que.add(new int[] {nr,nc,0,loc[3]+1});
						}
					}
					
				}
			}
		}
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer+1);
	}
}