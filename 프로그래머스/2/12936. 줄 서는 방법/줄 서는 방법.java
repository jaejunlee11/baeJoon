import java.util.*;
/*
문제
1. n명 존재
2. 3명 뽑기
3. 사전순으로 했을 때 k번째 고르기

풀이
1. 순열 돌리기
2. count가 K일때 종료
3. 출력

풀이2
0. list에 1~ n 넣기
1. k / (n-1)! => 나온 값 list의 index에서 제거
2. 반복
*/
class Solution {
    private int count = 0;
    public int[] answer;
    private boolean[] visited;
    private int num;
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i<=n;i++) {
            list.add(i);
        }
        int[] answer = new int[n];
        k--;
        for(int i = 0;i<n;i++) {
            long cal = fact(n-i-1);
            int temp = (int) (k / cal);
            answer[i] = list.get(temp);
            list.remove(temp); 
            k = k % cal;
        }
        return answer;
    }
    private long fact(long i) {
        if(i==0) return 1;
        return i * fact(i-1);
    }
}