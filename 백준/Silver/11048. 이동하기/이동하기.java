import java.io.*;
import java.util.*;
/*
문제
1. 0,0에서 출발
2. n,m으로 이동할 때 우, 하, 대각으로 이동 가능
3. 사탕 최대 수 구하기

풀이
1. n,m입력
2. arr[n][m]생성
3. arr 채우기
4. dp[n][m] 생성
5. que 생성 => (0,0)넣기
6. while 돌기 => que 빌때까지
    6.1. que에서 꺼내기
        6.1.1. for돌리기 => 3방향
            6.1.1.1. nr ,nc
            6.1.1.2. 경계 체크
            6.1.1.3. dp[n][c] + arr[nr][nc] > dp[nr][nc]이면 갱신 도착이 아니면 que에 담기
7. dp[n-1][m-1]출력
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dir = {{0,1},{1,0},{1,1}};
        ArrayDeque<int[]> que =new ArrayDeque<>();
        que.add(new int[] {0,0});
        dp[0][0] = arr[0][0];
        boolean[][] checked = new boolean[n][m];
        while(!que.isEmpty()){
            int[] loc = que.poll();
            for(int k = 0;k<3;k++){
                int nr = loc[0] + dir[k][0];
                int nc = loc[1] + dir[k][1];
                if(nr>=n || nr<0 || nc>=m || nc<0) continue;
                if(dp[loc[0]][loc[1]] + arr[nr][nc] > dp[nr][nc]){
                    dp[nr][nc] = dp[loc[0]][loc[1]] + arr[nr][nc];
                    if(nr == n-1 && nc ==m-1) continue;
                    que.add(new int[] {nr,nc});
                }else if(dp[loc[0]][loc[1]] + arr[nr][nc] == dp[nr][nc] && !checked[nr][nc]){
                    checked[nr][nc] = true;
                    dp[nr][nc] = dp[loc[0]][loc[1]] + arr[nr][nc];
                    if(nr == n-1 && nc ==m-1) continue;
                    que.add(new int[] {nr,nc});
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}