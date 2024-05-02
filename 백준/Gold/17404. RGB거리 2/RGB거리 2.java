import java.io.*;
import java.util.*;
/*
 * 문제
 * 1. RGB거리 존재
 * 2. 1번은 2번, N번 과 색이 다름
 * 3. 2번은 부터는 양옆과 색이 다름
 * 4. N번은 1번과 바로 전집과 색이 다름
 * 5. 색칠 최소값 구하기
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N][3]생성
 * 3. arr 입력
 * 4. N==2인 경우 => 판단 후 종료
 * 5. dp1[N][3], dp2[N][3], dp3[N][3] 생성
 * 6. dp1[0][0] ... 채우기
 * 7. dp1[1][0] = 10000, dp1[1][1] = dp1[0][0] + 값, dp1[1][2] = dp1[0][0] + 값 으로 시작 
 * 8. for문 돌리기 2~N-1
 * 	8.1. dp1[N-1][1], dp1[N-1][2] 중 최소값 answer
 * 9. dp2반복 => answer 갱신
 * 10 dp3반복 => answer 갱신
 * 11. answer 출력
 */
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		for(int i =0 ;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		if(N==2) {
			int a = Math.min(arr[0][1], arr[0][2]) + arr[1][0];
			int b = Math.min(arr[0][0], arr[0][2]) + arr[1][1];
			int c = Math.min(arr[0][1], arr[0][0]) + arr[1][2];
			int answer = Math.min(a, b);
			answer = Math.min(answer, c);
			System.out.println(answer);
			return;
		}
		int[][] dp1 = new int[N][3];
		int[][] dp2 = new int[N][3];
		int[][] dp3 = new int[N][3];
		dp1[1][0] = 10000;
		dp1[1][1] = arr[0][0] + arr[1][1];
		dp1[1][2] = arr[0][0] + arr[1][2];
		
		dp2[1][0] = arr[0][1] + arr[1][0];
		dp2[1][1] = 10000;
		dp2[1][2] = arr[0][1] + arr[1][2];
		
		
		dp3[1][0] = arr[0][2] + arr[1][0];
		dp3[1][1] = arr[0][2] + arr[1][1];
		dp3[1][2] = 10000;
		
		for(int i = 2;i<N;i++) {
			dp1[i][0] = Math.min(dp1[i-1][1], dp1[i-1][2]) + arr[i][0];
			dp1[i][1] = Math.min(dp1[i-1][0], dp1[i-1][2]) + arr[i][1];
			dp1[i][2] = Math.min(dp1[i-1][1], dp1[i-1][0]) + arr[i][2];
			
			dp2[i][0] = Math.min(dp2[i-1][1], dp2[i-1][2]) + arr[i][0];
			dp2[i][1] = Math.min(dp2[i-1][0], dp2[i-1][2]) + arr[i][1];
			dp2[i][2] = Math.min(dp2[i-1][1], dp2[i-1][0]) + arr[i][2];
			
			dp3[i][0] = Math.min(dp3[i-1][1], dp3[i-1][2]) + arr[i][0];
			dp3[i][1] = Math.min(dp3[i-1][0], dp3[i-1][2]) + arr[i][1];
			dp3[i][2] = Math.min(dp3[i-1][1], dp3[i-1][0]) + arr[i][2];
		}
		
		int answer = Math.min(dp1[N-1][1], dp1[N-1][2]);
		answer = Math.min(answer, dp2[N-1][0]);
		answer = Math.min(answer, dp2[N-1][2]);
		answer = Math.min(answer, dp3[N-1][0]);
		answer = Math.min(answer, dp3[N-1][1]);
		System.out.println(answer);
	}
}