/*
 * 문제
 * 1. 8진수 -> 2진수
 * 
 * 풀이
 * 1. 숫자 입력 받기
 * 2. 숫자가 0이 될때 까지 돌기
 * 	2.1. 나머지를 sb에 추가
 * 	2.2. 2로 나누기
 * 3. sb리버스해서 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		if(N.equals("0")) {
			System.out.println(0);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = N.length()-1;i>0;i--) {
			long temp = N.charAt(i)-'0';
			for(int j = 0;j<3;j++) {
				sb.append(temp%2);
				temp = temp/2;
			}
		}
		long temp = N.charAt(0)-'0';
		while(temp>0) {
			sb.append(temp%2);
			temp = temp/2;
		}
		System.out.println(sb.reverse());
	}
}