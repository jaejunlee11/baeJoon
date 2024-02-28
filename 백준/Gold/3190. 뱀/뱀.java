import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 벽 또는 자기자신과 몸이 부딪히면 게임 끝
 * 사과를 먹으면 길이 늘어난다
 * 뱀 초기 위치 (0,0) 길이 1, 초기 방향 오른쪽
 * 
 * 뱀 이동
 *     - 몸 길이를 늘려 머리를 다음칸에 위치
 *  - 벽이나 자기자신의 몸과 부딪히면 끝
 *  - 이동한 칸에 사과가 있다면 그 칸의 사과 없어지고 꼬리 그대로
 *  - 사과가 없다면 꼬리가 따라옴. 몸길이 변화x
 *  - 게임 시작으로 부터 X초가 지난 후에 왼쪽 90도(L) or 오른쪽 90도(D)
 *  
 *  풀이
 *  while(벽에 닿거나 스스로 닿을 때 까지) cnt++
 *      스스로 몸통을 visit처리해서 뱀 위치 정하기
 *      사과를 만나면 머리만 자라나기, 없으면 꼬리 줄어들기
 *          2차원 배열에 저장할 것. 뱀이 움직인 위치에 대해서 사과 확인 후 false 사과 없애기
 *      방향 지시가 있으면 방향 바꾸기 왼쪽 -1, 오른쪽 +1 dir 설정하기
 *      
 *     시간복잡도
 *     보드 방문 100 * 100
 *  
 */


public class Main {
    static int[][] dir = {
            {0, 0, 1, 0, -1},
            {0, 1, 0, -1, 0}
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        boolean[][] apple = new boolean[N+1][N+1];
        int[][] board = new int[N+2][N+2];
        
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            apple[r][c] = true;
        }
        int L = Integer.parseInt(br.readLine());
        Deque<String[]> cmds = new ArrayDeque<>();
        
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            String time = st.nextToken();
            String direction = st.nextToken();
            cmds.offerLast(new String[] {time, direction});
        }
        int time = 1, cmdTime=0;
        int r=1, c=1;
        int d =1;
        int[] tail = new int[]{1, 1};
        String cmdDir = "";
        String [] cmd;
        
        board[r][c] = d;
        
        if(!cmds.isEmpty()) {
            cmd = cmds.pollFirst();
            cmdTime = Integer.parseInt(cmd[0]);
            cmdDir = cmd[1];
        }
        
        while(true) {
            
            r+=dir[0][d];
            c+=dir[1][d];
                    
            if(r<1|| r>N || c<1|| c>N || board[r][c]!=0 ) break;
            // If apple in new position
            if(!apple[r][c]) {
                int tailr = tail[0];
                int tailc = tail[1];
                int taild = board[tailr][tailc];
                int nr = tailr+dir[0][taild];
                int nc = tailc+dir[1][taild];
//                System.out.println(taild);
                tail = new int[] {nr, nc};
                board[tailr][tailc] = 0;
            }
            else {
                apple[r][c] = false;
            }
//            System.out.println(Arrays.toString(tail));
//            for(int i = 0;i<N;i++) {
//            	System.out.println(Arrays.toString(board[i]));
//            }
            // cmd Time
            if(time == cmdTime) {
                if(cmdDir.equals("D")) {
                    d++;
                    if(d==5) d=1;
                }
                else {
                    d--;
                    if(d==0) d=4;
                }
                if(!cmds.isEmpty()) {
                
                    cmd = cmds.pollFirst();
                    cmdTime = Integer.parseInt(cmd[0]);
                    cmdDir = cmd[1];
                }
            }
            
            board[r][c] = d;
            time ++;
            
        }
        System.out.println(time);
    }

}