/*
 * 문제
 * 1. 업무는 최근에 주어진 순서대로 처리
 * 2. 주어진 업무는 바로 시작
 * 3. 업무 처리 도중 업무를 받으면 받은 업무 먼저
 * 4. 도중에 중단했던 업무는 이어서 가능
 * 5. 마감한 업무에 대해서 점수를 받음
 * 6. 점수 출력
 * 
 * 풀이
 * 1. N입력
 * 2. stack 생성
 * 3. for(N번 동안 입력 받기)
 * 	3.1. 1 A T입력-> stack에 A T-1 넣기 -> 만약 바로 0이되면 넣지 않고 answer += A
 * 	3.2. 0입력 -> 가장 위에 있는 것을 T--후 0이되면 answer += A, T가 남으면 다시 stack에 넣기
 * 4. answer출력
 * 고려해야할 것
 * 1. N 1000000 * 100 = 1억 => int로 충분
 * 시간 복잡도
 * 1. 1000000 * 3 = 3백만 => 충분
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<int[]> stack = new ArrayDeque<>();
		int answer = 0;
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==1) {
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				if(T==1) {
					answer+=A;
				}else {
					stack.push(new int[] {A,T-1});
				}
			}else {
				if(stack.isEmpty()) continue;
				int[] temp = stack.pop();
				if(temp[1]==1) {
					answer+=temp[0];
				}else {
					stack.push(new int[] {temp[0],temp[1]-1});
				}
			}
		}
		System.out.println(answer);
	}
}