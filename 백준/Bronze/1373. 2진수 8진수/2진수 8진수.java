/*
 * 문제
 * 1. 2진수를 8진수로 변경
 * 
 * 풀이
 * 1. 숫자륾 문자열로 입력 받음
 * 2. 문자열을 reverse
 * 3. charAt으로 접근하여 돌기
 * 	3.1. 3자리 마다 2의 1,2,4를 곱하여 더하고 붙이기
 * 4. 끝나고 숫자가 0이 아니면 마저 붙이고 역순으로 바꿔서 출력
 * 
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		String temp = sc.next();
		if(temp.equals("0")) {
			System.out.println(0);
			return;
		}
		int tempL = temp.length();
		int count=0;
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<tempL;i++) {
			int a = temp.charAt(tempL-i-1)-'0';
			num += a * (int)Math.pow(2, count%3);
			if(count%3==2) {
				sb.append(num);
				num=0;
			}
			count++;
		}
		if(num!=0) {
			sb.append(num);
		}
		System.out.println(sb.reverse());
	}
}