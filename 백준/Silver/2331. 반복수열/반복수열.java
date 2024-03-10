import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		Map<Integer,Integer> set = new HashMap<>();
		int count= 0;
		while(!set.containsKey(A)) {
			set.put(A, count++);
			int sum = 0;
			while(A!=0) {
				sum+=(int)(Math.pow(A%10, P));
				A /= 10;
			}
			A = sum;
		}
		System.out.println(set.get(A));
	}
}