/*
 * 문제
 * 1. N장 카드 존재 1이 가장 위,N이 가장 아래
 * 2. 제일 위 카드 버리기
 * 3. 제일 위 카드 가장 아래로 내리기
 * 4. 마지막 카드 출력
 * 
 * 풀이
 * 1. 큐 만들기
 * 2. 1부터 N까지 순서로 큐에 넣기(offer)
 * 3. poll시키기
 * 4. poll시킨거 다시 넣기(offer)
 * 5. 1장 남으면 (size()==0이면) 출력(poll) 후 종료
 * 
 * 생각할 것
 * 1. 자료형 -> 500000 => int
 * 
 * 시간 복잡도
 * 1. 500000  + (250000 + 125000 + ...) * 3 => 대충 1500000 충분
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> que = new ArrayDeque<Integer>();
		for(int i = 1 ;i <=N;i++) {
			que.offer(i);
		}
		while(que.size()>1) {
			que.poll();
			que.offer(que.poll());
		}
		System.out.println(que.poll());
	}
}