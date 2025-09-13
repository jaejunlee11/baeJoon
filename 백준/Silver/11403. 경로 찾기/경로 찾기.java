/*
문제
1. 간선이 연결되었는지 볼 수 있는 판 n*n 존재
2. i, j가 연결되어있는지를 출력

풀이
1. N 입력
2. ListArr[N] 생성
3. listArr 채우기
4. for문 돌리기 => 100
    4.1. bfs 돌리기 => 만나는 숫자 List 에 담기
    4.2. List 순회 하면서 ans[i] 채우기
5. 출력
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> listArr = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            listArr.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 1) {
                    listArr.get(i).add(j);
                }
            }
        }
        int[][] ans  = new int[n][n];
        for(int i = 0;i<n;i++) {
            boolean[] visited = new boolean[n];
            Deque<Integer> que = new ArrayDeque<>();
            que.add(i);
            while(!que.isEmpty()) {
                int cur = que.poll();
                for(int j : listArr.get(cur)) {
                    if(visited[j]) continue;
                    visited[j] = true;
                    que.add(j);
                    ans[i][j] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++) {
            for(int j : ans[i]) {
                sb.append(j).append(" ");
            }
            if(i == n-1) break;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
