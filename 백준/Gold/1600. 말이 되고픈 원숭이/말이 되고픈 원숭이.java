/*
 * 문제
 * 1. 원숭이는 나이트 처럼 이동 가능 K번
 * 2. 나머지는 4방으로 이동 가능
 * 3. 0,0 -> H,W까지 이동 최소 횟수 구하기 
 *
 * 풀이
 * 1. K입력 
 * 2. H, W 입력
 * 3. arr[W][H]생성 ,visited[W][H][K+1]생성
 * 4. arr 채우기
 * 5. dir1 = {{0,1},{0,-1},{1,0},{-1,0}}
 * 6. dir2 = {{-2,-1},{2,-1},{2,1},{-2,1},{-1,-2},{-1,2},{1,2},{1,-2}}
 * 7. 큐 생성 후 0,0,0 넣기
 * 8. bfs돌리기 => depth체크
 * 	8.1. loc[2]가 K보다 작으면 dir2로도 이동 => 이때는 큐에 loc[2]+1넣기 =>visited[loc[2]+1]에 표시 
 * 	8.2. dir1으로 이동 => visited[loc[2]]에 표시 
 * 	8.3. W-1, H-1에 도착 시 depth출력 후 종료 
 * 
 * 시간 복잡도
 * 1. 40000 * 30 * 12 = 14400000
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] arr = new int[W][H];
		boolean[][][] visited = new boolean[W][H][K+1];
		for(int i = 0;i<W;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ;j<H;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(H==1 && W ==1) {
			System.out.println(0);
			return;
		}
		int[][] dir1 = {{0,1},{0,-1},{1,0},{-1,0}};
		int[][] dir2 = {{-2,-1},{2,-1},{2,1},{-2,1},{-1,-2},{-1,2},{1,2},{1,-2}};
		Deque<int[]> que = new ArrayDeque<>();
		que.add(new int[] {0,0,0});
		int depth = 1;
		while(!que.isEmpty()) {
			int queSize = que.size();
			while(queSize-- >0) {
				int[] loc = que.poll();
				int r = loc[0];
				int c = loc[1];
				int jump = loc[2];
//				System.out.println(r + " " + c +" "+ jump);
				for(int k = 0;k<4;k++) {
					int nr = r + dir1[k][0];
					int nc = c + dir1[k][1];
					if(nr<0 || nc<0 || nr>=W || nc>=H) continue;
					if(visited[nr][nc][jump]) continue;
					if(arr[nr][nc]==1) continue;
					if(nr==W-1 && nc == H-1) {
						System.out.println(depth);
						return;
					}
					visited[nr][nc][jump]=true;
					que.add(new int[] {nr,nc,jump});
				}
				if(jump>=K) continue;
				for(int k = 0;k<8;k++) {
					int nr = r + dir2[k][0];
					int nc = c + dir2[k][1];
					if(nr<0 || nc<0 || nr>=W || nc>=H) continue;
					if(visited[nr][nc][jump+1]) continue;
					if(arr[nr][nc]==1) continue;
					if(nr==W-1 && nc == H-1) {
						System.out.println(depth);
						return;
					}
					visited[nr][nc][jump+1]=true;
					que.add(new int[] {nr,nc,jump+1});
				}
			}
			depth++;
		}
		System.out.println(-1);
	}
}