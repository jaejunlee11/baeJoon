import java.util.*;
import java.io.*;
/*
문제
1. 포도주를 최대한 많이 마시기
2. 포도주를 3개 연속은 안됨

생각
1. 0 => 전꺼 마신거
2. 1 => 전꺼 안마시고 방금 마신거
3. 2 => 이번꺼 안마신거
풀이
1. N입력
2. arr[N+1] 생성 및 채우기, dp[N+1] 생성
3. dp[1][0] = arr[1], dp[1][1] = arr[1], dp[1][2] = 0
4. for문 돌리기 2~N
    4.1. dp[i][0] = dp[i-1][1] + arr[i]
    4.2. dp[i][1] = dp[i-1][2] + arr[i]
    4.3. dp[i][2] = max(dp[i-1])
5. max값 출력
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n+1][3];
        dp[1][0] = arr[1];
        dp[1][1] = arr[1];
        for(int i = 2; i <= n; i++) {
            dp[i][0] = arr[i] + dp[i-1][1];
            dp[i][1] = arr[i] + dp[i-1][2];
            int temp = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][2] = Math.max(temp, dp[i-1][2]);
        }
        int answer = Math.max(dp[n][0], dp[n][1]);
        System.out.println(Math.max(answer, dp[n][2]));
    }
}