/*
 * 문제
 * 1. N*N 판이 존재
 * 2. 파이프가 존재
 * 3. 파이프는 3방향으로만 이동 가능 {1,0},{1,1},{0,1}
 * 4. 파이프를 시작점에서 끝점까지 이동시키는 방법의 수 출력
 * 
 * 아이디어
 * 방법1. dfs 냅다 돌리기(0,1)에서 출발 => (N-1,N-1)도착 + 3방 탐색
 * 방법2. dp로 풀기
 * 	0. dp[0][0]=0, dp[0]가[0][1]=1, dp[i][0]은 전부0
 * 	1. dp[i][j] = dp[i][j-1] + dp[i-1][j]+dp[i-1][j-1]
 * 
 * 
 * 풀이1
 * 1. N 입력
 * 2. arr[N][N]생성
 * 3. arr채우기
 * 4. dfs(0,1,0)돌리기
 * 5. answer 출력
 * 
 * dfs(int r, int c ,int state)
 * 0. r==n && c==n이면 answer++
 * 1. 3방 탐색
 * 	1.0. state == 0 이면 1 continue, state==1 이면 0 continue 
 * 	1.1. nr = r + dir[k][0] 
 * 	1.2. 경계 체크
 * 	1.3. dfs(nr,nc,k)
 * 
 * 풀이2
 * 1. N 입력
 * 2. arr[N+1][N+1]생성
 * 3. arr채우기
 * 4. dp[3][N+1][N+1]생성
 * 5. dp[0][1][2]=1
 * 6. for문 돌리기 1~N
 * 	6.1. for문 돌리기 3~N
 * 		6.1.1. dp[0][i][j] = dp[0][i][j-1] + dp[2][i-1][j]
 * 		6.1.2. dp[1][i][j] = dp[1][i][j-1] + dp[2][i-1][j]
 * 		6.1.3. dp[2][i][j] = dp[0][i][j-1] + dp[1][i-1][j]+dp[2][i-1][j-1]
 * 7.dp[N][N] 합 출력
 */
//메모리 : 11680	시간 : 80
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N;
    static int answer;
    static int[][] dir = {{0,1},{1,0},{1,1}};
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][][] dp = new long[3][N+1][N+1];
        dp[0][1][2] =1 ;
        for(int i =1;i<=N;i++) {
        	for(int j = 1 ;j<=N;j++) {
        		if(i==1&&j==2) continue;
        		if(arr[i][j]==1) continue;
        		dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1];
        		dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j];
        		if(arr[i][j-1]==1 || arr[i-1][j]==1) continue;
        		dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1]+dp[2][i-1][j-1];
        	}
        }
        System.out.println(dp[0][N][N]+dp[1][N][N]+dp[2][N][N]);
    }
}