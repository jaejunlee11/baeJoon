/*
 * 문제
 * 1. 빌딩이 존재
 * 2. 앞에 벽이 있으면 다른 옥상 확인 불가능
 * 3. 각 빌딩 마다 확인 가능한 옥상 갯수의 합 구하기
 * 
 * 풀이
 * 1. 빌딩 수 N 입력
 * 2. stack생성 
 * 3. stack에 가장 위의 값 확인	
 * 	3.1. 자기가 더 크거나 같은 경우 제거 후 다음 것 확인
 * 	3.2. 자기가 더 작은 경우 stack크기 만큼 sum더 해주기
 * 	3.3. stack이 빈 경우 정지
 * 4. stack에 빌딩 높이 넣기
 * 5. sum출력 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		long answer = 0;
		for(int i = 0;i<N;i++) {
//			System.out.println(Arrays.deepToString(stack));
			int now = Integer.parseInt(br.readLine());
			while(!stack.isEmpty()) {
				int temp = stack.pop();
//				System.out.println(temp +" " + now);
				if(temp>now) {
					stack.push(temp);
					answer += stack.size();
//					System.out.println(answer);
					break;
				}
			}
			stack.push(now);
		}
		System.out.println(answer);
	}
}