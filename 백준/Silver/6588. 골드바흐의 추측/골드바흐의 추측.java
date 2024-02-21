/*
 * 문제
 * 1. 숫자가 주어질 때 해당 숫자를 두 소수의 합으로 만들 수 있는 조합 출력
 * 2. a가 가장 작은 것으로
 * 
 * 풀이 
 * 1. T 입력
 * 2. 숫자 n이 주어짐
 * 3. 2~n/2까지 소수 판단
 * 	3.1. 소수인 숫자들 중 n-a도 소수인 것을 출력
 * 4. 모두 탐색해서 없으면 "Goldbach's conjecture is wrong." 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] primes = new boolean[1000001];
		primes[1]= true;
		for(int i = 2;i<=(int)Math.sqrt(1000000);i++) {
			int k = 2;
			while(k*i<=1000000) {
				primes[k*i]=true;
				k++;
			}
		}
		A : while(true){
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			for(int i = 2;i<=N/2;i++) {
				if(primes[i]==false) {
					if(primes[N-i]==false) {
						sb.append(N+" = "+i+ " + " + (N-i)+"\n");
						continue A;
					}
				}
			}
			sb.append("\"Goldbach's conjecture is wrong.\"\n");
		}
		System.out.println(sb);
	}
	static boolean check(int N) {
		if(N==1) return false;
		if(N==2) return true;
		if(N%2==0) return false;
		for(int i = 3;i<=(int)Math.sqrt(N);i++) {
			if(N%i==0) return false;
		}
		return true;
	}
}