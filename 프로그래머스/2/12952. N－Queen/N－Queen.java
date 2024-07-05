import java.util.*;
/*
문제
1. 서로 공격 못하도록 배치

풀이
1. n 입력
2. queen[n]생성
3. B : for문 돌리기 => n
    3.1. A : for문 돌리기 => n
        3.1.1. for문 돌리기 => 0 ~ i까지
            3.1.1. queen[k] == j continue A
            3.1.2. abs((queen[k] - j)/k-i)==1 continue A
        3.1.2. i==n-1 이면 answer ++ , queen[i] = j, continue B
4. answer 출력
*/
class Solution {
    private int answer = 0;
    private int[] queen;
    private int size;
    public int solution(int n) {
        queen = new int[n];
        size = n;
        dfs(0);
        return answer;
    }
    private void dfs(int i){
        
        if(i==size){
            answer++;
            return;
        }
        A : for(int j = 0;j<size;j++){
                for(int k = 0;k<i;k++){
                    if(queen[k]==j) continue A;
                    if(Math.abs(queen[k] - j) == Math.abs(k - i)) continue A;
                }
            queen[i] = j;
            dfs(i+1);
        }
    }
}