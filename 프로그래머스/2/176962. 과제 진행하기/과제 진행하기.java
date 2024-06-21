import java.util.*;
/*
문제
1. 과제는 시간이 되면 시작
2. 새로운 과제가 있으면 하던 것을 멈추고 시작
3. 과제가 끝났는데 멈춘 과제가 있으면 해당 과제 시작

풀이
1. timer[plans크기][2] 배열 만들기
2. timer채우기 => 0 = 앞 숫자 * 60 + 뒷숫자, 1 = 과제 시간, 2 = 숫자
3. timer 정렬하기 => 0 기준
4. stack생성 => 시간, 남은 시간, 번호 
4. for문 돌기 => timer
    4.1. while(stack이 빌때 까지)
        4.2. stack.peek() => 시간 + 남은 시간<= timer시간 인 경우
            4.2.1. stack.pop() => 시간 + 남은 시간 저장 + answer에 plans[2][0] 담기 
            4.2.1. stack이 비어있지 않으면 stack.pop()이후 stack의 시간 업데이트 해서 다시 넣기
    4.2. stack에 넣기
5. stack에 있는 거 pop하면서 answer에 담기
*/
class Solution {
    public String[] solution(String[][] plans) {
        int[][] timer = new int[plans.length][3];
        List<String> answerList = new ArrayList<>();
        for(int i=0;i<plans.length;i++){
            timer[i][0] = ((plans[i][1].charAt(0)-'0')*10 + (plans[i][1].charAt(1)-'0'))*60 + ((plans[i][1].charAt(3)-'0')*10 + (plans[i][1].charAt(4)-'0'));
            timer[i][1] = Integer.parseInt(plans[i][2]);
            timer[i][2] = i;
        }
        Arrays.sort(timer,(o1,o2)->{return o1[0]-o2[0];});
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for(int i=0;i<plans.length;i++){
            while(!(stack.isEmpty())){
                int[] now = stack.peek();
                if(now[0]+now[1]<=timer[i][0]){
                    stack.pop();
                    answerList.add(plans[now[2]][0]);
                    if(!(stack.isEmpty())){
                        int[] before = stack.pop();
                        before[0] = now[0]+now[1];
                        stack.push(before);
                    }
                }else{
                    int[] before = stack.pop();
                    before[1] = now[0]+now[1]-timer[i][0];
                    stack.push(before);
                    break;
                }
            }
            stack.push(timer[i]);
        }
        while(!stack.isEmpty()){
            int[] now = stack.pop();
            answerList.add(plans[now[2]][0]);
        }
        String[] answer = answerList.toArray(new String[answerList.size()]);
        return answer;
    }
}