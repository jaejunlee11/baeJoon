/*
 * 문제
 * 1. 숫자입력
 * 2. 팩토리얼 출력
 * 
 * 풀이
 * 1. N입력 받기
 * 2. 재귀함수 돌리기
 * 
 * 재귀함수
 * 1. 1이면 1출력
 * 2. 아닌 경우 recur(n-1)*n출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(recur(N));
	}
	public static int recur(int n) {
		if(n==0) return 1;
		if(n==1) return 1;
		return recur(n-1) * n;
	}
}