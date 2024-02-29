/*
 * 문제
 * 1. 물이 차오름
 * 2. 고슴도치는 도망 -> 굴
 * 3. 최대한 빨리 도망
 * 4. 못 도망 치면 KAKTUS
 * 
 * 풀이
 * 1. R C입력
 * 2. map[R][C]생성, cosQue에 고슴도치 위치, waterQue에 물위치 담기
 * 3. map 채우기 
 * 4. while문 돌리기 -> 고슴도치 큐가 빌때까지, depth생성
 * 	4.1. water큐 사이즈만큼 돌기 -> depth++
 * 	4.2. 4방 탐색
 * 		4.2.1. 범위 밖이면 continue;
 * 		4.2.2. x,S면 continue
 * 		4.2.3. visited1면 continue
 * 		4.2.4. water넣고 visted처리
 * 	4.3.고슴도치que 사이즈체크
 * 	4.4 4방 탐색
 * 		4.4.1. 범위밖
 * 		4.4.2. X,*
 * 		4.4.3. vistied2
 * 		4.4.4. S면 depth출력 후 종료
 * 		4.4.5. 고슴도치 넣고 visited처리
 * 5. 실패시 KAKTUS
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		Deque<int[]> coque = new ArrayDeque<>();
		Deque<int[]> waterque = new ArrayDeque<>();
		boolean[][] visitedc = new boolean[R][C];
		boolean[][] visitedw = new boolean[R][C];
		for(int i = 0 ;i<R;i++) {
			String lines = br.readLine();
			for(int j = 0;j<C;j++) {
				String temp = ""+lines.charAt(j);
				if(temp.equals(".")) map[i][j] = 0; // 무
				if(temp.equals("S")) {
//					map[i][j] = 1; //고슴도치
					visitedc[i][j] = true;
					coque.add(new int[] {i,j});
				}
				if(temp.equals("*")) {
					map[i][j] = 2; //물
					visitedw[i][j] =true;
					waterque.add(new int[] {i,j});
				}
				if(temp.equals("D")) map[i][j] = 3; //굴
				if(temp.equals("X")) map[i][j] = 4; //돌
			}
		}
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		int depth = 0;
		while(!coque.isEmpty()) {
			depth++;
			int waterQuesize = waterque.size();
			while(waterQuesize-- >0) {
				int loc[] = waterque.poll();
				for(int k = 0 ;k<4;k++) {
					int nr = loc[0] + dir[k][0];
					int nc = loc[1] + dir[k][1];
					if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
					if(visitedw[nr][nc]) continue;
					if(map[nr][nc]==3 || map[nr][nc]==4) continue;
					visitedw[nr][nc] = true;
					map[nr][nc] = 2;
					waterque.add(new int[] {nr,nc});
				}
			}
			
			int coQuesize = coque.size();
			while(coQuesize-- >0) {
				int loc[] = coque.poll();
//				if(map[loc[0]][loc[1]]==2)continue;
				for(int k = 0 ;k<4;k++) {
					int nr = loc[0] + dir[k][0];
					int nc = loc[1] + dir[k][1];
					if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
					if(visitedc[nr][nc]) continue;
					if(map[nr][nc]==2 || map[nr][nc]==4) continue;
					visitedc[nr][nc] = true;
					if(map[nr][nc]==3) {
						System.out.println(depth);
						return;
					}
					coque.add(new int[] {nr,nc});
				}
			}

		}
		System.out.println("KAKTUS");
	}
}