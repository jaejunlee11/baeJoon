/*
 * 문제
 * 1. 탑의 높이 주어짐
 * 2. 오른쪽에서 왼쪽으로 레이저 발사
 * 3. 높이가 레이저가 쏜 탑이 더 높으면 위쪽으로 레이저가 셈
 * 4. 가장 꼭대기의 레이저를 받는 탑을 구하기
 * 
 *  풀이
 *  1. 탑의 갯수 입력 N -> 	500000
 *  2. stack만들기 -> 가장 아래 index 0, height MAX_VALUE넣기
 *  3. 탑의 높이 입력 받으면서 index와 함께 stack에 넣기
 *  4. peek을 통해서 확인을 하면서 현제 탑의 높이가 더 크면 다 뽑아 버리면서 제거
 *  5. 마지막에 박은 탑의 index 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<int[]>();
		stack.push(new int[] {Integer.MAX_VALUE,0});
		for(int i = 1;i<=N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			while(true) {
				if(stack.peek()[0]<temp) {
					stack.pop();
				}else {
					sb.append(stack.peek()[1] + " ");
					stack.push(new int[] {temp,i});
					break;
				}
			}
			
		}
		System.out.println(sb);
	}
}