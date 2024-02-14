/*
 * 문제
 * 1. 01이 있음
 * 2. N*N에 있으면 1개로 압축 가능
 * 3. 압축 안되면 ()안에 표현
 * 4. 결과 출력
 * 
 * 풀이
 * 1. N*N이 전부 동일한지 확인 -> 동일하면 해당 값 출력
 * 2. 아닌 경우 (열고 4분할 -> N==1이면 그냥 해당 값 출력
 * 	2.1. N/2 * N/2가 전부 동일한지 확인 -> 반복
 * 	2.2.끝난 경우 )닫기
 * 
 * 시간 복잡도
 * 1. 64*64 *6번 => 충분 한듯
 */
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr=new int[N][N];
		for(int i = 0;i<N;i++) {
			String temp = br.readLine();
			for(int j = 0;j<N;j++) {
				arr[i][j] = temp.charAt(j)-'0';
			}
		}
		recur(N,0,0);
		System.out.println(sb);
	}
	
	public static void recur(int tempK,int r,int c) {
//		if(tempK==1) sb.append(arr[r][c]);
		boolean flag = true;
		A : for(int i = r;i<tempK+r;i++) {
			for(int j = c;j<tempK+c;j++) {
				if(arr[r][c]!=arr[i][j]) {
					flag=false;
					break A;
				}
			}
		}
		if(flag) {
			sb.append(arr[r][c]);
		}else {
			sb.append("(");
			recur(tempK/2,r,c);
			recur(tempK/2,r,c+tempK/2);
			recur(tempK/2,r+tempK/2,c);
			recur(tempK/2,r+tempK/2,c+tempK/2);
			sb.append(")");
		}
	}
}