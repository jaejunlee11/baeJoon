/*
 * 문제
 * 1. 팰린 드롬인지 판단 
 * 
 * 풀이
 * 1. 문자열로 입력
 * 2. pointer 2개 a = 0, b = size
 * 3. while(a<b)
 * 	3.1. temp.charat(a)==charat(b) continue
 * 	3.2. sysout(no) => 다음 test_case
 * 4. yes출력 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A : while(true) {
			String temp = br.readLine();
			if(temp.equals("0")) break;
			int a = 0;
			int b = temp.length()-1;
			while(a<b) {
				if(temp.charAt(a++)==temp.charAt(b--)) continue;
				System.out.println("no");
				continue A;
			}
			System.out.println("yes");
		}
	}
}