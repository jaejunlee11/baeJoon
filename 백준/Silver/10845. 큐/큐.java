/*
 * 문제
 *  큐 구현
 * 풀이
 * 1. 큐 생성
 * 2. 명령에 맞게 큐 명령어 사용 -> offer, poll
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Deque<Integer> que = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			if(temp.equals("push")){
				que.offer(Integer.parseInt(st.nextToken()));
			}else if(temp.equals("front")) {
				if(que.isEmpty()) sb.append(-1+"\n");
				else sb.append(que.peekFirst()+"\n");
			}else if(temp.equals("back")) {
				if(que.isEmpty()) sb.append(-1+"\n");
				else sb.append(que.peekLast()+"\n");
			}else if((temp.equals("size"))){
				sb.append(que.size()+"\n");
			}else if(temp.equals("empty")) {
				if(que.isEmpty()) sb.append(1+"\n");
				else sb.append(0+"\n");
			}else if(temp.equals("pop")) {
				if(que.isEmpty()) sb.append(-1+"\n");
				else sb.append(que.poll()+"\n");
			}
		}
		System.out.println(sb);
	}
}