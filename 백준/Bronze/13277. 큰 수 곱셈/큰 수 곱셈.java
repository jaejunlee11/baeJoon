import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BigInteger answer = BigInteger.ONE;
		for(int i = 0;i<2;i++) {
			BigInteger temp = sc.nextBigInteger();
			answer = answer.multiply(temp);
		}
		System.out.println(answer.toString());
	}
}