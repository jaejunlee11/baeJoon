/*
 * 문제
 * 1. 뱀이 움직이는 경로가 주어짐
 * 2. 뱀이 사과를 먹으면 길이가 1 증가
 * 3. 뱀이 벽에 박거나 자신에게 박으면 게임 종료
 *
 * 풀이
 * 1. N이 주어짐
 * 2. board[N][N]생성
 * 3. K가 주어짐 -> 사과
 * 4. k개의 사과 배치 board[i][j] = 2
 * 5. L입력 -> 이동 횟수를 담을 que생성 int[2]로 넣기  
 * 6. 뱀을 리스트로 생성, (1,1)넣기 방향 : 오른쪽(0)
 * 7. 방향 배열 dir[][] ={{0,1},{-1,0},{0,-1},{1,0}}
 * 6. while로 돌기 -> count ++
 * 	6.1. que를 확인하고 해당 초와 일치하면 방향 전환 후 poll시키기
 * 	6.2. 방향에 맞게 머리를 이동 시킴(Deque에 앞쪽에 넣어주기) + (Deque에 뒤쪽 빼주기)
 * 		6.2.1. 이동 방향을 탐색 했을 때 경계거나 내 몸이면 count 출력 후 종료
 * 		6.2.2. 사과인 경우 꼬리 이동 skip -> 빼는 과정 X
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N+1][N+1];
		int K = Integer.parseInt(br.readLine());
		for(int i = 0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=2;
		}
		int L = Integer.parseInt(br.readLine());
		Deque<int[]> que = new ArrayDeque<>();
		for(int i = 0; i<L;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			que.add(new int[] {Integer.parseInt(st.nextToken()),(st.nextToken().charAt(0)-'A')});
		}
		// 머리, 꼬리, 방향
		int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
		Deque<int[]> snakes = new ArrayDeque<>();
		snakes.offerFirst(new int[] {1,1});
		int snake = 0;
		int count = 0;
		while(true) {
			count++;
			int[] loc = snakes.peek();
			int headR = loc[0] + dir[snake][0];
			int headC = loc[1] + dir[snake][1];
			if(headR<=0 || headC<=0 || headR>N || headC>N) break;
			if(board[headR][headC]==1) break;
			if(board[headR][headC]==2) {
				board[headR][headC]=1;
				snakes.offerFirst(new int[] {headR,headC});
			}else {
				board[headR][headC]=1;
				snakes.offerFirst(new int[] {headR,headC});
				int[] tail = snakes.pollLast();
				board[tail[0]][tail[1]]=0;
			}
			if(!que.isEmpty() && que.peek()[0]==count) {
				int[] loc2 = que.poll();
				if(loc2[1]==('L'-'A')) {
					snake++;
					if(snake==4) snake =0;
				}else {
					snake--;
					if(snake==-1) snake =3;
				}
			}
		}
		System.out.println(count);
	}
}