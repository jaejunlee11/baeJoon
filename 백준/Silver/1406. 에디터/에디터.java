/*
 * 문제
 * 1. 초기 문자열이 주어짐
 * 2. 명령어를 통해서 문자열 수정
 * 3. 최종 결과 출력
 * 
 * 풀이
 * 1. 초기 문자열이 주어짐 -> N => List에 담기
 * 2. 커멘드 입력 갯수 입력 -> M
 * 3. 가장 왼쪽에서 커서 시작 -> L-1
 * 4. 커멘드 
 * 	4.1. P => 커서 위치에 list.add() 커서 위치 + 1
 * 	4.2. L => 커서 위치를 -1
 * 	4.3. D => 커서 위치를 +1
 * 	4.4. B => 커서에 있는 것 list.remove() => 커서 위치 -1
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		LinkedList<Character> arr = new LinkedList<>();
 		for(int i = 0;i<temp.length();i++) {
			arr.add(temp.charAt(i));
		}
 		
 		ListIterator<Character> iter = arr.listIterator();
 		while(iter.hasNext()) {
 			iter.next();
 		}
// 		Deque<Character> stack = new ArrayDeque<>();
 		int M = Integer.parseInt(br.readLine());
 		for(int i =0 ;i<M;i++) {
 			String spell = br.readLine();
 			if(spell.equals("L")) {
 				if(iter.hasPrevious()) {
 					iter.previous();
 				}
 				continue;
 			}else if(spell.equals("D")) {
 				if(iter.hasNext()) {
 					iter.next();
 				}
 				continue;
 			} else if(spell.equals("B")) {
 				if(iter.hasPrevious()) {
 					iter.previous();
 					iter.remove();
 				}
 				continue;
 			} else {
 				iter.add(spell.charAt(2));
 			}
 		}
 		StringBuilder sb = new StringBuilder();
 		for(char a : arr) {
 			sb.append(a);
 		}
 		System.out.println(sb);
	}
}