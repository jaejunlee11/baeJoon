import java.io.*;
/*
문제
1. 상자가 있음
2. 상자에 번호를 주고 임의의 카드를 넣음
3. 상자를 뽑아서 뭉탱이를 뽑을 때 2개의 곱이 최대인것
4. 뭉탱이가 1개면 0

풀이
1. cards입력
2. for문 돌리기 => cards크기
    2.1. dfs돌면서 union시키기 => union실패시 해당 값 저장
3. list의 최대값들의 곱 구하기
*/
class Solution {
    private int n;
    private int parents[];
    private int[] cardsCopy;
    private boolean[] visited;
    public int solution(int[] cards) {
        int answer = 0;
        int cardsSize = cards.length;
        n = cardsSize;
        parents = new int[cardsSize+1];
        init();
        cardsCopy = cards;
        visited = new boolean[cardsSize+1];
        int first = 0;
        int second = 0;
        for(int i = 1;i<=cardsSize;i++){
            if(visited[i]) continue;
            int temp = dfs(i,1);
            if(first<=temp){
                second = first;
                first = temp;
            }else if(second<temp){
                second = temp;
            }
        }
        answer = first * second;
        return answer;
    }
    private void init(){
        for(int i = 1;i<=n;i++){
            parents[i]=i;
        }
    }
    private int find(int p){
        if(p==parents[p]) return p;
        return parents[p] = find(parents[p]);
    }
    private boolean union(int a , int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;
        parents[rootA] = rootB;
        return true;
    }
    private int dfs(int now, int sum){
        visited[now] = true;
        int temp = cardsCopy[now-1];
        if(union(now,temp)){
            sum += 1;
            return dfs(temp,sum);
        }
        return sum;
    }
}