/*
 * 문제
 * 1. N개의 수 입력
 * 2. 정렬 하기
 * 
 * 풀이
 * 1. N입력 -> 1000000 주어짐
 * 2. N개 수 입력 => -1000000~1000000
 * 3. 정렬하기
 * 
 * 시간 복잡도
 * 1. NlogN => 1000000 * 20 =>2천만
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> arr = new ArrayList<Integer>();
		for(int i = 0;i<N;i++) {
			arr.add(sc.nextInt());
		}
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i : arr) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}
}