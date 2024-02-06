/*
 * 문제
 * 1. 명령 수 입력 받기 ->N
 * 2. 명령 실행
 * 	2.1. push -> x넣기
 * 	2.2. pop -> 가장위에 것 빼서 출력
 * 	2.3. size -> size 출력
 * 	2.4. empty -> 비어있으면 1,아니면 0 출력
 * 	2.5. top -> 가장위의 정수 출력
 * 
 * 풀이
 * 1. 명령 수 입력 받기
 * 2. stack만들기
 * 3. 명령 실행
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Deque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for(int i= 0 ;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			if(temp.equals("push")){
				int x = Integer.parseInt(st.nextToken());
				stack.push(x);
			}else if(temp.equals("pop")) {
				if(stack.isEmpty()) sb.append("-1\n" );
				else {
					sb.append(stack.pop()+"\n");
				}
			}else if(temp.equals("size")) {
				sb.append(stack.size()+"\n");
			}else if(temp.equals("empty")) {
				if(stack.isEmpty()) sb.append(1+"\n");
				else sb.append(0+"\n");
			}else if(temp.equals("top")) {
				if(stack.isEmpty()) sb.append(-1+"\n");
				else sb.append(stack.peek()+"\n");
			}
			
		}
		System.out.println(sb);
	}
}