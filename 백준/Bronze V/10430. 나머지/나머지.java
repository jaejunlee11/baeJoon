/*
 * 문제
 * 1. (A+B)%C
 * 2. ((A%C) + (B%C))%C
 * 3. (A×B)%C
 * 4. ((A%C) × (B%C))%C
 * 
 * 풀이
 * 1. 계산 하기
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		System.out.println((A+B)%C);
		System.out.println(((A%C) + (B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C)*(B%C))%C);
	}
}