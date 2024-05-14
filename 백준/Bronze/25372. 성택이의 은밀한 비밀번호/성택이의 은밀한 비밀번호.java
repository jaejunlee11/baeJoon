import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i =0 ;i<n;i++) {
			int length = sc.next().length();
			if(length<=9 && length>=6) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
}