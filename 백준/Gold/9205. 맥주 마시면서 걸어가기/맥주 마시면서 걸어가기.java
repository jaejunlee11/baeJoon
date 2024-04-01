/*
 * 문제
 * 1. 맥주를 마시면 50m를 걷는 것이 가능
 * 2. 가는 길에 편의점이 있으면 맥주를 사는 것이 가능 => 최대 20병 소유 가능
 * 3. 페스티벌까지 갈 수 있는지
 * 
 * 풀이
 * 1. T 테케입력
 * 2. N 편의점 갯수 입력
 * 3. shop[N][2]생성
 * 4. shop입력
 * 5. home[2], goal[2] 생성 및 입력
 * 6. 각 편의점, 집, 도착지 끼리의 모든 거리를 계산 arr[N+2][N+2]
 * 7. que에 0 담기 + visted처리
 * 8. while => que 빌때 까지
 * 	8.1. que에서 꺼내기
 * 	8.2. for문 돌리기 (0~N+1)
 * 		8.2.1. arr[꺼낸값][i]가 0인값 continue
 * 		8.2.2. 1000보다 큰값 continue
 * 		8.2.3. visited면 conitnue
 * 		8.2.4. visited처리 후 que에 담기
 * 		8.2.5. 1이 가능하면 happy출력 후 종료
 * 9. sad 출력
 * 
 * 시간 복잡도
 * 1. 102*51 + 100*100 => 충분
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc= 0; tc<T; tc++) {
            
            int N = Integer.parseInt(br.readLine());
            int[][] shop = new int[N+2][2];
            for(int i=0; i<N+2; i++) {
                st = new StringTokenizer(br.readLine());
                shop[i][0] = Integer.parseInt(st.nextToken());
                shop[i][1] = Integer.parseInt(st.nextToken());
            }
            int[][] arr = new int[N+2][N+2];
            for(int i = 0;i<N+2;i++) {
            	for(int j = 0;j<N+2;j++) {
            		arr[i][j] = Math.abs(shop[i][0]-shop[j][0]) + Math.abs(shop[i][1]-shop[j][1]);
            		arr[j][i] = arr[i][j];
            	}
            }
            Deque<Integer> que = new ArrayDeque<>();
            boolean[] visited = new boolean[N+2];
            que.add(0);
            boolean flag= false;
            A : while(!que.isEmpty()) {
            	int start = que.poll();
            	for(int i = 0;i<N+2;i++) {
            		if(visited[i]) continue;
            		if(arr[start][i]>1000) continue;
            		if(i==N+1) {
            			flag=true;
            			break A;
            		}
            		visited[i] = true;
            		que.add(i);
            	}
            }
            if(flag) {
            	System.out.println("happy");
            }else {
            	System.out.println("sad");
            }
        }
    }

}