/*
 * 문제
 * 1. 설탕 5킬로, 3킬로 있음
 * 2. 킬로가 주어질 때 몇 봉지인지 구하기
 * 
 * 풀이
 * 1. N입력 받음 -> 4,7일때만 미리 처리
 * 2. N을 5로 나눈 나머지
 * 3. N을 5로 나눈 값
 * 4. 그리디 사용 -> 0이 될때 까지 +5, 3으로 나누기
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		if(N==4 || N == 7) {
			System.out.println(-1);
			return;
		}
		long sugar = N%5;
		long group = N/5;
		while(true) {
			if(sugar%3==0) {
				group += sugar/3;
				break;
			}
			sugar += 5;
			group --;
		}
		System.out.println(group);
	}
}