/*
 * 문제
 * 1. N*N체스판에 N개의 퀸이 서로 공격 못하게 만들기 -> 15
 * 2. 가능한 방법의 숫자 세기
 * 
 * 풀이
 * 1. N입력 받기
 * 2. N*N 판 만들기
 * 3. 백트랙킹
 * 4. count 출력
 * 
 * 백트랙킹
 * 1. depth가 N이면 count상승 후 리턴
 * 2. 2중 for문을 돌면서 퀸이 없으면 놓기
 * 	2.1. 판에 가로 세로 대각이 겹치는 것이 있으면 놓지 말고 다음으로
 * 	2.2. 겹치는 것이 없으면 다시 백트랙킹 호출
 */
import java.io.*;
import java.util.*;
public class Main {
	static int[][] arr;
	static int count = 0;
	static int N ;
	static int[] queens;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		queens = new int[N];
		for(int i = 0 ;i< N;i++) {
			queens[i] = -1;
		}
		back(0,0,0);
		System.out.println(count);
	}
	
	public static void back(int depth,int nr,int nc) {
		if(depth == N) {
			count++;
//			System.out.println(count);
			return;
		}
		for(int i = nr ;i<N;i++) {
			if(depth!=i) return;
			A : for(int j = nc ;j<N;j++) {
//				System.out.println(i+" "+j);
				for(int k = 0;k<depth;k++) {
					if(queens[k]==j) continue A;
					if(Math.abs(queens[k]-j)==Math.abs((k-i))) continue A;
				}
				queens[depth] = j;
//				System.out.println(Arrays.toString(queens));
				back(depth+1,i+1,0);
				queens[depth] = -1;
			}
		}
	}
}