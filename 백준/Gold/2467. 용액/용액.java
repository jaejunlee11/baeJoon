/*
 * 문제
 * 1. 용액 배열 존재
 * 2. 용액 중에서 2개 선택
 * 3. 두 용액의 합이 0에 가장 가까운 값 찾기
 * 
 * 아이디어
 * 1. 숫자 입력
 * 2. 이분 탐색을 통해서 -(해당 값 찾기)
 * 3. 해당값 + 고른값  => 절대값의 최소값으로 갱신 
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N]생성
 * 3. arr입력
 * 4. for문 돌리기	 => min = Integer.MIN
 * 	4.0. pos값 -1로 설정 
 * 	4.1. -arr[i]을 통해서 이분 탐색
 * 	4.2. a = arr[pos]+arr[i], b = arr[pos+1] + arr[i]
 * 	4.3. abs(a)<abs(b) => abs(a)<min => min갱신, x = arr[pos],y = arr[i]
 * 	4.4. abs(a)>abs(b) => abs(b)<min => min갱신, x = arr[pos+1], y = arr[i]
 * 5.x<y => x y 출력 아니면 반대로 출
 * 
 * 이분 탐색(start, end, my)
 * 1. start>end => 종료
 * 2. mid = start+end /2
 * 3. arr[mid]<my => pos = max(mid,pos) 이분 탐색(mid+1,end, my)
 * 4. arr[mid]>=my => 이분 탐색(start,mid-1,my)
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int pos;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		int answer1 = 0;
		int answer2 = 0;
		if(arr[0]>0) {
			System.out.println(arr[0]+" " + arr[1]);
			return;
		}
		if(arr[N-1]<0) {
			System.out.println(arr[N-2] + " " + arr[N-1]);
			return;
		}
		for(int i =0 ;i<N;i++) {
			pos = -1;
			if(arr[i]>0) break;
			recur(0,N-1,-arr[i]);
//			System.out.println(pos);
			int a = arr[pos] + arr[i];
			if(pos+1>=N) {
				if(Math.abs(a)<min) {
					answer1 = arr[pos];
					answer2 = arr[i];
					min = Math.abs(a);
				}
				continue;
			}
			int b = arr[pos+1] + arr[i];
			if(Math.abs(a)<Math.abs(b) && i!=pos) {
				if(Math.abs(a)<min) {
					answer1 = arr[pos];
					answer2 = arr[i];
					min = Math.abs(a);
				}
			}else if(i != (pos+1)){
				if(Math.abs(b)<min) {
					answer1 = arr[pos+1];
					answer2 = arr[i];
					min = Math.abs(b);
				}
			}
		}
		if(answer1>answer2) {
			System.out.println(answer2 + " " + answer1);
		}else {
			System.out.println(answer1 + " " + answer2);
		}
	}
	private static void recur(int start, int end , int my) {
		if(start>end) return;
		int mid = (start + end)/2;
		if(arr[mid]<my) {
			pos = Math.max(pos, mid);
			recur(mid+1,end,my);
		}else {
			recur(start,mid-1,my);
		}
	}
}