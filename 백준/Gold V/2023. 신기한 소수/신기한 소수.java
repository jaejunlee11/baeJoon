/*
 * 문제
 * 1. 한칸씩 확인하면서 전부 소수면 출력
 * 
 * 풀이
 * 1. N입력 받기
 * 2. 재귀 돌리기
 * 	2.1 . (1,2),(1,3),(1,5),(1,7)
 * 
 * 재귀 (depth, 값)
 * 0. 값이 소수인지 판단
 * 1. depht가 N이되면 값 출력
 * 2. for문 돌리기 (1,3,5,7,9)
 * 	2.1. 재귀(depth+1,값*10+i);
 * 
 * 소수 판단
 * 1. for(1~루트N)
 * 	1.1. 나머지가 0이면 false
 * 2.끝까지 오면 true
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		recur(1,2);
		recur(1,3);
		recur(1,5);
		recur(1,7);
		System.out.println(sb);
	}
	public static void recur(int depth,int num) {
		if(check(num)==false) return;
		if(depth==N) {
			sb.append(num+"\n");
			return;
		}
		for(int i = 1;i<10;i+=2) {
			recur(depth+1,num*10+i);
		}
	}
	
	public static boolean check(int num) {
		for(int i =3;i<=(int)Math.sqrt(num);i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}