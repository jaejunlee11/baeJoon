/*
 * 문제
 * 1. 2*N 우리 존재
 * 2. 사자는 서로 붙어있지 않음
 * 3. 사자를 배치하는 경우의 수 구하기 => 한마리도 배치 안할 수 있음
 * 
 * 풀이
 * 1. N입력 받기-> 최대 100000
 * 2. N=1인 경우 -> 사자가 왼쪽 =>1, 사자가 오른쪽 =>1, 사자가 없음 =>1
 * 3. N인 경우 -> 사자가 왼쪽 => 오른쪾 + 없음, 사자가 오른쪽 => 왼쪽 + 없음, 사자가 없음 => 왼쪽, 오른꼬 , 없음
 * 4. 9901로 나눈 나머지 출력
 */
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[3];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 2;i<=N;i++) {
			int temp0=dp[1]+dp[2];
			int temp1=dp[0]+dp[2];
			int temp2=dp[0]+dp[1]+dp[2];
			dp[0] = temp0%9901;
			dp[1] = temp1%9901;
			dp[2] = temp2%9901;
		}
		System.out.println((dp[0]+dp[1]+dp[2])%9901);
	}
}