/*
 * 문제
 * 1. 숫자 입력
 * 2. 소인수 분해
 * 3. 출력
 * 
 * 풀이
 * 1. N입력 받기
 * 2. 2~N 중 나머지가 0인 값 찾기
 * 	2.1. 소수인 경우 나누기 -> 나눠지는 값을 출력
 * 3. 1이되면 종료
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A : while(N>1) {
			for(int i = 2;i<=N;i++) {
				if(N%i==0) {
					if(check(i)) {
						N = N/i;
						System.out.println(i);
						continue A;
					}
				}
			}
		}
	}
	public static boolean check(int n) {
		if(n==2) return true;
		if(n%2==0) return false;
		for(int i = 3;i<(int)Math.sqrt(n);i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}