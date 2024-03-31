/*
 * 문제
 * 1. 특정 벽을 부쉈을 때 몇 칸이 이동 가능한지 구하기
 * 
 * 아이디어
 * 1. 벽을 만나면 해당 좌표에서 bfs탐색 => 시간 초과  
 * 2. 0인 지점을 bfs탐색하여 크기 구하기 => 기록
 * 3. 벽을 만나면 4방을 탐색하여 해당 값들 합 +1
 * 
 * 풀이
 * 1. N,M입력
 * 2. arr[N][M]생성, visited배열 생성 
 * 2. arr채우기, arr 1인 값은 -1로 채우기 
 * 3. for문 돌리기 => arr탐색 
 * 	3.1. visited인 경우 continue
 * 	3.2. 0인 경우 que2개 생성,count 1로 만들기, que에 자기자신 넣기 + visited체크 
 * 	3.3. bfs돌리기
 * 		3.3.1. 4방 탐색
 * 		3.3.2. 경계 체크, visited체크
 * 		3.3.3. 0인 경우 count++, que에 둘 다 넣기,visited처리
 * 	3.4. 2번째 que에 넣었던 좌표들의 값들을 전부 count로 변경, union처리 
 * 4. for문 돌리기 => arr탐색, 새로운 맵 생성(arr크기)
 * 	4.1. -1인 값을 만나면 4방 탐색 => 각 숫자들 합 + 1값으로 채우기, 이때 find를 통해서 중복 확인 
 * 5. 새로운 맵 출력 
 * 
 * 시간 복잡도
 * 1. 100만 * 4(bfs탐색) * 2(탐색 + 채우기) + 100만 * 4(1인지점 찾기 + 4방탐색) => 충 
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[] parents;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i =0 ;i<N;i++) {
			String temp = br.readLine();
			for(int j = 0;j<M;j++) {
				int num = temp.charAt(j)-'0';
				if(num==1) arr[i][j]=-1;
				else arr[i][j]=0;
			}
		}
		init();
		boolean visited[][] = new boolean[N][M];
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(visited[i][j]) continue;
				if(arr[i][j]==0) {
					int count = 1;
					Deque<int[]> que1 = new ArrayDeque<>();
					Deque<int[]> que2 = new ArrayDeque<>();
					visited[i][j]=true;
					que1.add(new int[] {i,j});
					que2.add(new int[] {i,j});
					while(!que1.isEmpty()) {
						int[] loc = que1.poll();
						int r = loc[0];
						int c = loc[1];
						for(int k = 0;k<4;k++) {
							int nr = r + dir[k][0];
							int nc = c + dir[k][1];
							if(nr<0 || nc< 0|| nr>=N || nc>=M) continue;
							if(visited[nr][nc]) continue;
							visited[nr][nc] = true;
							if(arr[nr][nc]==0) {
								que1.add(new int[] {nr,nc});
								que2.add(new int[] {nr,nc});
								count++;
							}
						}
					}
					int start = -1;
					while(!que2.isEmpty()) {
						int[] loc = que2.poll();
						int r = loc[0];
						int c = loc[1];
						arr[r][c] = count;
						if(start==-1) {
							start = r*M + c +1;
						}else {
							union(start,r*M+c+1);
						}
					}
				}
			}
		}
		int[][] map = new int[N][M];
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(arr[i][j]==-1) {
					int temp = 1;
					int k0 = -1;
					int k1 = -1;
					int k2 = -1;
					int k3 = -1;
					for(int k = 0;k<4;k++) {
						int nr = i + dir[k][0];
						int nc = j + dir[k][1];
						if(nr<0 || nc< 0|| nr>=N || nc>=M) continue;
						if(arr[nr][nc]==-1) continue;
						if(k==0) {
							k0 = find(nr*M + nc +1);
							temp += arr[nr][nc];
						}else if(k==1){
							k1 = find(nr*M + nc +1);
							if(k0!=-1) {
								if(k1!=k0) {
									temp += arr[nr][nc];
								}
							}else {
								temp += arr[nr][nc];
							}
						}else if(k==2){
							k2 = find(nr*M + nc +1);
							if(k0!=-1) {
								if(k2==k0) continue;
							}
							if(k1!=-1) {
								if(k2==k1) continue;
							}
							temp += arr[nr][nc];
						}
						else if(k==3){
							k3 = find(nr*M + nc +1);
							if(k0!=-1) {
								if(k3==k0) continue;
							}
							if(k1!=-1) {
								if(k3==k1) continue;
							}
							if(k2!=-1) {
								if(k3==k2) continue;
							}
							temp += arr[nr][nc];
						}
					}
					map[i][j]=temp;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<N;i++) {
			for(int j = 0; j<M;j++) {
				sb.append(map[i][j]%10);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void init() {
		parents = new int[N*M+1];
		for(int i = 1;i<=N*M;i++) {
			parents[i]=i;
		}
	}
	private static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parents[rootA]=rootB;
		return true;
	}
}