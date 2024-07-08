import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
/*
문제
1. 수열 존재
2. 연속된 수열의 합중 최대 값 구하기
3. 이때 1개 뺄 수 있음

8
1 -3 4 8 -4 -3 9 2


생각
1. 1개 버리기(이때 버리는 것이 갱신 될때 그 앞에껄 짜를지 가져 갈지 판단 필요)
2. dp에 지금까지 합, 버릴 것 인덱스, 버릴 값을 저장


풀이(실패)
1. n입력
2. arr[n]생성
3. dp[n][3]생성 => [0] = 지금까지 합, [2] = 버릴 것 인덱스, [1] = 버릴 값
4. arr[0] > 0 인 경우 : dp[0][0] = arr[0], dp[0][1] = 0, dp[0][2] =  -1 저장
5. arr[0] < 0 인 경우 : dp[0][0] = 0
6. answer = arr[0]
5. for문 돌리기 => 1 ~ n
    5.1. dp[1]이 갱신되는 경우 dp[i-1][1] < -arr[i]
        5.1.1. index = dp[i-1][2]
        5.1.2. index == -1일때 => dp[i][1] = -arr[i], dp[i][2] = i, dp[i][0] = dp[i-1][0] + arr[i] => answer 갱신
        5.1.3. index != -1일때 => dp[index][0] < 0 => dp[i][0] = dp[i-1][0] - dp[index][0] + arr[i], dp[i][1] = -arr[i], dp[i][2] = i => answer 갱신
        5.1.4. 아닐때 => dp[i][0] = dp[i-1][0] + arr[i], dp[i][1] = -arr[i], dp[i][2] = i => answer 갱신
    5.2. dp[1]이 갱신이 안되는 경우
        5.2.1. dp[i-1][0] + dp[i-1][1] + arr[i] < 0
            5.2.1.1. arr[i] <0 => dp[i][0] = 0, dp[i][1] = 0, dp[i][2] = -1, answer 갱신(arr[i])값으로
            5.2.1.2. dp[i][0] = arr[i], dp[i][1] = 0, dp[i][2] = -1, answer 갱신 dp[i][0]값으로
        5.2.2. 아닌 경우 => dp[i][0] = dp[i-1][0] + arr[i], dp[i][1] = dp[i-1][1], dp[i][2] = dp[i-1][2], answer 갱신
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[][] dp = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for(int i =0 ;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = arr[0];
        dp[0][1] = 0;
        int answer = dp[0][0];
        for(int i = 1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0]+arr[i],arr[i]);
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]+arr[i]);
            answer = Math.max(dp[i][0],answer);
            answer = Math.max(dp[i][1],answer);
        }
        System.out.println(answer);
    }
}
/*
5
-5 -4 3 5 6
 */