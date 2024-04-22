/*
 * 문제
 * 1. 상자들이 존재
 * 2. 무조건 밑면으로 둬야함
 * 3. 무게가 무거운 것을 아래로, 밑면이 좁은 것을 아래로
 * 4. 최대한 높이 쌓기
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N][4]생성
 * 3. arr입력
 * 4. dp[N][4]생성
 * 5. arr[N][1]을 기준으로 정렬, maxHeight = 0
 * 6. for문 돌기 => N
 * 	6.1. for문 돌기 => i-1~0까지
 * 		6.1.0. dp[i][1] = arr[3], dp[i][3] = arr[0]
 * 		6.1.1. dp[j][1]>=arr[3] && dp[i][0]<dp[j][0]+arr[2]인 것
 * 			6.1.1.1. dp[i][0] = dp[j][0] + arr[2]
 * 			6.1.1.2. dp[i][2] = dp[j][3]
 * 			6.1.1.3. maxHeight 갱신
 * 7. for문 돌기 N~0까지, sb생성, count생성 =0, next = 0
 * 	7.1. maxHeight == dp[i][0] => sb.append(dp[i][3]), count++,next=dp[i][2]
 * 	7.2. count>=1일때 , next==dp[i][3] => sb.append(dp[i][3]), count++,next=dp[i][2]
 * 		7.2.1. next==0이면 종료
 * 8. count 출력
 * 9.sb출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][4];
		int[][] dp = new int[N][4];
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = i+1;
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,(o1,o2)->o2[1]-o1[1]);
//		for(int i = 0;i<N;i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		int maxHeight = 0;
		for(int i = 0;i<N;i++) {
				dp[i][0] = arr[i][2];
				dp[i][1] = arr[i][3];
				dp[i][3] = arr[i][0];
			for(int j = i-1;j>=0;j--) {
				if(dp[j][1]>=arr[i][3] && dp[i][0]<dp[j][0]+arr[i][2]) {
					dp[i][0] = dp[j][0]+arr[i][2];
					dp[i][2] = dp[j][3];
				}
			}
			maxHeight = Math.max(dp[i][0], maxHeight);
		}
//		for(int i = 0;i<N;i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
//		System.out.println(maxHeight);
		StringBuilder sb = new StringBuilder();
		int count = 0;
		int next = -1;
		for(int i =N-1;i>=0;i--) {
			if(count==0) {
//				System.out.println(dp[i][0]+" "+i+" "+maxHeight);
				if(dp[i][0]==maxHeight) {
					count++;
					sb.append(dp[i][3]+"\n");
					next = dp[i][2];
				}
			}else {
				if(next==dp[i][3]) {
					count++;
					sb.append(dp[i][3]+"\n");
					next = dp[i][2];
				}
			}
			if(next==0) break;
		}
		System.out.println(count);
		System.out.println(sb);
	}
}