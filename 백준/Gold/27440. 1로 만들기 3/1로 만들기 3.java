import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		int bitmask = 0;
		Deque<Long> que = new ArrayDeque<>();
		que.add(N);
		Map<Long,Boolean> visited = new HashMap<>();
		
		long count = -1;
		while(!que.isEmpty()) {
			count++;
			long queSize = que.size();
			while(queSize-- >0) {
				long i = que.poll();
				if(i==1) {
					System.out.println(count);
					return;
				}
				if(i%2==0) {
					if(visited.get(i/2)==null) {
						visited.put(i/2, true);
						que.add(i/2);
					}
				}
				if(i%3==0) {
					if(visited.get(i/3)==null) {
						visited.put(i/3, true);
						que.add(i/3);
					}
				}
				if(visited.get(i-1)==null) {
					visited.put(i-1, true);
					que.add(i-1);
				}
			}
		}
	}
}