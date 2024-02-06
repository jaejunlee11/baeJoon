/*
 * 문제
 * 1. N,K입력
 * 2. N개 수 입력 받기
 * 3. 정렬 후 K번째 수 출력
 * 
 * 풀이
 * 1. N,K입력 -> 5000000 이하
 * 2. N 입력 받기
 * 3. 정렬하기
 * 
 * 생각 할 것
 * 1. 형 -> int로 충분
 * 
 * 시간 복잡도
 * 1. 5000000 * 22 정도 => 빠듯한데 괜찮을 듯
 */
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		System.out.println(arr.get(K-1));
	}
}