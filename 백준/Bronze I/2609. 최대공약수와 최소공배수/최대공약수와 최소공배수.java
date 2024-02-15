/*
 * 문제
 * 1. 최대 공약수 최소 공배수 구하기
 * 
 * 풀이
 * 1. 숫자 A,B입력
 * 2. 최소 공약수 구하기
 * 	2.1. 함수 사용
 * 		2.1.1. 둘 중 큰 수를 작은 수로 나눔 -> 안나눠지면 나머지와 작은수를 다시 넣음
 * 		2.1.2. 나눠지면 작은 수가 최소 공약수
 * 3. 최소 공배수 구하기 -> 두수 곱 / 최소 공약수
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int withmul = gcd(A,B);
		System.out.println(withmul);
		System.out.println(A*B/withmul);
	}
	public static int gcd(int a, int b) {
		if(b>a) {
			int temp = a;
			a=b;
			b=temp;
		}
		if(a%b==0) return b;
		return gcd(a%b,b);
	}
}