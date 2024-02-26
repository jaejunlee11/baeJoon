/*
 * 문제
 * 1. 종이컵이 주어짐 -> 200000
 * 2. 종이컵안에 간식이 들어있음
 * 3. 종이컵을 섞음 ->200000
 * 4. 간식이 위치한 곳 찾기
 * 
 * 풀이
 * 1. 테케 입력
 * 2. N ,X ,K입력-> 종이컵 수, 간식 위치, 섞는 횟수
 * 3. arr[N+1]생성 -> 종이컵 배열
 * 4. arr[X] = true; -> 종이컵에 간식 넣기
 * 5. 종이컵 교환 swap(arr,a,b);
 * 6. true인 것 출력
 * 
 * 고려해야할 것
 * 1. 메모리 -> 1byte * 200000 => 200kbyte 충분
 * 시간 복잡도
 * 1. 200000 * 3 * 10 + 200000=> 충분
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			boolean[] arr = new boolean[N+1];
			arr[X] = true;
			for(int i = 0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				swap(arr,a,b);
			}
			for(int i = 1;i<=N;i++) {
				if(arr[i]) {
					System.out.println(i);
					return;
				}
            }
	}
	private static void swap(boolean[] arr, int a, int b) {
		boolean temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}