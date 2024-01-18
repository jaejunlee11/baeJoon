/*
 * 1. 라운드 수 입력
 * 2. 총 갯수와 카드 모양 입력
 * 3. 그 다음 줄에 총 갯수와 모양 입력
 *  3.1. 각 a,b의 4짜리 배열을 만들어 4,3,2,1순으로 비교 후 더 큰쪽 이 승리
 * 4. 승리한쪽 출력 or D출력
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A : for(int i = 0;i<N;i++) {
			int[] a = new int[4];
			int[] b = new int[4];
			StringTokenizer st1 =new StringTokenizer(br.readLine());
			int k1 = Integer.parseInt(st1.nextToken());
			for(int j = 0;j<k1;j++) {
				a[Integer.parseInt(st1.nextToken())-1]++;
			}
			StringTokenizer st2 =new StringTokenizer(br.readLine());
			int k2 = Integer.parseInt(st2.nextToken());
			for(int j = 0;j<k2;j++) {
				b[Integer.parseInt(st2.nextToken())-1]++;
			}
			for(int j = 3;j>=0;j--) {
				if(a[j]>b[j]) {
					System.out.println("A");
					continue A;
				}else if(a[j]<b[j]) {
					System.out.println("B");
					continue A;
				}
			}
			System.out.println("D");
		}
	}
}