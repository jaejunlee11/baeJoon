/*
 * 문제
 * 1. 단어가 주어짐
 * 2. 포함되어 있으면 가장 처음 나온 위치를
 * 3. 포함되어 있지 않으면 -1을 출력
 * 
 * 풀이
 * 1. 단어 입력
 * 2. 26개 배열 생성
 * 3. 단어를 순회하면서 0이 아닌 경우 해당 위치를 넣기
 * 4. 출력시 0이면 -1 아닌경우 값을 출
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		int[] arr = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		for(int i = 0;i<temp.length();i++) {
			int num =temp.charAt(i)-'a';
			if(arr[num] ==-1 ) {
				arr[num] = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<26;i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);
	}
}