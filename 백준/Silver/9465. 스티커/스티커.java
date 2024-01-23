/*
 * 1. 테스트 케이스 수 입력 : T
 * 2. 스트커 줄 갯수 : N
 * 3. 스티커 2줄 입력 : arr1, arr2
 * 4. 스티커 선택 배열 : answers[N+1][3]
 * 5.1. 위쪽 스티커를 선택하는 경우 -> answers[i][0] = max(answers[i-1][1],answers[i-1][2]) + 위쪽 스티커
 * 5.2. 아래쪽 스티커를 선택하는 경우 -> answers[i][1] = max(answers[i-1][0],answers[i-1][2]) + 아래쪽 스티커
 * 5.3. 선택하지 않는 경우 ->answers[i][2] = max(answers[i-1][0],answers[i-1][1])
 * 6. 가장 큰 값을 선택
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T;i++) {
			int N  = Integer.parseInt(br.readLine());
			int[] arr1 = new int[N+1];
			int[] arr2 = new int[N+1];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 1;j<=N;j++) {
				arr1[j] = Integer.parseInt(st1.nextToken());
			}
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 1;j<=N;j++) {
				arr2[j] = Integer.parseInt(st2.nextToken());
			}
			int[][] answers = new int[N+1][3];
			answers[1][0] = arr1[1];
			answers[1][1] = arr2[1];
			for(int j = 2;j<=N;j++) {
				answers[j][0] = Math.max(answers[j-1][1],answers[j-1][2])+arr1[j];
				answers[j][1] = Math.max(answers[j-1][0],answers[j-1][2])+arr2[j];
				answers[j][2] = Math.max(answers[j-1][0],answers[j-1][1]);
			}
			int maxAnswer = Math.max(answers[N][0],answers[N][1]);
			maxAnswer = Math.max(maxAnswer,answers[N][2]);
			System.out.println(maxAnswer);
		}
		
	}

}