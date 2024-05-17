import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		System.out.println(recur(t));
	}
	public static long recur(int count) {
		if(count==0) {
			return 1;
		}
		return count * recur(count-1);
	}
}