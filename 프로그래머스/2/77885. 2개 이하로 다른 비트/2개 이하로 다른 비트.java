/*
문제
1. x 2진수로 변환
2. 비트 중 2개 이하로 변경해서 가장 작은 수

풀이
1. x가 짝수인 경우 +1출력
2. x가 홀수인 경우
    2.1. while문 돌리기 => count=1
        2.1.1. x/2
        2.1.2. 홀수인 경우 => 원래값 + count
        2.1.3. 홀수인 경우 count*2
3. 출력
*/
import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0;i<numbers.length;i++){
            long origin = numbers[i];
            if(origin%2==0){
                answer[i] = origin+1;
                continue;
            }else{
                long temp = origin;
                long count = 1;
                while(true){
                    temp /= 2;
                    if(temp%2==0){
                        answer[i] = origin + count;
                        break;
                    }
                    count *= 2;
                }
                continue;
            }
        }
        return answer;
    }
}