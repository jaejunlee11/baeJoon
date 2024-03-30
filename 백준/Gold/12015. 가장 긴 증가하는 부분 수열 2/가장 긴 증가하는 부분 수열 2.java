/*
 * 문제
 * 1. 크기가 증가하는 부분 순열 만들기
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N]생성
 * 3. arr입력
 * 4. dp[N]생성 ,length = 0
 * 5. for문돌기 => N까지
 * 	5.1. 이분 탐색으로 해당 값 보다 더 큰 값 중 가장 큰 값의 pos구하기 
 * 	5.2. 더 큰 값의 위치 +1 이 0인 경우 length 증가	
 * 	5.3. 숫자인 경우 그냥 해당 자리에 값 넣기 
 * 6. length 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[] dp;
	static int[] arr;
	static int pos;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int length=1;
		dp[0]=arr[0];
		for(int i = 1;i<N;i++) {
			pos = -1;
			recur(arr[i],0,length-1);
			if(dp[pos+1]==0) {
				length++;
				dp[pos+1] = arr[i];
			}else {
				dp[pos+1] = arr[i];
			}
		}
		System.out.println(length);
	}
	private static void recur(int my, int start,int end) {
		if(end<start) return;
		int mid = (start+end)/2;
		if(dp[mid]<my) {
			pos = Math.max(pos, mid);
			recur(my,mid+1,end);
		}else if(dp[mid]>my){
			recur(my,start,mid-1);
		}else {
			pos = mid-1;
			return;
		}
	}
}