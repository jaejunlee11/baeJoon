/*
 * 문제
 * 1. 토마토들이 들어있음
 * 2. 잘익은 토마토들은 근처 토마토를 잠식 시킴
 * 3. 몇일 안에 전부 익는가
 * 
 * 풀이
 * 1. 박스 크기 입력M N
 * 2. 토마토들 입력 받기
 * 3. 탐색을 하면서 1인 토마토들 좌표 받아와서 que에 넣기
 *     3.1. 큐 사이즈를 체크 => check, depth =0
 * 4. bfs를 돌면서 토마토
 *     4.0. depth++
 *     4.1. for문으로 check만큼 돌리기;
 *         4.1.1 for문으로 4방 탐색 -> 경계 체크하기
 *             4.1.1.2 근처에 0인 친구가 있으면 que에 담기 + 익히기
 * `4.2. check 큐 사이즈로 업데이트
 * 5. 토마토가 전부 익지 않았으면 -1
 * 6. 토마토가 전부 익었으면 depth-1 출력
 * 
 * 시간 복잡도
 * 1. 1000 * 1000 * 4 => 400만
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][N];
        Deque <int[]> que = new ArrayDeque<>();
        for(int i = 0 ;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<M;j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
                if(arr[j][i]==1) que.add(new int[] {j,i});
            }
        }
        int depth = 0;
        int check = que.size();
//        System.out.println(que);
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
        while(!que.isEmpty()) {
        	depth++;
        	for(int i = 0; i<check;i++) {
//        		System.out.println(que);
        		int[] loc = que.poll();
        		int r = loc[0];
        		int c = loc[1];
        		for(int k=0;k<4;k++) {
        			int nr = r+dir[k][0];
        			int nc = c+dir[k][1];
        			if(nr>=0 && nc>=0 && nr<M && nc<N && arr[nr][nc]==0) {
        				arr[nr][nc] =1;
        				que.add(new int[] {nr,nc});
        			}
        		}
        	}
        	check = que.size();
        }
        boolean flag = false;
        for(int i =0;i<M;i++) {
        	for(int j = 0;j<N;j++) {
        		if(arr[i][j]== 0) {
        			System.out.println(-1); 
        			return;
        		}
        	}
        }
        System.out.println(depth-1);
    }
}