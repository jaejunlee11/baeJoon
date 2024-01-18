/*
 * 1. 배열 크기 및 연속 갯수 입력 받기
 * 2. 배열 입력 받기
 * 3. 배열을 순회하면서 연속의 합 계산 하기(N-k까지만)
 * 4. 최대값 출력
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//배열 크기
		int N = Integer.parseInt(st.nextToken());
		//연속 숫자
		int K = Integer.parseInt(st.nextToken());
		//배열 입력
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int[] arr = new int[N]; 
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		//최대값
		int maxNum =-100*N;
		for(int i = 0;i<N-K+1;i++) {
			int maxTemp = 0;
			for(int j = 0; j<K;j++) {
				maxTemp+=arr[i+j];
			}
			if(maxNum<maxTemp) maxNum = maxTemp;
		}
		System.out.println(maxNum);
	}
}