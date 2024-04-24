/*
 * 문제
 * 1. 12개의 공이 떨어짐
 * 2. 4개가 붙어 있으면 제거 => count++
 * 
 * 풀이
 * 1. map[12][6]
 * 2. for문 돌리기 => 12
 * 	2.1. for문 돌리기 => 6
 * 		2.1.1. . => 0, R => 1, G => 2, B => 3, P =>4, Y =>5
 * 3. arr[12][6] 생성 
 * 3. for문 돌리기 => 11~0
 * 	3.1. arr[0]에 map[i]복사
 * 	3.2. for문돌기 6, que 생성 
 * 		3.2.1. for문 돌기 11~0
 * 			3.2.1.1. arr[j][i] 순회하면서 0이 아닌 값 담기 +0 으로 바꾸기 
 * 		3.2.2. for문 돌기 11~0
 * 			3.2.2.1. que에서 꺼내면서 넣기 
 * 	3.3. arr전부 순회
 * 		3.3.1. visited처리하면서 4 이상이면 0으로 제거 후 answer ++
 * 4.answer출력 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[12][6];
		for(int i = 0;i<12;i++) {
			String temp = br.readLine();
			for(int j = 0;j<6;j++) {
				if(temp.charAt(j)=='.') {
					arr[i][j] = 0;
				}else if(temp.charAt(j)=='R') {
					arr[i][j] = 1;
				}else if(temp.charAt(j)=='G') {
					arr[i][j] = 2;
				}else if(temp.charAt(j)=='B') {
					arr[i][j] = 3;
				}else if(temp.charAt(j)=='P') {
					arr[i][j] = 4;
				}else if(temp.charAt(j)=='Y') {
					arr[i][j] = 5;
				}
			}
		}
		int answer = 0;
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

//		for(int r = 0;r<12;r++) {
//			System.out.println(Arrays.toString(arr[r]));
//		}
//		System.out.println();
		while(true) {
			boolean visited[][] = new boolean[12][6];
			boolean flag = false;
			for(int r = 0;r<12;r++) {
				for(int c = 0;c<6;c++) {
					if(visited[r][c]) continue;
					visited[r][c] = true;
					if(arr[r][c]==0) continue;
					Deque<int[]> que = new ArrayDeque();
					Deque<int[]> que2 = new ArrayDeque();
					int color = arr[r][c];
					int fieldCout = 1;
					que.add(new int[] {r,c});
					que2.add(new int[] {r,c});
					while(!que.isEmpty()) {
						int[] loc = que.poll();
						for(int k = 0;k<4;k++) {
							int nr = loc[0] + dir[k][0];
							int nc = loc[1] + dir[k][1];
							if(nr>=12 || nc>=6 ||nr<0 || nc<0) continue;
							if(visited[nr][nc]) continue;
							if(arr[nr][nc]==0) {
								visited[nr][nc] = true;
								continue;
							}
							if(arr[nr][nc]!=color) continue;
							visited[nr][nc] = true;
							que.add(new int[] {nr,nc});
							que2.add(new int[] {nr,nc});
							fieldCout++;
						}
					}
					if(fieldCout>=4) {
						while(!que2.isEmpty()) {
							int[] loc = que2.poll();
							arr[loc[0]][loc[1]] = 0;
						}
						flag = true;
					}
				}
			}
			if(!flag) break;
			answer++;
			for(int j = 0;j<6;j++) {
				Deque<Integer> que = new ArrayDeque<>();
				for(int k = 11;k>=0;k--) {
					if(arr[k][j]!=0) {
						que.add(arr[k][j]);
						arr[k][j]=0;
					}
				}
				int count = 11;
				while(!que.isEmpty()) {
					arr[count--][j] = que.poll();
				}
			}
//			for(int r = 0;r<12;r++) {
//				System.out.println(Arrays.toString(arr[r]));
//			}
//			System.out.println();
		}

//		System.out.println(answer);
//		for(int r = 0;r<12;r++) {
//			System.out.println(Arrays.toString(arr[r]));
//		}
//		System.out.println();
		System.out.println(answer);
	}
}