import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
/*
문제
1. 사람들 끼리 이어지는데 최소로 모든 사람과 이어지는 사람 구하기
2. 최소값이 동일하면 최소 숫자로 결정

풀이
1. n, m 입려
2. arr[n][n] 생성
3. dp[n][n]생성 => n+1로 채우기
4. arr 채우기 => dp도 1로 세팅
5.for문 돌기 n
    5.1. for문 돌기 n
        5.1.1. for믄 돌기 n
            5.1.1.1. arr[i][j], arr[j][k]가 true인 경우 => dp[i][k]를 dp[i][j]+dp[j][k]와 비교해서 갱신
6. for문 돌면서 dp 최소값 구하기
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        for(int i =  1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                if(i==j) continue;
                dp[i][j] = n+1;
            }
        }
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            dp[a][b] = 1;
            arr[b][a] = true;
            dp[b][a] = 1;
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                for(int k = 1;k<=n;k++){
                    if(arr[i][j] && arr[j][k]){
                        dp[i][k] = Math.min(dp[i][k],(dp[i][j]+dp[j][k]));
                        arr[i][k] = true;
                        arr[k][i] = true;
                        dp[k][i] = dp[i][k];
                    }
                }
            }
        }
        int answer = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<=n;i++){
            int temp = 0;
            for(int j = 1;j<=n;j++){
                temp += dp[i][j];
            }
            if(temp<min){
                min = temp;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}