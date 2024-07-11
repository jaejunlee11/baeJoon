import java.util.*;
/*
문제
1. 가로 W, 세로 H
2. 대각선으로 잘랐을 때 사용할 수 있는 사각형의 갯수 

풀이
1. w,h 입력, answer = w*h, lines = w/h 
2. for문 돌리기 => 0~h, start = 0
    2.1. w*h - (ceil(lines * i) - start)
    2.2 start = floor(lines * i)
3. answer 출력
*/
class Solution {
    public long solution(int w, int h) {
        if(w>h){
            int temp = h;
            h = w;
            w = temp;
        }else if(w==h){
            long answer = (long)w*(long)h;
            return answer - w;
        }
        long answer = (long)w*(long)h;
        double lines = (double)w/(double)h;
        long start = 0;
        for(int i = 1;i<=h;i++){
            answer -= (Math.ceil(lines * i) - start);
            start = (long)Math.floor(lines * i);
        }
        return answer;
    }
}