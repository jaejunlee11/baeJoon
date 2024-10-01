import java.util.*;
/*
문제
1. 특정 금액 이상 지불 => 10일간 회원
2. 10일동안 원하는 제품을 다 살 수 있으면 구매
3. 회원가입을 했을 때 할인을 다 받을 수 있는 날의 합

풀이
1. wantCount 배열 생성[want 크기]
2. discount의 문자가 want[i] 와 일치하면 wantCount++ + 뒤에꺼는 --
3. number가 wantCount와 일치하면 count++
4. count 출력
*/
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int size = want.length;
        int[] wantCount = new int[size];
        for(int i = 0;i<10;i++) {
            for(int j = 0;j<size;j++){
                if(want[j].equals(discount[i])) wantCount[j]++;
            }
        }
        boolean flag = true;
        for(int j = 0;j<size;j++){
            if(wantCount[j]!=number[j]){
                flag = false;
                break;   
            }
        }
        if(flag) answer++;
        
        int end = discount.length;
        for(int i = 10;i<end;i++){
            for(int j = 0;j<size;j++){
                if(want[j].equals(discount[i])) wantCount[j]++;
                if(want[j].equals(discount[i-10])) wantCount[j]--;
            }
            flag = true;
        for(int j = 0;j<size;j++){
            if(wantCount[j]!=number[j]){
                flag = false;
                break;   
            }
        }
        if(flag) answer++;
        }
        return answer;
    }
}