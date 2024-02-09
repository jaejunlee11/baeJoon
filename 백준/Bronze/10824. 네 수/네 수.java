/*
 * 문제
 * 1. 4개 수가 주어짐
 * 2. 2개의 수를 붙이고 더한 값 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String temp =st.nextToken();
		long AB = Long.parseLong(temp + st.nextToken());
		temp =st.nextToken();
		long CD = Long.parseLong(temp + st.nextToken());
		System.out.println(AB + CD);
	}
}