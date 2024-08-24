import java.io.*;
import java.util.*;
/*
문제
1. 지도가 있음 (50 *50)
2. 육지에 보물이 있음
3. 최단 거리가 가장 긴 곳에 거리 구하기

풀이
1. m,n 입력
2. arr 생성 => 채우기 true, false
3. 조합 돌리기

조합
1. depth == 2 이면
    1.1. arr[picked[0][0]][picked[0][1]] == 1 || arr[picked[1][0]][picked[1][1]] == 1 이면 return
    1.2. 레벨별 bfs돌리기 거리 갱신 최대로
2. for문 돌리기 m, n
    2.1. picked[depth][0] = m, picked[dpeht][1] = n
    2.2. recur(depth+1)
 */
public class Main {
    static int[][] arr;
    static int N;
    static int M;
    static int[][] picked = new int[2][2];
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static int answer = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0;i<N;i++) {
            String temp = br.readLine();
            for(int j = 0;j<M;j++){
                if(temp.charAt(j)=='L'){
                    arr[i][j]= 0;
                } else {
                    arr[i][j]= 1;
                }
            }
        }
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                recur(i,j);
            }
        }
        System.out.println(answer);
    }

    private static void recur(int i,int j) {
        if(arr[i][j] == 1) return;
        boolean[][] visited = new boolean[N][M];
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{i,j});
        visited[i][j] = true;
        int count = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            count++;
            while(size-- >0){
                int[] loc = que.poll();
                int r = loc[0];
                int c = loc[1];
                for(int k =  0;k<4;k++){
                    int nr = r + dir[k][0];
                    int nc = c + dir[k][1];
                    if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
                    if(visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    if(arr[nr][nc]==1) continue;
                    que.add(new int[] {nr,nc});
                    answer = Math.max(count,answer);
                }
            }
        }
    }
}