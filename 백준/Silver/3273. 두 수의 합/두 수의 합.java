/*
 * 1. 배열 갯수 입력받기
 * 2. 배열 입력 받기
 * 3. x값 입력 받기
 * 4. 100000배열 만들기
 * 5. 배열 돌면서 x-배열의 값 에 맞춰서 1이 아니면 100000배열의 값 ++ -> 1이면 count++
 * 6. count 출력
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int X = Integer.parseInt(br.readLine());
		int[] answer = new int[2000000];
		int count = 0;
		for(int e : arr) {
			if(answer[e]!=0) {
				count++;
			}else {
				if(X-e>=0)
					answer[X-e]++;
			}
		}
		System.out.println(count);
	}

}