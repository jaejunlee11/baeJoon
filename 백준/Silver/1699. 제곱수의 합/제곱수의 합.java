/*
 * 문제
 * 1. N입력 받기 100000
 * 2. 제곱 수의 합으로 N 만들기
 * 3. 그중 원소 수가 최소인것 구하기
 * 풀이
 * 1. N+1 배열 만들기 arr
 * 2. arr[1] =1
 * 3. for문 돌기
 * 	3.1. k의 크기가 특정 수의 제곱 보다 큰 경우() => arr[k] = arr[k-특정수 제곱 값], ... + arr[k-1] 중 최소값 +1
 * 4. arr[k] 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		arr[1] = 1;
		for(int i = 2 ; i<=N;i++) {
			int min = Integer.MAX_VALUE;
			for(int j =1;j*j<=N;j++) {
				if(j*j<=i) {
					if(arr[i-j*j]<min) {
						min = arr[i-j*j];
					}
				}
			}
			arr[i] = min +1;
		}
		System.out.println(arr[N]);
	}
}