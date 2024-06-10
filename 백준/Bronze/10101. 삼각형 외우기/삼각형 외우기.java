import java.io.*;
import java.util.*;
/*
 * 문제
 * 1. 세 각의 크기가 모두 60이면, Equilateral
 * 2. 세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
 * 3. 세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
 * 4. 세 각의 합이 180이 아닌 경우에는 Error
 * 
 * 풀이
 * 1. a, b , c 입력
 * 2. a+b+c != 180 => Error
 * 3. a==60 , b==60, c==60인 경우 Equilateral
 * 3. a==b, b==c , a==c 인 경우 Isosceles
 * 4. Scalene
 */
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if(a+b+c!=180) {
			System.out.println("Error");
			return;
		}
		if(a==60 && b==60 && c==60) {
			System.out.println("Equilateral");
			return;
		}
		if(a==b || b==c || a==c) {
			System.out.println("Isosceles");
			return;
		}
		System.out.println("Scalene");
	}
}