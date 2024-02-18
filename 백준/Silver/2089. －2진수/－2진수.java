/*
 * 문제
 * 1. 숫자가 주어짐
 * 2. -2진수로 바꾸기
 * 	2.1. (-2)^0 * a + ...
 * 
 * 풀이
 * 1. 숫자를 입력 받음
 * 2. -2로 나누기 나머지를 sb에 합치기
 * 3.                
 */
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N==0) {
			System.out.println(0);
			return;
		}
		StringBuilder sb = new StringBuilder();
		while(N!=1) {
			if(N<0) {
				sb.append(-N%2);
				N = N/-2 + (-N%2);
			}else {
				sb.append(N%2);
				N = N/-2;
			}
		}
		sb.append(1);
		System.out.println(sb.reverse());
	}
}