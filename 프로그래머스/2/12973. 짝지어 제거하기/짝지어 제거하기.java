import java.util.*;
/*
문제
1. 같은 문자를 만나면 제거
2. 모두 제거되면 1리턴
3. 아니면 0리턴

풀이
1. while문 돌리기
    1.1. "aa", "bb", ... 전부 ""로 replace
    1.2. length가 이전과 동일하면 return 0
    1.3. length가 0 이면 return 1
    
풀이2
1. stack 생성
2. stack.push(s.charAt(0))
3. for문 돌리기 1~s.length()
    3.1. s.peek() == s.charAt(i) s.pop
    3.2. 아닌 경우 s.push(s.charAt(i))
4. stack.size() == 0 이면 return 1
5. return 0
*/
class Solution
{
    public int solution(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();
        int size = s.length();
        for(int i = 0;i<size;i++){
            if(stack.size()==0){
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.peek() == s.charAt(i)){
              stack.pop();  
            } else {
              stack.push(s.charAt(i));  
            } 
        }
        if(stack.size()==0) return 1;
        return 0;
    }
}