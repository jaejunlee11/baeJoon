/*
 * 문제
 * 1. 문장이 있음
 * 2. 문장에 대문자 있으면 _a로 변경
 * 3. _가 있으면 대문자로 변경
 * 4. 섞여 있으면 error처리
 * 
 * 풀이
 * 1. temp입력 받기
 * 2. for tmep 크기
 * 	2.1. char가 _이면 sb에 그 다음글자 대문자로 넣기 flag1=true flag2가 true면 brak후 error
 * 	2.2. char가 대문자면 sb에 _소문자 넣기 => flag1가 true면 break후 error, flag2=true
 * 3. 출력
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		StringBuilder sb = new StringBuilder();
		boolean flag1 = false;
		boolean flag2 = false;
//		System.out.println((int)'a');
		if(temp.charAt(0)=='_' || (temp.charAt(0)<='Z' && temp.charAt(0)>='A')) {
			System.out.println("Error!");
			return;
		}
		for(int i = 0;i<temp.length();i++) {
			if(!((temp.charAt(i)<='Z' && temp.charAt(i)>='A') || (temp.charAt(i)<='z' && temp.charAt(i)>='a') || (temp.charAt(i)=='_'))) {
				System.out.println("Error!");
				return;
			}
			if(temp.charAt(i)=='_') {
				if(flag2) {
					System.out.println("Error!");
					return;
				}
				flag1 = true;
				i++;
				if(i>=temp.length() || temp.charAt(i)=='_' || (temp.charAt(i)<='Z' && temp.charAt(i)>='A')) {
					System.out.println("Error!");
					return;
				}
				sb.append((char)(temp.charAt(i)-32));
			}else if(temp.charAt(i)<='Z' && temp.charAt(i)>='A') {
				if(flag1) {
					System.out.println("Error!");
					return;
				}
				flag2 = true;
				sb.append('_');
				sb.append((char)(temp.charAt(i)+32));
			}else {
				sb.append(temp.charAt(i));
			}
		}
		System.out.println(sb);
	}
}