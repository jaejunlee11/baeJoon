import java.util.*;
/*
문제
1. 숫자가 담긴 배열이 존재
2. 해당 숫자를 활용하여 타겟 넘버 만들기
3. -,+만을 선택 가능

풀이
1. dfs돌리기
2.answer 출력 
dfs(depth,num)
1. depth==number.length
    1.1. target = num이면 answer++
    1.2. return
2. dfs(depth+1, num+numbers[depth])
3. dfs(depth+1, num-numbers[depth])
*/

class Solution {
    int answer = 0;
    int[] numbers1;
    int target1;
    int size;
    public int solution(int[] numbers, int target) {
        answer = 0;
        numbers1 = numbers;
        target1 = target;
        size = numbers.length;
        dfs(0,0);
        return answer;
        
    }
    private void dfs(int depth, int num){
        if(depth==size){
            if(num==target1) answer++;
            return;
        }
        dfs(depth+1,num+numbers1[depth]);
        dfs(depth+1,num-numbers1[depth]);
    }
}