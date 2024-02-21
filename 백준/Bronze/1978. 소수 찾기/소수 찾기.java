/*
 * 문제
 * 1. 소수 찾기
 * 
 * 풀이
 * 1. N 숫자 갯수가 주어짐
 * 2. for문돌기 -> 숫자가 주어짐
 * 3. 소수 확인 후 출력
 * 
 * 소수 확인 함수
 * 0. 1은 false 출력, 2는 true 출력
 * 1. 2로 나눈 나머지가 0이면 false 출력
 * 2. 3~sqrt(N)까지
 * 	2.1. 나머지가 없으면 false출력
 * 3. 끝까지 내려오면  true 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		for(int i = 0;i<N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(check(temp)) count++;
		}
		System.out.println(count);
	}
	private static boolean check(int temp) {
		if(temp==1) return false;
		if(temp==2) return true;
		if(temp%2==0) return false;
		for(int i =3;i<=(int) Math.sqrt(temp);i++) {
			if(temp%i==0) return false;
		}
		return true;
	}
}