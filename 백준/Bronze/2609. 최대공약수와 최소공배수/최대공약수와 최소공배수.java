/*
 * 문제
 * 1. 최대 공약수 구하기
 * 2. 최소 공배수 구하기
 * 
 * 풀이
 * 1. a,b 입력
 * 2. 최대 공약수 구하기
 * 3. a*b/최대 공약수 계산
 * 
 * 최대 공약수(a,b)
 * 1. a<b이면 a와 b 변경
 * 2. a%b==0이면 b 출력
 * 3. gcd(b,a%b)
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int k = gcd(a,b);
		System.out.println(k);
		System.out.println(a*b/k);
	}
	private static int gcd(int a, int b) {
		if(a<b) {
			int temp = a;
			a = b;
			b = temp;
		}
		if(a%b==0) return b;
		return gcd(b,a%b);
	}
}