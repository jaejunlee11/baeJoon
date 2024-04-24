/*
문제
1. 문자열로 튜플들을 입력 받음
2. 문자열을 해석하여 튜플을 출력

풀이
0. set생성
1. for문을 돌면서 튜플을 해석: 1~length-1까지 
    1.1. '{'를 만나면 list생성 + int temp = 0, flag= true
    1.2.  숫자를 만나면 *10 + 해당 숫자
    1.3. flag가 true일 때 ,를 만나면 list에 tmep 넣기 + int tmep = 0
    1.4. '}'를 만나면 set에 list넣기 flag= flase
2. set을 순회해서 배열에 담기
*/
import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> listList = new ArrayList();
        int temp = 0;
        boolean flag = false;
        for(int i = 1;i<s.length()-1;i++){
            if(s.charAt(i)=='{'){
                list = new ArrayList<>();
                temp = 0;
                flag = true;
            }else if(s.charAt(i)=='}'){
                list.add(temp);
                listList.add(list);
                flag = false;
            }else if(s.charAt(i)==','){
                if(flag){
                    // System.out.println(temp);
                  list.add(temp);
                    temp = 0;  
                }
            }else{
                temp *= 10;
                temp += (int)(s.charAt(i)-'0');
            }
        }
        Collections.sort(listList,(o1,o2)->o1.size()-o2.size());
        // System.out.println(listList);
        int size = listList.size();
        int[] answer = new int[size];
        int count = 0;
        for(int i = 0;i<size;i++){
            for(int j  : listList.get(i)){
                if(set.add(j)){
                    answer[count++] = j;
                }
            }
        }
        return answer;
    }
}