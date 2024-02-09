/*
 * 문제
 * 1. 문자열이 주어짐
 * 2.문자열 접미사의 배열을 생성
 * 3. 사전순으로 출력
 * 
 * 풀이
 * 1. 문자열 입력
 * 2. 문자열의 길이만큰 배열 생성
 * 3. for문을 돌면서 앞쪽 부터 접미사 생성
 * 4. 정렬 후 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		String[] arr = new String[temp.length()];
		for(int i = 0;i<temp.length();i++) {
			arr[i] = temp.substring(i);
		}
		Arrays.sort(arr);
		for(int i =0 ;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}