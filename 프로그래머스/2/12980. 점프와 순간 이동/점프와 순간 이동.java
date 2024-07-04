import java.util.*;
/*
문제
1. k만큼 이동 가능 -> 건전지 k 사용
2. 지금 위치에서 순간 이동 가능 -> 건전지 사용 X
3. n에 도착하는 최소 건전지 사용

풀이
1. n입력
2. dp[n+1]생성
3. n==1이면 dp[1]출력
4. while(temp<=n)
    4.1. dp[temp] = 1
    4.2. temp *= 2
4. for문 돌기 => 1~n까지
    4.1. dp[i]!=0이면 conitnue
    4.2. temp = dp[i-1] + 1, dp[i]= temp
    4.2. while돌기(temp<=n)
        4.2.1. dp[temp] = dp[i]
        4.2.2. temp *= 2
5. dp[n]출력

1. 
*/
public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n!=0){
            if(n%2==0){
                n/=2;
            }else{
                n--;
                ans++;
            }
        }
        return ans;
    }
}