/*
 * 문제
 * 1. 테케 입력 받기
 * 2. ()입력 받기
 * 3. ()짝이 맞으면YES  아니면 NO 출력
 * 
 *  풀이
 *  1. 테케 입력 받기
 *  2. ()입력 받으면서 stack에 입력 받기
 *  	2.1. )를 넣을 때 (가 있는 경우 stack pop
 *  3. stack이 비어 있으면 YES출력
 *  4.아니면 No 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<String> stack = new ArrayDeque<String>();
		for(int i=0;i<N;i++) {
			stack = new ArrayDeque<String>();
			String[] arr = br.readLine().split("");
//			System.out.println(Arrays.toString(arr));
			for(int K = 0;K<arr.length;K++) {
//				System.out.println("이전" + stack);
				if(arr[K].equals(")")) {
					if(stack.size()!=0 && stack.peek().equals("(")) {
						stack.pop();
					}else {
						stack.push(arr[K]);
					}
				}else {
					stack.push(arr[K]);
				}
//				System.out.println("이후 "  + stack);
			}
			if(stack.size()==0) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}