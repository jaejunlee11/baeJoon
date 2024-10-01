import java.util.*;
/*
문제
1. 숫자 종이들이 주어짐
2. 합쳐서 소수가 되는지 확인

풀이
1. 순열 돌리기
2. set에 담기
3. set갯수 출력
*/
class Solution {
    private int size;
    private int s;
    private int[] arr;
    private int[] picked;
    private boolean[] visited;
    private Set<Integer> set;
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet();
        s = numbers.length();
        arr = new int[s];
        for(int i = 0;i<s;i++) {
            arr[i] = numbers.charAt(i) - '0';
        }
        picked = new int[s];
        visited = new boolean[s];
        for(int i = 1;i<=s;i++){
            size = i;
            recur(0);
        }
        return set.size();
    }
    private void recur(int depth) {
        if(depth==size) {
            int temp = 0;
            for(int i = 0;i<size;i++){
                temp *= 10;
                temp += picked[i];
            }
            if(!check(temp)) return;
            set.add(temp);
            return;
        }
        for(int i = 0;i<s;i++) {
            if(visited[i]) continue;
            visited[i] = true;
            picked[depth] = arr[i];
            recur(depth+1);
            visited[i] = false;
        }
    }
    private boolean check(int a) {
        if(a==2) return true;
        if(a==1) return false;
        if(a==0) return false;
        for(int i = 2;i*i<=a;i++){
            if(a%i==0) return false;
        }
        return true;
    }
}