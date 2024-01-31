/*
 * 문제
 * 1.N M입력
 * 2. 중복 순열 출력
 * 
 * 풀이
 * 1. N,M 입력 받기(static)
 * 2. 배열 만들기 nums[N]
 * 2. 재귀돌기 (depth, start)
 * 
 * 재귀
 * 1. depth == M 이면 출력 후 종료
 * 2. for -> start 부터 N까지 돌리기
 * 	2.1. nums[depth] = i 
 * 	2.2. 재귀 돌리기 (depth +1, i)
 * 
 * 시간 복잡도
 * 1. M^N정
 */
import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int M;
	public static int[] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[M];
		recur(0,1);
	}
	public static void recur(int depth, int start) {
		if(depth == M) {
			for(int num : nums) {
				System.out.print(num+" ");
			}
			System.out.println();
			return;
		}
		for(int i =start;i<=N;i++) {
			nums[depth] = i;
			recur(depth+1,i+1);
		}
	}
}