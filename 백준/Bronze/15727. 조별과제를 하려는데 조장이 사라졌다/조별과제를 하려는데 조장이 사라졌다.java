import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		if(t%5==0) {
			System.out.println(t/5);
		}else {
			System.out.println((t/5)+1);
		}
	}
}