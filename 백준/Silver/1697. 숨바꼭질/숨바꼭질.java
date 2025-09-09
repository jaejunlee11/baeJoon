/*
문제
1. 수빈이가 N, 동생이 K에 존재
2. x*2로 이동 or +1 로 이동 or -1로 이동 가능
3. 최소 이동으로 도착하는 방법 구하기

풀이
1. arr[100001] 생성
2. N, K 입력
3. que에 N 넣기
4. que가 빌때까지 돌기
    4.1. size 측정
    4.2. size 만큼 돌기
        4.2.1. +1, -1, *2 visited 확인, K 확인
        4.2.2. que에 담기
 */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] visited = new boolean[100001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(N==K) {
            System.out.println(0);
            return;
        }
        visited[N] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        int ans = 0;
        while(!q.isEmpty()) {
            ans++;
            int size = q.size();
            while(size-- > 0) {
                int n = q.poll();
                if(n+1 == K || n-1 == K || n*2 == K) {
                    System.out.println(ans);
                    return;
                }
                if(n-1>=0 && !visited[n-1]) {
                    visited[n-1] = true;
                    q.add(n-1);
                }

                if(n+1 <= 100000 && !visited[n+1]) {
                    visited[n+1] = true;
                    q.add(n+1);
                }

                if(n*2 <= 100000 && !visited[n*2]) {
                    visited[n*2] = true;
                    q.add(n*2);
                }
            }
        }
    }
}
