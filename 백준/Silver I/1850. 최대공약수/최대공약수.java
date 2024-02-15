/*
 * 문제 
 * 1. 1로만 이루어진 수
 * 2. 1의 갯수가 입력
 * 
 * 풀이
 * 1. 1의 갯수 2개를 long으로 입력
 * 2. 두 수의 최대 공약수 구하기
 * 3. 최대 공약수의 갯수만큼 1출력
 * 
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = gcd(a,b);
		StringBuilder sb = new StringBuilder();
		for(long i = 0;i<c;i++) {
			sb.append(1);
		}
		System.out.println(sb);
	}
	
	private static long gcd(long a,long b) {
		if(a<b) {
			long temp = a;
			a = b;
			b = temp;
		}
		if(a%b==0) return b;
		return gcd(a%b,b);
	}
}