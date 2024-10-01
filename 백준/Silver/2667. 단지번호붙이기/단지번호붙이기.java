import java.util.*;
import java.io.*;
/*
문제
1. 단지들이 존재
2. 단지의 갯수와 크기를 출력

풀이
1. N입력
2. arr[N][N]생성
3. for문 돌리기
    3.1. 1인 경우 bfs 돌리기 => 크기 구하기
    3.2. answerList에 담기
4. answerList 크기 출력, answerList 출력
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        boolean[][] visited = new boolean[N][N];
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;
                if(arr[i][j] == 0) continue;
                visited[i][j] = true;
                Deque<int[]> que = new ArrayDeque<>();
                que.add(new int[]{i, j});
                int count = 1;
                while(!que.isEmpty()){
                    int[] cur = que.poll();
                    for(int k = 0; k < 4; k++){
                        int nr = cur[0] + dir[k][0];
                        int nc = cur[1] + dir[k][1];
                        if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                        if(visited[nr][nc]) continue;
                        if(arr[nr][nc] == 0) continue;
                        visited[nr][nc] = true;
                        que.add(new int[]{nr, nc});
                        count++;
                    }
                }
                answerList.add(count);
            }
        }
        System.out.println(answerList.size());
        Collections.sort(answerList);
        for(int i : answerList){
            System.out.println(i);
        }
    }
}