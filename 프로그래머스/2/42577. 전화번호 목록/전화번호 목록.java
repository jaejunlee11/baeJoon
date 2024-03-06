/*
문제
1. 전화번호 존재
2. 특정 전화번호가 다른 전화번호 앞에 사용된 경우 false
3. 아닌 경우 true출력

풀이
1. hashmap을 20개 생성
2. if(dfs(자리수,map)) return false;
3. return true;

dfs(자리수,set)
0. set크기가 1이하면 return false;
1. for문 0~9돌기
    1.1. 자리수를 확인하여 해당 자리숫자를 이미 넘었으면 return true
    1.2. 해당 자리 숫자가 i인 것들 set에 넣기
    1.3. if(dfs(자리수+1,set))return ture
2. return false;
*/
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 1;i<phone_book.length;i++){
            int sizeA = phone_book[i].length();
            int sizeB = phone_book[i-1].length();
            if(sizeA<sizeB){
                if(phone_book[i].equals(phone_book[i-1].substring(0,sizeA))) return false;   
            }else{
                if(phone_book[i-1].equals(phone_book[i].substring(0,sizeB))) return false; 
            }
        }
        return true;
    }
}