import java.util.*;
import java.io.*;
/*
문제
1. 1번 헛간에서 N번 헛간으로 이동
2. 최소로 여물을 주면서 이동하기

풀이
1. N,M 입력
2. arr[N+1]생성, arrList[N+1] 생성, priority que 생성
3. arr 최대값으로 채우기
4. arrList 생성 및 채우기
5. que에 (1,0) 넣기
6. while 돌리기
    6.1. que.poll
    6.2. for문 돌리기 => arrList[poll[0]값]
        6.2.1. arr[poll[0]] + poll[1] < arr[temp[0]]
        6.2.2. arr[temp[0] = arr[poll[0]] + poll[1]
        6.2.3. que.add({temp[0], arr[temp[0]]}
7. arr[N] 출력
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        List<int[]>[] arrList = new List[n+1];
        for(int i = 1; i <= n; i++) {
            arrList[i] = new ArrayList<>();
        }
        for(int i = 0 ; i <m ;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arrList[a].add(new int[]{b,c});
            arrList[b].add(new int[]{a,c});
        }
        for(int i = 2 ; i <=n ;i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{1,0});
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            for(int[] now : arrList[temp[0]]) {
                if(temp[1] + now[1] < arr[now[0]]) {
                    arr[now[0]] = temp[1] + now[1];
                    pq.add(new int[] {now[0], arr[now[0]]});
                }
            }
        }
        System.out.println(arr[n]);
    }
}