/*
 * 문자
 * 1.문자열이 주어진다
 * 2. 문자열의 소문자,대문자,숫자,공백의 수를 출력
 * 
 * 풀이
 * 1. 문자열 입력
 * 2. 아스키 코드를 이용하여 소문자,대문자,숫자, 공백을 나눔
 * 3. count한 값을 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			try{String temp = br.readLine();
			if(temp.equals("")) break;
			int[] arr = new int[4];
			for(int i  = 0;i<temp.length();i++) {
				if(temp.charAt(i)==' ') {
					arr[3]++;
				}else if(temp.charAt(i)-'0'>=0 && temp.charAt(i)-'0'<=9) {
					arr[2]++;
				}else if(temp.charAt(i)>='a' && temp.charAt(i)<='z') {
					arr[0]++;
				}else if(temp.charAt(i)>='A' && temp.charAt(i)<='Z') {
					arr[1]++;
				}
			}
			for(int i = 0;i<4;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			} catch(Exception e){
				break;
			}
		}
		System.out.println(sb);
	}
}