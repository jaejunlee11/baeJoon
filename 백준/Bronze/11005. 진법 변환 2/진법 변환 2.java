/*
 * 문제
 * 1. 10진법을36진법으로 바꾸기
 * 
 * 풀이
 * 1. N입력 받기
 * 2. B입력 받기
 * 3. N%B => 10이상인 경우 sb에 나머지값-10+'A' 아닌 경우 그냥 숫자 추가
 * 4. N/B => 0이 되는 경우 종료
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(N>0) {
			int temp = N%B;
			if(temp>=10) {
				sb.append((char)(temp-10+'A'));
			}else {
				sb.append(temp);
			}
			N = N/B;
		}
		System.out.println(sb.reverse());
	}
}