/*
 * 1. 1일때 0 -> 1 : 이전것 0
 * 2. 0일때 1,0 -> 0: 이전것 0 + 이전것 1
 * 3. 1은 1
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] nums = new long[N+1][2];
		nums[1][0] = 0;
		nums[1][1] = 1;
		for(int i=2;i<=N;i++) {
			nums[i][0] = nums[i-1][0] + nums[i-1][1];
			nums[i][1] = nums[i-1][0];
		}
		System.out.println((nums[N][0]+nums[N][1]));
	}

}