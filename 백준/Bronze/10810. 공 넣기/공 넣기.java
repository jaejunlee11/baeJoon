/*
 * 문제
 * 1. 1~ N번 공 존재
 * 2. 바구니에 공 넣기 -> 이미 있는 경우 공을 꺼내고 공 넣기
 * 
 * 풀이
 * 1. N ,M입력 => arr[N+1]생
 * 2. i,j,k입력 -> arr[i]~arr[j]까지k로 변경
 * 3. arr[1~N]까지 값 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for(int j = a ; j<=b;j++) {
				arr[j]=k;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<=N;i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);
	}
}