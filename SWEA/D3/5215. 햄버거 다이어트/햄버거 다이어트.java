/*
 * 문제
 * 1. 테케입력
 * 2. N L 입력-> N=20이하 재료수 , L=10000이하 칼로리제한
 * 3. T K 입력 -> 맛, 칼로리 1000이하
 * 4. 맛 최대 칼로리 제한 안넘게 만들기
 * 
 * 풀이 
 * 0. N(static), L(static), picked[](static), arr[][] (satic)
 * 1. 테케 입력
 * 2. N L 입력 => 리스트 만들기 arr[N][2]
 * 3. arr[i][0] -> 맛, arr[i][1] -> 칼로리 =>입력
 * 4. 재귀 돌리기(부분 집합) -> (depth)
 * 
 * 재귀
 * 1. depth == N -> picked 순회-> 칼로리 총합, 맛 총합 => 칼로리 괜찮으면 맛 업데이트
 * 2. picked[] = true;재귀 false 재귀
 * 
 * 생각할 것
 * 1. 형 -> int로 충분
 * 
 * 시간 복잡도
 * 1. 2^20 *22*20 정도 => 4억 정도 충분
 */
import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int L;
	static boolean picked[];
	static int[][] arr;
	static int anser = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case =1 ; test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][2];
			picked = new boolean[N];
			for(int i = 0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			anser = Integer.MIN_VALUE;
			recur(0);
			System.out.println("#"+test_case + " "+anser);
		}
	}
	
	static void recur(int depth) {
		if(depth==N) {
			int tempCal = 0;
			int tempPoint = 0;
			for(int i = 0;i<N;i++) {
				if(picked[i]) {
					tempPoint+=arr[i][0];
					tempCal +=arr[i][1];
				}
			}
			if(tempCal<=L) {
				anser=Math.max(anser, tempPoint);
			}
			return;
		}
		
		picked[depth]=true;
		recur(depth+1);
		picked[depth]=false;
		recur(depth+1);
	}
}