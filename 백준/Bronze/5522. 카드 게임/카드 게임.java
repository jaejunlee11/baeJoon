import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BigInteger answer = BigInteger.ZERO;
		for(int i = 0;i<5;i++) {
			BigInteger temp = sc.nextBigInteger();
			answer = answer.add(temp);
		}
		System.out.println(answer.toString());
	}
}