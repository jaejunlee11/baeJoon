/*
 * 문제
 * 1.문자열이 주어짐
 * 2. 각 문자들의 나온 갯수를 출력
 * 
 * 풀이
 * 1. 문자열 입력
 * 2. 26개의 배열 생성
 * 3. 문자의 아스키 값을 활용하여 배열이 숫자를 증가
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		int[] arr = new int[26];
		for(int i = 0;i<temp.length();i++) {
			arr[temp.charAt(i)-'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<26;i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);
	}
}