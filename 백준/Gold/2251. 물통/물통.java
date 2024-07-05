import java.io.*;
import java.util.*;
/*
문제
1. 물통 3개 존재
2. 물이 다 찰때까지 이동 가능, 혹은 다 빌때 까지
3. A가 비었을 때 C에 있을 수 있는 가능성

풀이
1. a, b ,c 임력
2. waterA, waterB, waterC
3. waterC = c
4. c->a, c->b, b->a, a->c, b->c, a->b
5. que 생성, visited리스트 생성
6. que에 a,b,c값 넣기, visited에 넣기, answerSet에 넣기
7. wile 돌리기 que 빌때 까지
    7.1. que에서 꺼내기
    7.2. for문 돌리기 => 6
        7.2.1. 이동 => 이동이 없으면 continue
        7.2.2. visited리스트에서 확인 => 동일한게 있으면 continue
        7.2.3. visted에 넣기, a==0이면 answerSet에 넣기
8. answerSet정렬 후 출력
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] water = new int[3];
        water[2] = arr[2];
        ArrayDeque<int[]> que = new ArrayDeque<>();
        Set<Integer> answer = new HashSet<>();
        List<int[]> visited = new ArrayList<>();
        que.add(water);
        visited.add(water);
        answer.add(water[2]);
        int[][] dir = {{0,1},{1,0},{0,2},{2,0},{1,2},{2,1}};
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            A : for(int i = 0 ;i<6;i++){
                int[] temp = cur.clone();
                temp[dir[i][0]] += temp[dir[i][1]];
                temp[dir[i][1]] = 0;
                if(temp[dir[i][0]] > arr[dir[i][0]]){
                    temp[dir[i][1]] = temp[dir[i][0]] - arr[dir[i][0]];
                    temp[dir[i][0]] = arr[dir[i][0]];
                }
                if(cur[dir[i][0]]==temp[dir[i][0]]) continue A;
                for(int[] visit : visited) {
                    if (visit[0] == temp[0] && visit[1] == temp[1] && visit[2] == temp[2]) continue A;
                }
                visited.add(temp);
                if(temp[0]==0){
                    answer.add(temp[2]);
                }
                que.add(temp);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int a : answer){
            list.add(a);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int a : list){
            sb.append(a + " ");
        }
        System.out.println(sb);
    }
}