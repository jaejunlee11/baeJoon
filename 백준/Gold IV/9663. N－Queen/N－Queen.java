/*
 * 문제
 * 1. 퀸을 서로 공격 못하게 배치
 * 2. 퀸이 공격하지 못하는 경우의 수 구하기
 * 
 * 풀이
 * 1.테케 입력 받기
 * 2. N입력 받기 -> 최대 10
 * 3. queens[N]배열 만들기
 * 4. dfs돌기
 * 
 * dfs
 * 0. depth가 N에 도달하면 count++ reurn;
 * 1. for문 돌기
 *  1.1. depth만큼 for문을 돌면서
 *      1.1.1. queens[k] 가 j와 같거나(세로체크)
 *      1.1.2. queens[k] - j 이 k-i의 절대값과 같으면(대각체크) continue
 *  1.2. 아니면 queens[depht+1]에 j를 담고
 *  1.3. queens(depth+1)
 */
import java.io.*;
import java.util.*;
 
public class Main {
    static int answer =0;
    static int N;
    static int[] queens;
    static boolean[] visited;
    static boolean[] cross1;
    static boolean[] cross2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            answer = 0;
            queens = new int[N];
            visited = new boolean[N];
            cross1 = new boolean[2*N-1];
            cross2 = new boolean[2*N-1];
            recur(0);
            if(N==1) System.out.println(1);
            else System.out.println(answer);
    }
     
    public static void recur(int depth) {
        if(depth==N) {
            answer++;
            return;
        }
        A: for(int i =0;i<N;i++) {
            if(visited[i]==true) continue;
            if(cross1[depth+i] == true) continue;
            if(cross2[depth-i+(N-1)]==true) continue;
            visited[i] = true;
            cross1[depth+i] = true;
            cross2[depth-i+(N-1)] = true;
            queens[depth] = i;
            recur(depth+1);
            visited[i] = false;
            cross1[depth+i] = false;
            cross2[depth-i+(N-1)] =false;
        }
    }
}