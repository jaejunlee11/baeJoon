/*
 * 문제
 * 1. 지도에 방향이 존재
 * 2. 해당 방향으로 사람들이 이동
 * 3. 최소 갯수의 safe존으로 모두 안전 구역으로 이동
 * 
 * 풀이
 * 1. N,M입력
 * 2. arr[N][M]생성
 * 3. arr 채우기
 * 4. for문 돌기 모든 arr ,count=0, answer=0으로 시작
 * 	4.1. visited가 0이 아니면 continue
 * 	4.2. visited count++ 넣기
 * 	4.3. 해당 방향으로 이동
 * 	4.4. 끝까지 가서 현재 count를 만난 경우 answer++
 * 	4.5. 도중에 다른 count를 만난 경우 그냥 종료 
 * 5. answer출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		for(int i = 0;i<N;i++) {
			String temp = br.readLine();
			for(int j = 0;j<M;j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		int[][] visited = new int[N][M];
		int count = 0;
		int answer = 0;
		for(int i = 0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(visited[i][j]!=0) continue;
				count++;
				int r =i;
				int c = j;
				while(true) {
					visited[r][c] = count;
					int nr = r;
					int nc = c;
					if(arr[r][c]=='D') nr++;
					if(arr[r][c]=='L') nc--;
					if(arr[r][c]=='U') nr--;
					if(arr[r][c]=='R') nc++;
					if(visited[nr][nc]==count) {
						answer++;
						break;
					}else if(visited[nr][nc]!=0 && visited[nr][nc]!=count) {
						break;
					}
					r = nr;
					c= nc;
				}
			}
		}
		System.out.println(answer);
	}
}