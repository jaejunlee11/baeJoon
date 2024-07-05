import java.util.*;
/*
문제
1. 곡갱이 존재
2. 돌 존재
3. 특정 곡갱이로 돌 캐면 피로도 쌓임
4. 최소 피로도로 채굴 완료하기

풀이 (시간초과 => 미네랄 50개)
1. picks 곡갱이 입력, mineerlas 돌 입력
2. 중복 순열 돌리기 => 최소 피로도
3. answer 출력

중복 순열(depth, sum, a, b ,c)
1. depth == n
    1.1. answer, sum 갱신
2. for문 돌리기
    2.1. a>0, recur(depth+1,sum+값,a-1,b,c);
    2.2. b>0
    2.3. c>0

풀이
1. picks 곡갱이 입력, mineerlas 돌 입력
2. minerals 정렬
3. for문 돌리기 => minerals크기
    3.1. minerals == 0일때
        3.1.1. a>0 이면 answer += 1
        3.1.2. b>0 이면 answer += 5
        3.1.3. answer += 25
    3.2. minerals == 1일때
        3.2.1. a>0 이면 answer += 1
        3.2.2. b>0 이면 answer += 1
        3.2.3. answer += 5
    3.3. minerals == 2일때
        3.3.1. answer += 5
*/
class Solution {
    private int[] mineralsCopy;
    private int answer = Integer.MAX_VALUE;
    private int size;
    public int solution(int[] picks, String[] minerals) {
        size = minerals.length;
        mineralsCopy = new int[size];
        for(int i = 0;i<size;i++){
            if(minerals[i].equals("diamond")){
                mineralsCopy[i]=0;
            }else if(minerals[i].equals("iron")){
                mineralsCopy[i]=1;
            }else if(minerals[i].equals("stone")){
                mineralsCopy[i]=2;
            }
        }
        recur(0,0,picks[0],picks[1],picks[2]);
        return answer;
    }
    
    private void recur(int depth, int sum ,int a, int b ,int c){
        if(depth>=size || (a==0 && b==0 && c==0)){
            answer = Math.min(sum,answer);
            return;
        }
        if(a>0) {
            int temp = sum;
            for(int i = depth;(i<depth+5 && i<size);i++){
                temp++;
            }
            recur(depth+5,temp,a-1,b,c);
        }
        if(b>0){
            int temp = sum;
            for(int i = depth;(i<depth+5 && i<size);i++){
                if(mineralsCopy[i]==0){
                    temp += 5;
                } else {
                     temp += 1;
                }
            }
            recur(depth+5,temp,a,b-1,c);
        }
        if(c>0){
            int temp = sum;
            for(int i = depth;(i<depth+5 && i<size);i++){
                if(mineralsCopy[i]==0){
                    temp += 25;
                } else if(mineralsCopy[i]==1){
                    temp += 5;
                } else {
                    temp += 1;
                }
            }
            recur(depth+5,temp,a,b,c-1);
        }
    }
}