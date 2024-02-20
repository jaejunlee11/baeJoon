/*
 * 문제
 * 1. N일까지의 상담 일자와 돈이 있음
 * 2. 상담을 하게 되면 더 이상 그 다음 날짜들은 선택을 못 함
 * 3. 최고 금액
 * 
 * 풀이
 * 1. N을 입력 받음
 * 2. 배열 생성 arr[N][2]
 * 3. 부분 집합 돌리기 
 * 
 * recur(int depth)
 * 1. depth==10인 경우
 * 	1.1. for문 돌리기 10개 -> count = 0
 * 		1.1.1. true인 친구의 비용 count에 더해주기	
 * 		1.1.2. true인 친구의 면담일 수-1 만큼 다음 picked값이 fals가 맞는지 확인(상한이 넘어가도) -> 아니면 return
 * 	1.2. 최대값 갱신 후 return 
 * 2. picked[depth] = true
 * 3. recur(depth+1)
 * 4. picked[depth]
 * 5. recur(depth+1)
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] picked;
	static int maxValue = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		picked = new boolean[N];
		for(int i =0 ;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		recur(0);
		System.out.println(maxValue);
		
	}
	static void recur(int depth) {
		if(depth==N) {
			int count = 0;
			for(int i =0 ;i<N;i++) {
				if(picked[i]) {
					count += arr[i][1];
					if((arr[i][0] + i)>N) return;
					for(int j = 1;j<arr[i][0];j++) {
						if(picked[i+j]) return;
					}
				}
			}
			maxValue = Math.max(maxValue, count);
			return;
		}
		picked[depth] = true;
		recur(depth+1);
		picked[depth]=false;
		recur(depth+1);
	}
}