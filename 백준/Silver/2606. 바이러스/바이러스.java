import java.io.*;
import java.sql.Array;
import java.util.*;
/*
문제
1. 컴퓨터가 존재
2. 컴퓨터가 연결
3. 1번 부터 어디까지 감염되는지

풀이
1. N 입력
2. M 입력
3. list[]<> 생성
4. bfs돌리기
5. 갯수 확인
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Integer>[] arr =  new ArrayList[N];
        for(int i =0;i<N;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            arr[a].add(b);
            arr[b].add(a);
        }
        boolean[] visited = new boolean[N];
        Deque<Integer> que = new ArrayDeque<>();
        visited[0] = true;
        que.add(0);
        int count = 0;
        while(!que.isEmpty()){
            int a = que.poll();
            for(int b:arr[a]){
                if(visited[b]) continue;
                count++;
                visited[b]=true;
                que.add(b);
            }
        }
        System.out.println(count);
    }
}