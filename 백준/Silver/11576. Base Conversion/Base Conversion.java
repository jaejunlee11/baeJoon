/*
 * 문제
 * 1. A진법과 B진법이 주어짐
 * 2. A진법의 숫자를 입력 받으면 B진법으로 변환
 * 3. 숫자를 출력
 * 
 * 풀이
 * 1. 진법을 입력 받음 A,B
 * 2. 입력 받을 숫자 자리수를 입력 받음 -> N
 * 3. arr[N]에 숫자 입력 받기, sum =0만들기
 * 4. arr[N]을 순회하면서 해당 배열의 값을 *A를 계속 더해주기
 * 5. sum을 B로 나눴을 때의 나머지를 출력하고 B로 나눠주기 ->append해주고 쭉 붙이기 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i= 0;i<N;i++) {
			sum += Math.pow(A,N-i-1) *(Integer.parseInt(st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		if(sum==0) {
			System.out.println(0);
			return;
		}
		List<Integer> listWord = new ArrayList<>();
		while(sum!=0) {
			listWord.add((sum%B));
			sum /= B;
		}
		for(int i = listWord.size()-1;i>=0 ;i--) {
			System.out.print(listWord.get(i)+" ");
		}
	}
}