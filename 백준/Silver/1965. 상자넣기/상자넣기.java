import java.util.*;
import java.io.*;;
/*
문제
1. 상자가 존재
2. 상자 안에 상자 넣기 가능
3. 최대한 많이 넣은 것

풀이
1. n입력
2. arr[n]생성
3. arr 채우기
4. dp[n]생성, dp[0] = 1
5. for문 돌리기 => 1~n
    5.1. for문 돌리기 0~i
        5.1.1. arr[i]>arr[j] 일때 dp[i] = dp[j]+1로 갱신
6. dp[n-1] 출력
 */
public class Main {
    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         int n = Integer.parseInt(st.nextToken());
         int[] arr = new int[n];
         int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
         for (int i = 0; i < n; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
         }
         for(int i = 0; i < n; i++){
             dp[i] = 1;
         }
         int ans = 1;
         for(int i = 1; i < n; i++){
             for(int j = 0; j < i; j++){
                 if(arr[i] > arr[j]){
                     dp[i] = Math.max(dp[i], dp[j] + 1);
                     ans = Math.max(ans, dp[i]);
                 }
             }
         }
         System.out.println(ans);
    }
}