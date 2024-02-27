/*
 * 문제
 * 1. N!의 뒤에서 부터 0의 갯수 구하기
 * 2. 10^n * A = N!일때 n구하기랑 동일
 * 
 * 풀이
 * 1. N입력 받기
 * 2. 재귀 돌기
 * 
 * 재귀 -> 2의 갯수, 5의 갯수, n
 * 1. n==1일때 2,5중 최소값 출력
 * 2. n을 2와 5로 나누면서 갯수 구하기
 * 3. return recur(원래값 + 구한값,원래값 + 구한값,n-1)
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int two = 0;
		int five = 0;
		if(N==0) {
			System.out.println(0);
			return;
		}
		while(true) {
			if(N==1) {
				System.out.println(Math.min(two, five));
				return;
			}
			int n = N;
			while(true) {
				if(n==0) break;
				if(n%2==0) {
					n = n/2;
					two++;
					continue;
				}
				if(n%5 == 0) {
					n = n/5;
					five++;
					continue;
				}
				break;
			}
			N--;
		}
	}
}