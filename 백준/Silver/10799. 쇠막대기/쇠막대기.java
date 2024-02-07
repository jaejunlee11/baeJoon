/*
 * 문제
 * 1. ()는 레이저 (사이에 다른 것 )는 막대
 * 2. 레이저가 막대를 자름
 * 3. 막대의 갯수는
 * 
 * 풀이
 * 0.막대의 갯수 count, 전체 answer, 이전 것을 제거하기 전에 담아 놓는 곳 temp
 * 1.(가 들어온 경우 -> 막대기 or 레이저 => 막대기 갯수 count ++, temp에 저장
 * 	1.1. 막대기 => 그 다음이 ( 
 * 	1.2. 레이저 => 그 다음이 )
 * 2.)가 들어온 경우 -> 막대기 종료 or 레이저
 * 	2.1. temp가 (인 경우->레이저 => count--후 answer에 count 더 해줌, (pop
 * 	2.2. temp가 )인 경우->막대기 => count --후 answer++, (pop
 * 
 * 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arr = br.readLine();
		Deque<Character> stack = new ArrayDeque<>();
		int count = 0;
		int answer =0;
		char temp =')';
		for(int i = 0 ;i<arr.length();i++) {
			if(arr.charAt(i)=='(') {
				count++;
				stack.push('(');
				temp = '(';
			}else if(arr.charAt(i)==')') {
				count--;
				if(temp==')') {
					answer++;
					stack.pop();
					temp = ')';
				}else if(temp=='(') {
					answer += (count);
					stack.pop();
					temp = ')';
				}
			}
			
		}
		System.out.println(answer);
	}
}