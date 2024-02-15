/*
 * 문제
 * 1. 최대 공약수 최소 공배수 구하기
 * 
 * 풀이
 * 1. 숫자 A,B입력
 * 2. 최소 공약수 구하기
 * 3. 최소 공배수 구하기 -> 두수 곱 / 최소 공약수
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int withmul =0;
		for(int i = Math.min(A, B);i>0;i--) {
			if(A%i==0 && B%i==0) {
				withmul = i;
				break;
			}
		}
		System.out.println(withmul);
		System.out.println(A*B/withmul);
	}
}