/* 0. 쭉 이어온 것 arr1 , 지금까지 최대 배열합 answer
 * 1. 배열 1개 -> arr1 = temp[1], answer = temp[1]
 * 2. 배열 2개 -> arr1이 음수가 아닐 때 : arr1 = arr1 + temp[2], answer 최신화, 음수인 경우 : arr1 = temp[2], answer 최신화
 * 3. 배열 N개 -> arr1이 음수가 아닐 때 : arr1 = arr1 + temp[N], answer 최신화, 음수인 경우 : arr1 = tmep[N], answer  최신화
 * 4. answer출력
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 연속 수를 받는 배열
		int[] temp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=N;i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		// 지금까지의 연속된 숫자의 합을 받는 배열
		int[] arr1 = new int[N+1];
		// 현재까지의 최대값
		int answer = Integer.MIN_VALUE;
		//첫번째 숫자 입력
		arr1[1] = temp[1];
		answer = temp[1];
		for(int i = 2;i<=N;i++) {
			//지금까지의 합이 음수인 경우 연속을 버리고 최대값 최신화
			if(arr1[i-1]<0) {
				arr1[i] = temp[i];
				answer = Math.max(answer, arr1[i]);
			}
			//음수가 아닌 경우
			else {
				//지금까지의 연속 합 최신화 및 최대값 최신화
				arr1[i] = arr1[i-1] + temp[i];
				answer = Math.max(answer, arr1[i]);
			}
		}
		System.out.println(answer);
	}
}