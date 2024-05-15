import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int s = sc.nextInt();
		if(s==1) {
			System.out.println(280);
		}else {
			if(t>=12 && t<=16) {
				System.out.println(320);
			}else {
				System.out.println(280);
			}
		}
	}
}