/*
 * 문제
 * 1. M명의 조카 => 1000000
 * 2. N개의 과자 => 1000000
 * 3. 모두에게 같은 길이의 과자 제공
 * 
 * 풀이
 * 1. M, N입력
 * 2. arr[N]생성
 * 3. arr 입력 받기 
 * 4. 막대 길이 선택 => 이진탐색 돌리기  
 * 5. answer 출력
 * 
 * 이진 탐색
 * 1. start>end면 종료
 * 2. mid = start + end / 2
 * 3. for문 돌리기 => arr 순회
 * 	3.1. i / mid 의 합 구하기 
 * 4. 합이 M이상인 경우 => answer 갱신 후 recru(mid+1,end)
 * 5. 아닌 경우 recur(start,end-1)
 */
import java.io.*;
import java.util.*;

public class Main {
	static int M;
	static int N;
	static int[] arr;
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0 ;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		recur(1,1000000000);
		System.out.println(answer);
	}
	private static void recur(int start, int end) {
		if(start > end) return;
		int mid = (start+end)/2;
		int temp = 0;
		for(int i : arr) {
			temp += i/mid;
		}
//		System.out.println(temp);
		if(temp>=M) {
			answer = Math.max(answer, mid);
//			System.out.println(mid+" " +end);
			recur(mid+1,end);
		}else {
			recur(start,mid-1);
		}
	}
}