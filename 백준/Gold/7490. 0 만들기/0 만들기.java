/*
 * 문제
 * 1. 1~N 숫자 존재
 * 2. +,-,공백 중 선택
 * 3. 0만드는 결과 출력
 * 
 * 풀이
 * 1. 테케 입력
 * 2. N입력
 * 3. 중복 순열로 +,-,공백 선택
 * 	3.1. 숫자 만들어서 공백으로 만들기
 * 
 * 중복 순열
 * 1. depth == N 이면
 * 	1.0. answer = 0 , temp = 1, cal = 0
 * 	1.1. for N-1 까지
 * 		1.1.1. picked[i] == 0 인 경우 => temp = temp *10 + i+2 
 * 		1.1.2. picked[i] == 1 인 경우
 * 			1.1.2.1. cal = 0인 경우 => answer += temp, temp = i+2, cal= 0
 * 			1,1.2.2. cal = 1인 경우 => answer -= temp, temp = i+2, cal =1
 * 		1.1.3. picked[i] == 2 인 경우 cal = 1로  
 * 	1.2. cal = 0 이면 answer += temp , 아니면 answer -= temp 
 * 	1.3. answer ==0 이면 출력 
 * 2. for(int i = 1;i<=3;i++)
 * 	2.1. picked[depth] = 3;
 * 	2.2. recur(depth+1);  
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] picked;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++) {
			N = Integer.parseInt(br.readLine());
			picked = new int[N];
			recur(0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void recur(int depth) {
		if(depth==N-1) {
			int answer = 0;
			int temp =1;
			int cal = 0;
			for(int i = 0;i<N-1;i++) {
				if(picked[i]==0) {
					temp = temp *10 + i+2;
				}else if(picked[i]==1) {
					if(cal == 0) {
						answer += temp;
						temp = i+2;
					}else {
						answer -= temp;
						temp = i+2;
					}
					cal = 0;
				}else {
					if(cal == 0) {
						answer += temp;
						temp = i+2;
					}else {
						answer -= temp;
						temp = i+2;
					}
					cal = 1;
				}
			}
			if(cal == 0) {
				answer += temp;
			}else {
				answer -= temp;
			}
			if(answer ==0) {
				sb.append("1");
				for(int i = 0;i<N-1;i++) {
					if(picked[i]==0) {
						sb.append(" "+(i+2));
					}else if(picked[i]==1) {
						sb.append("+"+(i+2));
					}else {
						sb.append("-"+(i+2));
					}
				}
				sb.append("\n");
			}
			return;
		}
		for(int i = 0;i<3;i++) {
			picked[depth]=i;
			recur(depth+1);
		}
	}
}