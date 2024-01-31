/*
 * 문제
 * 1. 나선 모양으로 삼각형 추가
 * 2. 삼각형의 최대 길이 구하기
 * 풀이
 * 1. 테케 입력
 * 2. N입력 -> N이 6 이하면 하드 코딩으로 출력
 * 3. 7이상이면 배열 생성
 * 4. 1,2,3,4,5,6 하드 입력
 * 5. N일때 arr[N] = arr[N-5] + arr[N-1] 
 * 6. arr[N] 출력
 * 
 * 체크리스트
 * 1. 변수 타입
 * 2. 오버플로우
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] arr = new long[101];
		
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		int T = Integer.parseInt(br.readLine());
		int[] question = new int[T];
		int max = Integer.MIN_VALUE;
		for(int test_case = 0 ;test_case<T;test_case++) {
			int N = Integer.parseInt(br.readLine());
			question[test_case] = N;
			if(max<N) max = N;
		}
		for(int i = 6;i<=max;i++) {
			arr[i] = arr[i-5] + arr[i-1];
		}
		for(int t : question) {
			System.out.println(arr[t]);
		}	
	}
}