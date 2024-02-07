/*
 * 문제
 * 1. 배열에 정수 넣기 -가능
 * 2. 절대값이 가장 작은 수 꺼내서 출력
 * 
 * 풀이
 * 1. 갯수 입력 받기 N => 최대 100000
 * 2. priority queue 생성 -> 이때 comparator를 절대값 비교로 변경
 * 3. 숫자 넣기 -> 0이 아닌경우
 * 4. pop하고 출력 시키기 -> 0인 경우 => 그전에 empty면 0 출력
 * 
 * 생각해야할 것
 * 1. 딱 int형 => 충분
 * 시간 복잡도
 * 1. 넣는 것 logn, 빼는 것 logn => 계산 개당 최대 5연산 -> 16*100000 = 백6십만 정도
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>((o1,o2)->{
			if(Math.abs(o1)==Math.abs(o2)) return o1.compareTo(o2);
			return Math.abs(o1)-Math.abs(o2);});
		StringBuffer sb = new StringBuffer();
		for(int i =0;i<N;i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp==0) {
				if(que.isEmpty()) sb.append(0+"\n");
				else sb.append(que.poll()+"\n");
			}else {
				que.add(temp);
			}
		}
		System.out.println(sb);
	}
}