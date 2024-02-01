/*
 * 문제
 * 1. 테케 입력
 * 2. N,M입력 ->과자 종류 (최대 1000), 최대 무게
 * 3. 과자 무게들 입력
 * 4. 과자 무게의 합이 M이하가 되도록 선택
 * 
 * 풀이 
 * 0. 고른 과자 picked[2] (static), arr[] (static) ,N(static), M(static)
 * 1. 테케 입력 T
 * 2. N,M 입력 
 * 3. 배열 arr[N]생성
 * 4. 재귀 돌기 (depth, start)
 * 
 * 재귀
 * 1. depth가 2인경우 -> picked 2개 확인 M이 안넘으면 최대값 갱신
 * 2. for돌기 start 부터 N까지
 * 3. 재귀 -> (depth+1, start+1)
 * 
 * 고려할 것
 * 1. 형 ->M이 1000000까지라 괜찮
 * 
 * 시간 초과
 * 1. 1000 * 1000 * 2 * 273 => 500000000 어려울 수도 
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int M;
	static int[] picked = new int[2];
	static int[] arr;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1 ; test_case<=T;test_case++) {
			max = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr= new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			recur(0,0);
			System.out.println("#"+test_case+" "+max);
		}
		
	}
	static void recur(int depth,int start) {
		if(depth==2) {
			int temp = arr[picked[0]]+arr[picked[1]];
			if(temp<=M) {
				if(max<temp) max = temp;
			}
			return;
		}
		for(int i = start;i<N;i++) {
			picked[depth] = i;
			recur(depth+1,i+1);
		}
	}
}