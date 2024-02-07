import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 30,048kb / 468ms

public class Main {
	// PQ
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		// 절대값으로 먼저 비교, 같다면 원본 값으로 비교
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
			if(Math.abs(o1)==Math.abs(o2)) return o1.compareTo(o2);
			return Math.abs(o1)-Math.abs(o2);});

		for (int i = 0; i < N; i++) {
			int command = Integer.parseInt(br.readLine());
			if (command != 0) {
				pq.offer(command);
			} else {
				sb.append(pq.peek() == null ? 0 : pq.poll()).append("\n");
			}
		}

		System.out.println(sb);
	}
}