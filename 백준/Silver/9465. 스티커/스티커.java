import java.io.*;
import java.util.*;
/*
문제
1. 스티커가 존재
2. 스티커를 뜯으면 주변 것들을 못 뜯음
3. 최대 점수 구하기

풀이
1. t입력
2. n입력
3. arr[n][2]생성
4. arr채우기
5. dp[n][3]생성 =>dp[0][0] = arr[0][0], dp[0][1] = arr[0][1], dp[0][2] = 0
6. for문 돌기 n만큼
    6.1. dp[i][0] = Math.max(dp[i-1][1],dp[i-1][2]) + arr[i][0]
    6.2. dp[i][1] = Math.max(dp[i-1][0],dp[i-1][2]) + arr[i][1]
    6.3. dp[i][2] = Math.max(dp[i-2][0],dp[i-2][1],dp[i-2][2]) => i>2일때만
7. dp[n-1]최대값 출력
 */

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t = 0 ;t<T;t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][2];
            int[][] dp = new int[n][3];
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<n;i++){
                arr[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<n;i++){
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            if(n==1){
                System.out.println(Math.max(arr[0][0],arr[0][1]));
            }else{
                dp[0][0] = arr[0][0];
                dp[0][1] = arr[0][1];
                for(int i = 1;i<n;i++){
                    dp[i][0] = Math.max(dp[i-1][1],dp[i-1][2]) + arr[i][0];
                    dp[i][1] = Math.max(dp[i-1][0],dp[i-1][2]) + arr[i][1];
                    dp[i][2] = Math.max(dp[i-1][0],dp[i-1][1]);
                }
                int answer = Math.max(dp[n-1][0],dp[n-1][1]);
                System.out.println(Math.max(answer,dp[n-1][2]));
            }
        }
    }
}