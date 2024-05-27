import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int count = 0;
		if(A%a==0) {
			count = (A/a);
		}else {
			count = (A/a);
			count++;
		}
		if(B%b==0) {
			count = Math.max(count,(B/b));
		}else {
			count = Math.max(count,(B/b+1));
		}
		System.out.println(n-count);
	}
//	public static long recur(int count) {
//		if(count==0) {
//			return 1;
//		}
//		return count * recur(count-1);
//	}
}