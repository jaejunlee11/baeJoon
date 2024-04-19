/*
 * 믄제
 * 1. N개의 정수 존재
 * 2. X정수가 있는지 확인
 * 
 * 풀이
 * 1. N입력
 * 2. HashSet생성 set 채우기
 * 3. M입력 
 * 4. for문 M돌리기
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Set<Long> set = new HashSet();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			set.add(Long.parseLong(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i =0 ;i<M;i++) {
			if(set.contains(Long.parseLong(st.nextToken()))) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}

}