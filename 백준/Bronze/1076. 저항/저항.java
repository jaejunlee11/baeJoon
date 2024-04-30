import java.io.*;
import java.util.*;
/*
 * 275
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a =  br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		long answer = 0;
		if(a.equals("black")) {
			answer += 0 *10;
		}else if(a.equals("brown")) {
			answer += 1 *10;
		}else if(a.equals("red")) {
			answer += 2 *10;
		}else if(a.equals("orange")) {
			answer += 3 *10;
		}else if(a.equals("yellow")) {
			answer += 4 *10;
		}else if(a.equals("green")) {
			answer += 5 *10;
		}else if(a.equals("blue")) {
			answer += 6 *10;
		}else if(a.equals("violet")) {
			answer += 7 *10;
		}else if(a.equals("grey")) {
			answer += 8 *10;
		}else if(a.equals("white")) {
			answer += 9 *10;
		}
		
		if(b.equals("black")) {
			answer += 0;
		}else if(b.equals("brown")) {
			answer += 1;
		}else if(b.equals("red")) {
			answer += 2;
		}else if(b.equals("orange")) {
			answer += 3;
		}else if(b.equals("yellow")) {
			answer += 4;
		}else if(b.equals("green")) {
			answer += 5;
		}else if(b.equals("blue")) {
			answer += 6;
		}else if(b.equals("violet")) {
			answer += 7;
		}else if(b.equals("grey")) {
			answer += 8;
		}else if(b.equals("white")) {
			answer += 9;
		}
		
		if(c.equals("black")) {
			answer *= 1;
		}else if(c.equals("brown")) {
			answer *= 10;
		}else if(c.equals("red")) {
			answer *= 100;
		}else if(c.equals("orange")) {
			answer *= 1000;
		}else if(c.equals("yellow")) {
			answer *= 10000;
		}else if(c.equals("green")) {
			answer *= 100000;
		}else if(c.equals("blue")) {
			answer *= 1000000;
		}else if(c.equals("violet")) {
			answer *= 10000000;
		}else if(c.equals("grey")) {
			answer *= 100000000;
		}else if(c.equals("white")) {
			answer *= 1000000000;
		}
		System.out.println(answer);
	}

}