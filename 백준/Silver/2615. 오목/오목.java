import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("Test5.txt"));
		// //8방탐색을 위한 dir
		// int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{1,1},{-1,-1}};
		// 대각 탐색을 위한 dir

		int[][] dir = { { 1, -1 }, { -1, 1 }, { 1, 1 }, { -1, -1 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 바둑판 생성
		int[][] board = new int[19][19];
		// 바둑판 채우기
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 우탐색 -> 5개인 경우 돌의 색과 첫 위치를 출력하고 break;
		// 돌 위치
		int fr = 0;
		int fc = 0;
		// 돌 색
		int rockColor = 0;
		// 연속 값
		int rockCount = 0;
		// 가로 탐색
		A: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] == 0) {
//					//16번째 칸 부터는 5개가 못 만들어짐(만들어질 수 있어도 이미 체크한 곳) -> 다음 줄로 이동
//					if(j>14) continue A;
					continue;
				} else {
					// 우하 방향 대각 확인 -> 좌상도 확인하여 count를 더 해줌
					fr = i;
					fc = j;
					rockColor = board[i][j];
					rockCount = 1;
					int nr = 0;
					int nc = 0;
					for (int k = 4; k < 6; k++) {
						nr = fr + dir[k][0];
						nc = fc + dir[k][1];
						while (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && (board[nr][nc] == rockColor)) {
							rockCount++;
							nr += dir[k][0];
							nc += dir[k][1];
						}
					}
					if (rockCount == 5) {
						System.out.println(rockColor);
						System.out.println((fr + 1) + " " + (fc + 1));
						return;
					}
				}
			}
		}
		// 세로 탐색
		A: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] == 0) {
//					//16번째 칸 부터는 5개가 못 만들어짐(만들어질 수 있어도 이미 체크한 곳) -> 다음 줄로 이동
//					if(i>14) continue A;
					continue;
				} else {
					// 우하 방향 대각 확인 -> 좌상도 확인하여 count를 더 해줌
					fr = i;
					fc = j;
					rockColor = board[i][j];
					rockCount = 1;
					int nr = 0;
					int nc = 0;
					for (int k = 6; k < 8; k++) {
						nr = fr + dir[k][0];
						nc = fc + dir[k][1];
						while (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && (board[nr][nc] == rockColor)) {
							rockCount++;
							nr += dir[k][0];
							nc += dir[k][1];
						}
					}
					if (rockCount == 5) {
						System.out.println(rockColor);
						System.out.println((fr + 1) + " " + (fc + 1));
						return;
					}
				}
			}
		}
		// 대각 탐색(하우)
		A: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] == 0) {
					// 16번째 칸 부터는 5개가 못 만들어짐(만들어질 수 있어도 이미 체크한 곳) -> 다음 줄로 이동
//					if(j>14) continue A;
//					if(i>14) continue A;
					continue;
				} else {
					// 우하 방향 대각 확인 -> 좌상도 확인하여 count를 더 해줌
					fr = i;
					fc = j;
					rockColor = board[i][j];
					rockCount = 1;
					int nr = 0;
					int nc = 0;
					for (int k = 0; k < 2; k++) {
						nr = fr + dir[k][0];
						nc = fc + dir[k][1];
						while (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && (board[nr][nc] == rockColor)) {
							rockCount++;
							nr += dir[k][0];
							nc += dir[k][1];
						}
					}
					if (rockCount == 5) {
						System.out.println(rockColor);
						System.out.println((fr + 5) + " " + (fc - 3));
						return;
					}
				}
			}
		}
		// 대각 탐색(상우)
		A: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] == 0) {
					// 16번째 칸 부터는 5개가 못 만들어짐(만들어 질 수 있어도 그전에 이미 체크한 곳) -> 다음 줄로 이동
//					if(j>14) continue A;
					continue;
				} else {
					// 우하 방향 대각 확인 -> 좌상도 확인하여 count를 더 해줌
					fr = i;
					fc = j;
					rockColor = board[i][j];
					rockCount = 1;
					int nr = 0;
					int nc = 0;
					for (int k = 2; k < 4; k++) {
						nr = i + dir[k][0];
						nc = j + dir[k][1];
						while (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && board[nr][nc] == rockColor) {
							rockCount++;
							nr += dir[k][0];
							nc += dir[k][1];
						}
					}
					if (rockCount == 5) {
						System.out.println(rockColor);
						System.out.println((fr + 1) + " " + (fc + 1));
						return;
					}
				}
			}
		}
		System.out.println("0");
	}
}
