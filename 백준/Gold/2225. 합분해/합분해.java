/*
 * 문제
 * 1. N ,K입력 -> N은 1~200, K는 1~200
 * 2. 0~N을 K개 사용해서 N만들기
 * 
 * 풀이 -> 공(구분이 없는) N개가 있고 이를 K개의 방에 넣는 느낌 -> 중복 조합 -> N+K-1 C K-1
 * 1. N,K입력 받기
 * 2. arr[N+1][K+1]배열 만들기
 * 3. N = 1, K=x일때 => x
 * 4. N = x, k=1일때 => 1 
 * 5. N = 2, k=2일때 => 02 20 11 =>3 (1,1) + (1,2) 
 * 6. N = 3, k=2일때 => 03 30 21 12 =>4 (3,1) + (2,2)
 * 7. N = 4, k=2일때 => 04 40 13 31 22=>5 (4,1) + (3,2) ??
 * 8. N = 2, k=3일때 => 002 020 200 110 011 101 =>6 (2,2) + (1,3)
 * 9. N = x, k=y일때 => (x,y-1) + (x-1,y) =>조합인듯?
 * 
 * 고려해야할 것
 * 1. 공식으로 연산을 때려버리면 팩토리얼 때문에 메모리 초과가 남
 * 2. 팩토리얼 공식이 아니라 중단 점을 미리 만들어 줘야할 듯
 * 
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		BigInteger answer = upfactorial(BigInteger.valueOf(N+K-1),K-1).divide(factorial(BigInteger.valueOf(N)));
		System.out.println(answer.remainder(BigInteger.valueOf(1000000000)));
	}
	static BigInteger factorial(BigInteger a) {
		if(a.compareTo(BigInteger.ONE)==0) {
			return BigInteger.ONE;
		}
		return a.multiply(factorial(a.subtract(BigInteger.ONE)));
	}
	
	static BigInteger upfactorial(BigInteger a, int k) {
		if(a.compareTo(BigInteger.valueOf(k))==0) {
			return BigInteger.ONE;
		}
		return a.multiply(upfactorial(a.subtract(BigInteger.ONE),k));
	}
}