import java.io.*;
import java.util.*;
/*
 * 문제
 * 1. 64막대 존재
 * 2. x막대 만들기
 * 3. 막대들 중 가장 짧은거 절반으로 자르기
 * 4. 해당 길이를 뺐을때 x보다 크면 해당 막대 제거
 * 5. 반복해서 언제 x가 되는지 구하기
 * 
 * 풀이
 * 0. x, short = 64, sum = 64
 * 1. while문 돌리기
 * 	1.0 count++
 * 	1.1. short = short/2
 * 	1.2. sum-short==x => break
 * 	1.3. sum-short>x => sum = sum -short
 * 2. count 출
 */

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int count = 0;
		int sub = 0;
		int sum = 64;
		int stick = 64;
		if(x==64) {
			System.out.println(1);
			return;
		}
		while(true) {
			count++;
			stick = stick/2;
			if(sum-stick==x) {
				break;
			}
			if(sum-stick>x) {
				sum-=stick;
				sub++;
			}
//			System.out.println(sum);
		}
		System.out.println(count-sub);
	}
}