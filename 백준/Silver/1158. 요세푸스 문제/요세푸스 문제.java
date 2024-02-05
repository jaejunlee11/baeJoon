/*
 * 믄제
 * 1. N명 존재
 * 2. k번째 사람 제거
 * 3. 제거된 사람 순서대로 출력
 * 
 * 풀이 
 * 1. N,K입력 받기
 * 2. 1부터 N까지 queue에 넣기
 * 3. while문을 돌기
 * 	3.1. count증가 -> k로 나눴을때 나머지가 0이면 offer해서 출력
 * 	3.2. 아닌 경우 offer후 add
 * 	3.3. queue가 1개 남으면 종료
 * 5.마지막 원소 출력 후 종료
 * 
 * 시간 복잡도
 * 1. 5000*5000 = 25000000
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> que = new ArrayDeque<Integer>();
		for(int i = 1;i<=N;i++) {
			que.add(i);
		}
		int count = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(que.size()>1) {
			if(count%K==0) {
				sb.append(que.poll()+", ");
			}else {
				que.add(que.poll());
			}
			count++;
		}
		sb.append(que.poll()+">");
		System.out.println(sb);
	}
}