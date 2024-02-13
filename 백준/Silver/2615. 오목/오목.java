/*
 * 문제
 * 1. 바둑알이 주어짐
 * 2. 5개를 이으면 승리
 * 3. 6개 되면 안됨
 * 4. 가장 왼쪽에 있거나 가장 위쪽에 있는 돌 위치와 승리한 사람 출력
 * 5. 승자가 없으면 0출력
 * 
 * 풀이
 * 1. 오목판 만들기 -> arr[19][19]
 * 2. 오목판 입력 받기
 * 3. 4방 탐새을 위한 dir 생성 -> {{1,0},{0,-1},{1,1},{-1,1}}
 * 4. 모든 오목판을 탐색하며 돌을 만나는 경우 오목 판단
 * 	4.1. dir역방향으로 동일한 것이 있는지 탐색있으면 종료
 * 	4.2. dir 정방향으로 5개가 있는지 탐색 => 6개면 실패
 * 	4.3. 오목이 있으면 출력 후 종료
 * 5. 모든 판 탐색 이후에도 없으면 0출력
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[][] dir = {{1,0},{0,1},{1,1},{-1,1}};
	public static void main(String[] args) throws Exception {
		int[][] arr = new int[19][19];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0;i<19;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ;j<19;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ;i<19;i++) {
			for(int j = 0 ;j<19;j++) {
				if(arr[i][j]!=0) {
					int stone = arr[i][j];
					for(int k = 0 ;k<4;k++) {
						int nr = i - dir[k][0];
						int nc = j - dir[k][1];
						if(nr>=0 && nc >=0 && nr<19 && nc<19 && arr[nr][nc]==stone) continue;
						nr = i + dir[k][0];
						nc = j + dir[k][1];
						int count = 1;
						for(int l = 0; l<5;l++) {
							if(nr < 0 || nc <0 || nr>=19 || nc>=19 || arr[nr][nc] != stone) break;
							count++;
							nr = nr + dir[k][0];
							nc = nc + dir[k][1];
						}
						if(count == 5) {
							System.out.println(stone);
							System.out.println((i+1) + " " + (j+1));
							return;
						}
					}
				}
			}
		}
		System.out.println(0);
	}
}