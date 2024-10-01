import java.util.*;
/*
문제
1. 전력망을 2개로 분할 할려고 함
2. 치대한 비슷하게 분할
3. 두 갯수의 차이를 출력

풀이
1. arr[n+1][n+1] 생성
2. arr 채우기
3. for문 돌리기 => n
    3.1. arr[wires[i][0]][wires[i][1]] = 0
    3.2. arr[wires[i][1]][wires[i][0]] = 0
    3.3. bfs 돌리기 => 갯수 세기
    3.4. answer 갱신
    3.5. 복구
4. answer 출력
*/
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[][] arr = new int[n+1][n+1];
        int wireSize = wires.length;
        for(int i = 0;i<wireSize;i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        for(int i = 0;i<wireSize;i++){
            arr[wires[i][0]][wires[i][1]] = 0;
            arr[wires[i][1]][wires[i][0]] = 0;
            boolean[] check = new boolean[n+1];
            int count = 1;
            check[1] = true;
            Deque<Integer> que = new ArrayDeque<>();
            que.add(1);
            while(!que.isEmpty()){
                int temp = que.poll();
                for(int j = 1; j<=n;j++) {
                    if(check[j]) continue;
                    if(arr[temp][j]==1) {
                        check[j] = true;
                        count++;
                        que.add(j);
                    }
                }
            }
            answer = Math.min(answer, Math.abs(n-count*2));
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        return answer;
    }
}