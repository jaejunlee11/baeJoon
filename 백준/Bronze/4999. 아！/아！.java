import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String me = sc.next();
		String doctor = sc.next();
		if(me.length()>=doctor.length()) {
			System.out.println("go");
		}else {
			System.out.println("no");
		}
		
	}
//	public static long recur(int count) {
//		if(count==0) {
//			return 1;
//		}
//		return count * recur(count-1);
//	}
}