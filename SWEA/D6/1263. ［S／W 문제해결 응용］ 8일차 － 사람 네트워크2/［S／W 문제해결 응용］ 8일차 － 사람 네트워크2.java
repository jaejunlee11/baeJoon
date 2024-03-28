/*
 * 문제
 * 1. 사람들이 존재
 * 2. 각 사람들이 연결
 * 3. 사람을 걸치면 거리가 1 증가
 * 4. 모든 사람들이랑 연결되는데 필요한 거리의 합 계산
 * 5. 해당 거리의 합들의 최소 값은?
 * 
 * 풀이
 * 1. 테케 입력
 * 2.  N입력
 * 3. arr[N][N]생성
 * 4. arr채우기 => arr순회 => arr[i][j]==1
 * 5. for문 돌기 N k
 * 	5.1. for문 돌기 N i
 * 		5.1.1. for문 돌기 N j
 * 			5.1.1.0. 
 * 			5.1.1.1. arr[i][k], arr[k][j] 둘중하나가 0인 경우 => tmep1 = Integer.max 아닌 경우 temp1 = arr[i][k]+arr[k][j]
 * 			5.1.1.2. arr[i][j]가 0인 경우 => temp2 = Integer.max 아닌 경우 temp2 = arr[i][j]
 * 			5.1.1.1. arr[i][j] = min(temp1,tmep2) => 해당값이 Integer.max면 0으로 만들기 
 * 6. for문 돌리기 => answer = max
 * 	6.1. for문 돌리기 => arr[i][j]의 합 => answer갱신
 * 7. 출력 
 */
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for(int i =0 ;i<N;i++) {
				for(int j = 0;j<N;j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp==0) arr[i][j] = 1001;
					else arr[i][j]= temp;
				}
			}
			for(int k = 0;k<N;k++) {
				for(int i = 0;i<N;i++) {
					for(int j = 0;j<N;j++) {
						if(i==j) continue;
						arr[i][j] = Math.min(arr[i][k]+arr[k][j], arr[i][j]);
					}
				}
			}
			int answer = Integer.MAX_VALUE;
			for(int i = 0;i<N;i++) {
				int temp = 0;
				for(int j = 0;j<N;j++) {
					if(i==j) continue;
					temp += arr[i][j];
				}
				answer = Math.min(temp, answer);
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb);
	}
}