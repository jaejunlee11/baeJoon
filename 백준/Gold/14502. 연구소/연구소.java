/*
 * 문제
 * 1. N*M의 연구소 존재
 * 2. 빈칸, 벽, 바이러스 존재
 * 3. 바이러스가 상하좌우 퍼져나감
 * 4. 벽을 3개 세워서 최대한 많은 안전 지역 만들기
 * 
 * 풀이
 * 1. N,M 입력 받기 -> 최대 8*8
 * 2. arr[N][M] 채우기
 * 3. recur돌릭
 * 
 * recur(조합)
 * 1. depth==3이 되면
 * 	1.1. bfs로 바이러스 퍼뜨리기
 * 	1.2. 0의 갯수 확인
 * 2. for(index - N*M)
 * 	2.1. arr[i/M][i%M] == 1,2 continue
 * 	2.2. picked[depth] = i
 * 	2.3. recur(depth+1, i+1)
 * 
 * bfs
 * 1. que에 2 담기
 * 2. 0인 곳으로만 이동 가능
 * 
 * 시간 복잡도 
 * 1. 4만 * 64 *4 -> 널널 
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[] picked;
	static int maxNum = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr= new int[N][M];
		for(int i = 0 ;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		picked = new int[3];
		recur(0,0);
		System.out.println(maxNum);
	}
	public static void recur(int depth,int index) {
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		if(depth == 3) {
			int[][] temp = new int[N][M];
			for(int i = 0 ;i<N;i++) {
				temp[i] = arr[i].clone();
			}
			for(int i = 0 ;i<3;i++) {
				temp[picked[i]/M][picked[i]%M] = 1;
			}
			
			
			Deque<int[]> que = new ArrayDeque<>();
			for(int i = 0 ;i<N;i++) {
				for(int j = 0;j<M;j++) {
					if(temp[i][j]==2) {
						que.add(new int[] {i,j});
					}
				}
			}
			while(!que.isEmpty()) {
				int[] loc = que.poll();
				int r = loc[0];
				int c = loc[1];
				for(int k = 0;k<4;k++) {
					int nr = r + dir[k][0];
					int nc = c + dir[k][1];
					if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
					if(temp[nr][nc]!=0) continue;
					temp[nr][nc] = 2;
					que.add(new int[] {nr,nc});
				}
			}
			int count =0 ;
			for(int i = 0 ;i<N;i++) {
				for(int j = 0;j<M;j++) {
					if(temp[i][j]==0) {
						count++;
					}
				}
			}
			maxNum = Math.max(maxNum, count);
			return;
		}
		for(int i = index;i<N*M;i++) {
			 if(arr[i/M][i%M]==1 || arr[i/M][i%M]==2) continue;
			 picked[depth] = i;
			 recur(depth+1,i+1);
		}
	}
}