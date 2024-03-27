/*
 * 문제
 * 1. 스도쿠 판이 존재
 * 2. 가로 , 세로, 3*3 에 중복 숫자 X
 * 3. 비어있는 스도쿠 판 채우기
 * 4. 여러개 가능시 가장 작은 숫자 출력
 * 
 * 풀이
 * 1. arr[9][9]생성, use[9][9] => arr복사 visited[9][9][10]
 * 2. for문 돌면서 0인칸 찾기  
 * 	2.1. for문 돌기 1~9
 * 		2.1.1. visited[i][j][k] continue
 * 		2.1.2. visited처리
 * 		2.1.3. use에서 가로 세로 3*3 확인
 * 		2.1.4. use[i][j]에 값 넣기
 * 3. use 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[][] use;
	public static void main(String[] args) throws Exception{
		arr = new int[9][9];
		use = new int[9][9];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0;i<9;i++) {
			String temp = br.readLine();
			for(int j = 0;j<9;j++) {
				arr[i][j] = temp.charAt(j)-'0';
			}
		}
		for(int i = 0;i<9;i++) {
			use[i] = arr[i].clone();
		}
		dfs(0);
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<9;i++) {
			for(int j = 0;j<9;j++) {
				sb.append(use[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static boolean dfs(int num) {
		int i = num/9;
		int j = num%9;
//		System.out.println(i+" "+j);
//		System.out.println(num);
//		for(int s = 0;s<9;s++) {
//			System.out.println(Arrays.toString(use[s]));
//		}
		if(arr[i][j]==0) {
			A : for(int k=1;k<=9;k++) {
				for(int l = 0;l<9;l++) {
					if(use[i][l]==k) continue A;
					if(use[l][j]==k) continue A;
//					System.out.println("k:" + k +" : " + (i/3+l/3) + " " +(j/3+l%3));
					if(use[(i/3)*3+l/3][(j/3)*3+l%3]==k) continue A;
				}
				use[i][j] = k;
				if(num==80) return true;
				if(dfs(num+1)) return true;
				use[i][j]=0;
			}
		}else {
			if(num==80) return true;
			if(dfs(num+1)) return true;
		}
		return false;
	}
}