/*
 * 1. 1~8 -> 이전 것에 +1,-1 숫자의 값
 * 2. 0 -> 이전 것에 1 값
 * 3. 9 -> 이전 것에 8 값
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] nums = new int[N+1][10];
		for(int i = 1;i<10;i++) {
			nums[1][i] =1;
		}
		for(int i = 2;i<=N;i++) {
			for(int j = 1;j<9;j++) {
				nums[i][j] =(nums[i-1][j-1]%1000000000) + (nums[i-1][j+1]%1000000000);
			}
			nums[i][0] = (nums[i-1][1]%1000000000);
			nums[i][9] = (nums[i-1][8]%1000000000);
		}
		int answer = 0;
		for(int e:nums[N]) {
			answer+=(e%1000000000);
			answer = (answer%1000000000);
		}
		System.out.println((answer%1000000000));
	}

}