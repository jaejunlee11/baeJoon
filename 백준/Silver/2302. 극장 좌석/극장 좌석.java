import java.util.*;
import java.io.*;
/*
문제
1. 1~N까지의 좌석 존재
2. vip는 고정
3. vip가 아닌 사람은 자신 옆자리도 가능
4. 모든 가능한 앉는 경우의 수 구하기


풀이
1. N입력
2. M 입력
3. arr[N+1]생성
4. arr 채우기
5. dp[N+1][3]생성, dp[1][0] = 0(왼쪽), dp[1][1] = 1(중간), dp[1][2] => arr[1], arr[2]가 둘 다 false일때 1(오른쪽)
6. for문 돌리기
    6.1. dp[i][0] = dp[i-1][2] => arr[i]이 false
    6.2. dp[i][1] = dp[i-1][1] + dp[i-1][0]
    6.3. dp[i][2] = dp[i-1][2] + dp[i-1][1] => arr[i], arr[i+1]가 false
7.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==1){
            System.out.println("1");
            return;
        }
        int M = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[N+1];
        int[][] dp = new int[N+1][3];
        for(int i = 1;i<=M;i++){
            arr[Integer.parseInt(br.readLine())] = true;
        }
        dp[1][0] = 0;
        dp[1][1] = 1;
        if(!arr[1] && !arr[2]){
            dp[1][2] = 1;
        }
        for(int i = 2;i<N;i++) {
            if(!arr[i] && !arr[i-1]){
                dp[i][0] = dp[i-1][2];
            }
            dp[i][1] = dp[i-1][1] + dp[i-1][0];

            if(!arr[i] && !arr[i+1]){
                dp[i][2] = dp[i-1][0] + dp[i-1][1];
            }
        }
        if(!arr[N] && !arr[N-1]){
            dp[N][0] = dp[N-1][2];
        }
        dp[N][1] = dp[N-1][1] + dp[N-1][0];
        System.out.println(dp[N][0] + dp[N][1]);
    }
}