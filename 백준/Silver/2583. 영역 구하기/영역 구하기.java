import java.io.*;
import java.util.*;
/*
문제
1. 판이 주어짐
2. 위에 종이를 여러장 둠
3. 종이들이 없는 부분의 영역 크기와 갯수 구하기

풀이
1. M, N, K입력
2. arr[M][N]생성
3. for문 돌리기 => K
    3.1. for문 돌리기 => a ~ b
        3.1.1. for문 돌리기 => c~d
            3.1.1.1. arr 채우기
4. for문 돌리기 => M , answer = 0
    4.1. for문 돌리기 => N
        4.1.1. arr true이면 continue
        4.1.2. que에 담기 , arr true로 변경, count = 1, answer ++
        4.1.3. while돌리기 => que 빌때 까지
            4.1.3.1. que에서 꺼내기
            4.1.3.2. 4방 탐색 {{0,1},{0,-1},{1,0},{-1,0}}
                4.1.3.2.1. 경계 체크
                4.1.3.2.2. arr 체크
                4.1.3.2.3. arr true로 변경, count++, que에 담기
        4.1.4. answerList에 count담기
5. answer 출력, answerList 정렬 후 출력
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[M][N];
        for(int i = 0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for(int x = a;x<c;x++){
                for(int y = b;y<d;y++){
                    arr[y][x] = true;
                }
            }
        }
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int answer = 0;
        int count = 0;
        List<Integer> answerList = new ArrayList<>();
        ArrayDeque<int[]> que = new ArrayDeque<>();
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(arr[i][j]) continue;
                que.add(new int[] {i,j});
                arr[i][j] = true;
                count = 1;
                answer++;
                while(!que.isEmpty()){
                    int[] loc = que.poll();
                    int r = loc[0];
                    int c = loc[1];
                    for(int k = 0;k<4;k++){
                        int nr = r + dir[k][0];
                        int nc = c + dir[k][1];
                        if(nr>=M || nc>=N || nr<0 || nc<0) continue;
                        if(arr[nr][nc]) continue;
                        que.add(new int[] {nr,nc});
                        arr[nr][nc] = true;
                        count++;
                    }
                }
                answerList.add(count);
            }
        }
        System.out.println(answer);
        Collections.sort(answerList);
        for(int i : answerList){
            System.out.print(i + " ");
        }
    }
}