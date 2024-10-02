/*
문제
1. x를 y로 변환
2. x+n, x*2, x*3 존재
3. 최소 변환 횟수
4. 못하면 -1 출력

풀이
1. dp[y+1] 생성
2. dp[x] = 1
3. for문 돌리기
    3.1. dp[i] = Math.min(dp[i-5],dp[i/2],dp[i/3]) => 단 dp값들이 0이 아니고 나눠 떨어질때
4. dp[y] 출력 => 0이면 -1
*/
class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        int[] dp = new int[y+1];
        dp[x] = 1;
        for(int i = x+1 ;i<=y;i++){
            int temp = Integer.MAX_VALUE;
            if(i%2==0) {
                if(dp[i/2]!=0) {
                    temp = Math.min(dp[i/2],temp);
                }
            }
            if(i%3==0) {
                if(dp[i/3]!=0) {
                    temp = Math.min(dp[i/3],temp);
                }
            }
            if(i-n>=0) {
                if(dp[i-n]!=0) {
                    temp = Math.min(dp[i-n],temp);
                }
            }
            if(temp!=Integer.MAX_VALUE){
                dp[i] = temp+1;
            }
        }
        if(dp[y]!=0) return dp[y]-1;
        return answer;
    }
}