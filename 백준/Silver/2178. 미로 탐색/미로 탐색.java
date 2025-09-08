/*
문제
1. M*N 미로가 존재
2. 1은 이동 가능, 2는 이동 불가
3. (0,0)에서 시작, (M-1,N-1)까지 이동

풀이
1. M,N 입력
2. 배열 만들기
3. 배열 채우기
4. 0,0 que 에 담기
5. bfs 돌리기 => 도착시 종료
 */
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        int[][] arrow = {{0,1},{0,-1},{1,0},{-1,0}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i <n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        Deque<int[]> que = new ArrayDeque<>();
        int ans = 0;
        que.add(new int[] {0,0});
        visited[0][0] = true;
        while(!que.isEmpty()) {
            ans++;
            int size = que.size();
            while (size-- > 0) {
                int[] now = que.poll();
                if(now[0] == n-1 && now[1] == m-1) {
                    System.out.println(ans);
                    return;
                }
                for(int k = 0;k < 4;k++) {
                    int nx = now[0] + arrow[k][0];
                    int ny = now[1] + arrow[k][1];
                    if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                    if(arr[nx][ny] == 0) continue;
                    if(visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    que.add(new int[] {nx, ny});
                }
            }

        }
    }
}
