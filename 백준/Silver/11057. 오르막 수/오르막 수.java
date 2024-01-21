/*
 * 1. 0~9 -> 이전 것의 자기 보다 크거나 같은 값
 * 2. 1 -> 전부 1
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] nums = new int[N+1][10];
		for(int i = 0;i<10;i++) {
			nums[1][i]=1;
		}
		for(int i = 2;i<=N;i++) {
			for(int j = 0;j<10;j++) {
				for(int k = j;k<10;k++) {
					nums[i][j] += (nums[i-1][k] %10007);
				}
			}
		}
		int answer = 0;
		for(int e:nums[N]) {
			answer+=e;
			answer = (answer %10007);
		}
		System.out.println(answer);
	}

}