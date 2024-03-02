/*
 * 문제
 * 1. 탑들이 존재
 * 2. 가장 꼭대기에서 레이저 발사
 * 3. 레이저가 닿은 탑의 위치 출력 -> 아무 탑에도 도착을 안하면 0 출력
 * 
 * 풀이
 * 1. N입력
 * 2. stack생성
 * 3. stack에 {MAX값,0}넣기
 * 4. for(1~N돌리기)
 * 	4.1. stack.peek
 * 		4.1.1. 현재 값과 비교해서 peek한 값이 큰 경우 => peek한 뒤의 값 출력
 * 		4.1.2. peek한 값이 더 작으면 제거 후 다음 값 peek    
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] {Integer.MAX_VALUE,0});
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=N;i++) {
			int nowH = Integer.parseInt(st.nextToken()); 
			while(true) {
				int[] temp = stack.peek();
				if(temp[0]>=nowH) {
					sb.append(temp[1]+" ");
					stack.push(new int[] {nowH,i});
					break;
				}else {
					stack.pop();
				}
			}
		}
		System.out.println(sb);
	}
}