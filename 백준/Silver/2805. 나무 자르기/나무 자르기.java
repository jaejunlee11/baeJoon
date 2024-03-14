/*
 * 문제
 * 1. 나무 길이가 주어짐
 * 2. 자를 높이를 결정
 * 3. M의 나무를 최대한 맞춰서 가져가기
 * 
 * 풀이
 * 1.N,M입력
 * 2.arr[N]생성
 * 3. arr[N]채우기
 * 4. 이분탐색 실행
 * 
 * 이분탐색(start,end)
 * 1. start>=end시 종료
 * 2. mid = start+end /2
 * 3. mid값으로 닶이 맞는지 확인
 * 	3.1. arr순회 => sum += max(arr[i]-mid,0)
 * 	3.2. 답이 맞는 경우 => answer 갱신(더 작은것), 이분탐색(start,mid-1)
 * 	3.3. 답이 틀린 경우 => 이분탐색(mid+1,end)
 */
import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static long M;
	static long[] arr;
	static long answer = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		recur(0,Integer.MAX_VALUE);
		System.out.println(answer);
	}
	static void recur(long start, long end) {
		if(start>end) return;
		long mid = (start + end) / 2;
		long temp = 0;
		for(int i = 0;i<N;i++) {
			temp += Math.max(arr[i]-mid, 0);
		}
		if(temp>=M) {
			answer = Math.max(answer, mid);
			recur(mid+1,end);
		}else {
			recur(start,mid-1);
		}
	}
}