/*
 * 문제
 * 1. 스네이크 버드 키 존재
 * 2. 키 보다 같거나 작은 것만 먹기 가능 먹으면 1 증가
 * 3. 최대로 늘릴 수 있는 길이 구하기
 * 
 * 풀이
 * 1. 과일 갯수(1000), 초기 길이 입력(10000)
 * 2. 과일 배열 만들기 -> arr[N]
 * 3. 배열 정렬 하기
 * 4. 배열을 for each로 순회
 * 	4.1. 해당 값이 길이보다 작으면 break
 * 	4.2. 길이 + 1
 * 5. 길이 출력
 * 
 * 생각할 것
 * 1. int로 충분
 * 
 * 시간 복잡도
 * 1. 1000 + 1000*3(정렬) + 1000(비교) => 5000 충분
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
 		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
 		Arrays.sort(arr);
 		for(int temp : arr) {
 			if(temp>L) break;
 			L++;
 		}
 		System.out.println(L);
	}
}