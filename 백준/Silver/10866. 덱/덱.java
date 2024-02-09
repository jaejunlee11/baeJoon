import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque que = new ArrayDeque<>();
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			if(temp.equals("push_front")) {
				int x = Integer.parseInt(st.nextToken());
				que.push(x);
			}else if(temp.equals("push_back")) {
				int x = Integer.parseInt(st.nextToken());
				que.offer(x);
			}else if(temp.equals("pop_front")) {
				if(que.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(que.pop());
			}else if(temp.equals("pop_back")) {
				if(que.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(que.pollLast());
			}else if(temp.equals("front")) {
				if(que.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(que.peek());
			}else if(temp.equals("back")) {
				if(que.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(que.peekLast());
			}else if(temp.equals("size")) {
				System.out.println(que.size());
			}else if(temp.equals("empty")) {
				if(que.isEmpty()) {
					System.out.println(1);
					continue;
				}
				System.out.println(0);
			}
		}
	}
}