import java.io.*;
import java.util.*;
/*
 * 문제
 * 1. A, B,C,D가 주어
 * 2. A/B + C/D의 값의 기약분수 구하
 * 
 * 풀이
 * 1. A,B, C, D입력
 * 2. down = B * D
 * 3. up = A*D + B * C
 * 4. up, down의 최소 공약수 구하기
 * 5. up/gcd, down/gcd 출력
 */

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		long down = b * d;
		long up = a * d + b * c;
		long cal = gcd(down,up);
		System.out.println(up/cal + " " + down/cal);
	}
	private static long gcd(long a, long b) {
		if(a>b) {
			long temp = a;
			a = b;
			b = temp;
		}
		if(b%a==0) return a;
		return gcd(b%a,a);
	}
}