/*
 * 1. 1인 경우 마지막이 1자 = 1, 그냥 = 0
 * 1. 2인 경우 마지막이 1자 = 1, 그냥 = 2
 * 2. 마지막이 1자인 경우 -> 그냥 + 마지막이 1자
 * 3. 마지막이 그냥 -> 마지막이 1자 *2 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][2];
		//마지막이 1자
		arr[1][0] = 1;
		//그냥
		arr[1][1] = 0;
		for(int i = 2;i<=N;i++) {
			arr[i][0] = (arr [i-1][0])%10007 + (arr[i-1][1])%10007;
			arr[i][1] = (arr[i-1][0]*2)%10007;
		}
		System.out.println((arr[N][0]+arr[N][1])%10007);
	}
}
