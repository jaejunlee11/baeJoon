/*
 * 문제
 * 1. 문자열 입력
 * 2. 알파벳, 대소문자를 13칸씩 밀기
 *
 * 풀이
 * 1. 문자열 입력
 * 2. 문자열을 돌면서 소문자, 대문자인 경우
 * 	2.1. 'a', 'A'를 빼고 13을 더하고 %26을 한 값에 다시 'a', 'A'를 더하고 형변환
 * 3. 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i =0 ;i<temp.length();i++) {
			int word = temp.charAt(i);
			if('a'<=word && word<='z') {
				word = ((word-'a')+13)%26;
				word += 'a';
				sb.append((char) word);
			} else if('A'<=word && word<='Z') {
				word = ((word-'A')+13)%26;
				word += 'A';
				sb.append((char) word);
			}else {
				sb.append(temp.charAt(i));
			}
		}
		System.out.println(sb);
	}
}