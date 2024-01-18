/*
 * 1. 학생 수 방 최대 인원수 입력
 * 2. 성별 * 학년 -> 12 배열 생성
 * 3. 6* 성별 + 학년 -1 값을 인덱스로 하는 배열의 숫자 ++
 * 4. 각 배열의 값을 최대 인원수로 나눈 값을 합치고 출력
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[12];
		for(int i = 0;i<N;i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st1.nextToken());
			int Y = Integer.parseInt(st1.nextToken());
			arr[S*6+Y-1]++;
		}
		int answer = 0;
		for(int e : arr) {
			if(e%K==0) answer+=(e/K);
			else answer+=(e/K)+1;
		}
		System.out.println(answer);
	}

}