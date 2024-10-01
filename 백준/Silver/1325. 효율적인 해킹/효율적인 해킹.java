import java.io.*;
import java.util.*;
/*
문제
1. n개의 컴퓨터가 존재
2. A => B 신뢰 시 B해킹하면 A도 해킹당함
3. 1개의 컴퓨터를 해킹해서 최대한 많은 해킹을 하는 방법

풀이
1. N, M 입력
2. arrList[N+1] 생성 => new 로 생성
3. for문 돌리기
    3.1. arrList[b].add(a)
    3.2. arrList[a].add(b)
4. visited 배열 만들기
5. for문 돌리기
    5.1. visited가 아닌 경우
    5.2. bfs돌리기 => visited처리 안풀기 => answer 업데이트
6. answer 출력
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] arrList = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            arrList[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
//            arrList[a].add(b);
            arrList[b].add(a);
        }
        boolean[] visited = new boolean[n+1];
        int answer = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
//            if(visited[i]) continue;
            visited = new boolean[n+1];
            int count = 1;
            visited[i] = true;
            ArrayDeque<Integer> que = new ArrayDeque<>();
            que.add(i);
            while(!que.isEmpty()){
                int a = que.poll();
                for(int b : arrList[a]) {
                    if(!visited[b]){
                        visited[b] = true;
                        que.add(b);
                        count++;
                    }
                }
            }
            if(count > answer) {
                answer = count;
                ans.clear();
                ans.add(i);
            } else if(answer == count) {
                ans.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : ans) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}