/*
문제
1. numbers라는 배열이 존재
2. 자신 보다 크면서 가장 가까이 있는 수를 결과로 출력

풀이
1. stack생성 => 0,첫 숫자 담기
2. for문 돌리기 1~numbers.length
    2.1. while => stack이 비어있지 않으면
        2.1.1. stack.peek()[1] < numbers[i] => answer[stack.pop()[0]] = numbers[i]
        2.1.2. 아닌 경우 break
    2.2. stack.push(i,numbers[i])
3. 남은 stack에 있는 것 -1넣기
*/
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int numbersSize = numbers.length;
        int[] answer = new int[numbersSize];
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0,numbers[0]});
        for(int i = 1;i<numbersSize;i++) {
            while(!stack.isEmpty()){
                if(stack.peek()[1] < numbers[i]) {
                    answer[stack.pop()[0]] = numbers[i];
                } else {
                    break;
                }
            }
            stack.push(new int[]{i,numbers[i]});
        }
        while(!stack.isEmpty()){
            answer[stack.pop()[0]] = -1;
        }
        return answer;
    }
}