/*
 * 문제
 * 1. 랜선 K개 보유 -> 10000
 * 2. N개의 랜선 만들기 -> 1000000
 * 3. 랜선의 길이가 주어짐 -> int형 범위
 * 4. N개 랜선 만들었을 때 길이의 최대값 출력
 * 
 * 풀이
 * 1. K, N입력 받기 -> 부족한 갯수 구하기 => count
 * 2. arr[K]만들기 
 * 3. arr에 담으면서 최대값 구하기 -> maxL
 * 4. line[maxL]배열 만들기
 * 5. binarySearch(start,end);돌리기
 * 
 * binarySearch(start,end)
 * 0. start와 end가 동일하면 해당 값을 출력하며 종료
 * 1. 중간 값 기준으로 되는지 확인
 * 	1.1. 맞는 경우 -> binarySearch(start+end/2 +1,end)
 * 	1.2. 틀린 경우 -> binarySearch(start,start+end/2)
 * 
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int N;
	static long maxV;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];
		int maxValue= 0;
		for(int i = 0;i<K;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			maxValue = Math.max(maxValue, arr[i]);
		}
		maxV = 0;
		binarySearch(1,maxValue);
		System.out.println(maxV);
	}
	public static void binarySearch(long start,long end) {
		if(start>end) return;
		long mid = (start+end)/2;
		int sum = 0;
		for(int i : arr) {
			sum +=i/mid;
		}
		if(sum>=N) {
			maxV = Math.max(maxV, mid);
			binarySearch(mid+1,end);
		}else {
			binarySearch(start,mid-1);
		}
	}
}