import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w1 = Integer.MIN_VALUE;
		int w2 = Integer.MAX_VALUE;
		int h1 = Integer.MIN_VALUE;
		int h2 = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++) {
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
			w1 = Math.max(w1, a1);
			w2 = Math.min(w2, a1);
			h1 = Math.max(h1, a2);
			h2 = Math.min(h2, a2);
		}
		System.out.println((w1-w2)*(h1-h2));
		
	}
//	public static long recur(int count) {
//		if(count==0) {
//			return 1;
//		}
//		return count * recur(count-1);
//	}
}