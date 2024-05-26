import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String school = sc.next();
		if(school.equals("NLCS")) {
			System.out.println("North London Collegiate School");
			return;
		}
		if(school.equals("BHA")) {
			System.out.println("Branksome Hall Asia");
			return;
		}
		if(school.equals("KIS")) {
			System.out.println("Korea International School");
			return;
		}
		if(school.equals("SJA")) {
			System.out.println("St. Johnsbury Academy");
			return;
		}
	}
//	public static long recur(int count) {
//		if(count==0) {
//			return 1;
//		}
//		return count * recur(count-1);
//	}
}