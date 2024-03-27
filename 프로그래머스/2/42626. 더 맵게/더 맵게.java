/*
문제
1. 두개의 음식을 섞어서 새로운 음식 생성 => 가장 안매운 2개
2. 결과 = 덜매움 + 더매움 *2
3. K 이상의 음식을 만들 때까지 반복
4. 최소 횟수 출력

풀이
1. priority que 생성
2. priority que에 다 담기
3. while(que.peek()<K) => count = 0 
    3.1. poll 2개
    3.2. 작은값 + 큰값*2 
    3.3. count++
4. count출력
*/
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i : scoville){
            que.add(i);
        }
        
        while(!que.isEmpty() &&que.peek()<K){
            int a = que.poll();
            if(!que.isEmpty()){
                int b = que.poll();
            int c = a + b*2;
            que.add(c);
            answer++;
            }else{
                return -1;
            }
            
            
        }
        return answer;
    }
}