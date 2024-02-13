/*
 * 문제
 * 1. 빙산이 존재
 * 2. 주변에 0이 있으면 0갯수 만큼 숫자가 줄어듬
 * 3. 빙산이 두 덩어리가 되는 시점을 구하기
 * 
 * 풀이
 * 1. 빙산 가로 세로 입력 ->N,M, 300
 * 2. 빙산 배열 만들기 arr[N][M]
 * 3. 빙산 입력 받기
 * 4. dir 배열 만들기 상하좌우
 * 5. 0이 아닌 값들을 4방 탐색 후 0의 갯수만큼 숫자 깍기 -> 이때 갯수 count
 * 6. 다시 0이 아닌 것에서 4방탐색으로 재귀 돌리기 -> 갯수 count => 다르면 2덩이
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		//상하좌우 탐색
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		//가로 세로 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//배열 생성
		int[][] arr = new int[N][M];
		boolean[][] ice = new boolean[N][M];
		//입력 받기
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//정답 값
		int answer = 0;
		while(true) {
			//현재 얼음의 수
			int count = 0;
			for(int i = 0;i<N;i++) {
				for(int j  =0 ; j<M;j++) {
					if(arr[i][j]==0) ice[i][j]=true;
				}
			}
			for(int i =0;i<N;i++) {
				for(int j = 0;j<M;j++) {
					//얼음
					if(arr[i][j]!=0) {
						//4방향을 보고 0이 있으면 1감소 -> 이미 0일 때는 감소 X
						for(int k = 0;k<4;k++) {
							if(arr[i][j]>0 && ice[i+dir[k][0]][j+dir[k][1]]) arr[i][j]--;
						}
						//아직 얼음이 남았으면 count++
						if(arr[i][j]!=0) count++;
					}
				}
			}
			
			//모든 얼음이 녹았으면 0출력 후 종료
			if(count == 0) {
				System.out.println(0);
				return;
			}
//			for(int s = 0;s<N;s++) {
//				System.out.println(Arrays.toString(arr[s]));
//			}
//			System.out.println();
			
			//얼음이 한덩이인지 확인하기 위한 변수
			int oneCount = 0;
			//지나간 곳을 체크하기위한 배열
			boolean[][] checked = new boolean[N][M];
			A : for(int i = 0;i<N;i++) {
				for(int j = 0;j<M;j++) {
					//0이 아닌 것을 만난 경우
					if(arr[i][j]!=0) {
						//BFS를 활용하여 해당 덩이의 크기 확인
						Deque<int[]> que = new ArrayDeque<>();
						que.add(new int[] {i,j});
						checked[i][j] = true;
						oneCount++;
						while(que.size()!=0) {
							int[] temp = que.poll();
							int nr = temp[0];
							int nc = temp[1];
							for(int k = 0;k<4;k++) {
								//주변에 0이 아니고 들렸던 곳이 아니면 que에 넣음
								if(arr[nr+dir[k][0]][nc+dir[k][1]]!=0 && checked[nr+dir[k][0]][nc+dir[k][1]]==false) {
									que.add(new int[] {nr+dir[k][0],nc+dir[k][1]});
									checked[nr+dir[k][0]][nc+dir[k][1]] = true;
									oneCount++;
								}
							}
						}
						//한덩이의 크기를 체크한 후 break
						break A;
					}

				}
			}
			answer++;
			//한덩이의 크기가 현재 얼음의 크기와 다르면 출력
			if(oneCount!=count) {
				System.out.println(answer);
				return;
			}
		}

	}
}