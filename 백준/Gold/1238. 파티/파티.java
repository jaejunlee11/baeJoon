/*
 * 문제
 * 1. 파티 열림
 * 2. N번 마을에서 열림
 * 3. 각 사람들이 찾아왔다 돌아감
 * 4. 가장 오래 걸어야하는 사람은?
 *
 * 풀이
 * 1. N, M ,X 입력
 * 2. arrList1[N+1], arrList2[N+1]
 * 3. arrList1,2채우기
 *     3.1. arrList1[a].add({b,g}) 2는 거꾸로
 * 4.0. 다익돌리기
 * 4. priorityQue 생성,dir1[N+1]생성
 * 5. que.add({x,0})
 * 6.while문 돌기 => que가 빌때까지
 *     6.1. loc = poll
 *     6.2. for문 돌리기 => arrList1[loc[0]]
 *         6.2.1. g + loc[1]이 dir[b] 보다 큰 경우
 *             6.2.1.1. dir1[b] 갱신 + que.add({b,dir1[b]})
 * 7. 거꾸로 구하기
 * 8. dir1[i]+dir2[i]가 최대인 i구하기
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<int[]>[] arrList1 = new List[N+1];
        List<int[]>[] arrList2 = new List[N+1];
        for(int i = 1;i<=N;i++) {
            arrList1[i] = new ArrayList();
            arrList2[i] = new ArrayList();
        }
        for(int i = 0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            arrList1[a].add(new int[] {b,g});
            arrList2[b].add(new int[] {a,g});
        }
        PriorityQueue<int[]> que = new PriorityQueue<>((o1,o2)->{
            return o1[1]-o2[1];
        });
        int[] dis1 = new int[N+1];
        for(int i = 1;i<=N;i++) {
            if(i==X) continue;
            dis1[i] = 1000000;
        }
        que.add(new int[] {X,0});
        while(!que.isEmpty()) {
            int[] loc = que.poll();
            for(int[] temp : arrList1[loc[0]]) {
                if(temp[1]+dis1[loc[0]]<dis1[temp[0]]) {
                    dis1[temp[0]] = temp[1]+dis1[loc[0]];
                    que.add(new int[] {temp[0],dis1[temp[0]]});
                }
            }
        }
        int[] dis2 = new int[N+1];
        for(int i = 1;i<=N;i++) {
            if(i==X) continue;
            dis2[i] = 1000000;
        }
        que.add(new int[] {X,0});
        while(!que.isEmpty()) {
            int[] loc = que.poll();
            for(int[] temp : arrList2[loc[0]]) {
                if(temp[1]+dis2[loc[0]]<dis2[temp[0]]) {
                    dis2[temp[0]] = temp[1]+dis2[loc[0]];
                    que.add(new int[] {temp[0],dis2[temp[0]]});
                }
            }
        }
        int temp = 0;
        for(int i = 1;i<=N;i++) {
            if(temp<dis1[i]+dis2[i]) {
                temp = dis1[i]+dis2[i];
            }
        }

        System.out.println(temp);
    }
}