/*
 * 문제
 * 1. N*N표 주어짐
 * 2. N번째 큰수를 찾기
 * 
 * 풀이
 * 1. N입력
 * 2. N*N 크기 배열 만들기
 * 3. 배열에 입력 받기
 * 4. sort후 N번째 값 출력
 * 
 * 생각해야할 것
 * 225만 -> 1000만 => 250만 byte -> 2500kb -> 2.5mb
 * int형 숫자 => 더하면 long
 * 빠른 속도의 정렬을 위해 collection사용
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> arr = new ArrayList<Integer>();
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
		}
		Collections.sort(arr,(o1,o2)->o2-o1);
		System.out.println(arr.get(N-1));
	}
}