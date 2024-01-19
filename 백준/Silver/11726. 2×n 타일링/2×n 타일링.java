/*
 * 1. 1일때 앞에 1이 있는 것 = 1, 아닌 것이 0
 * 2. 2일때 앞에 1이 있는 것 = 1+0 =1 , 앞에 1이 아닌 것 = 1
 * 3. n일때 전체 = 앞에 1자가 있는 것에 갯수 + 1자가 아닌 경우
 * 	3.1. 앞에 1자가 있는 것에 갯수 = 앞에 1자가 있는 것 + 1자가 아닌것
 * 	3.2. 앞이 1자가 아닌 것의 갯수 = 1자인 것의 갯수 
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][2];
		//1일때
		//앞에 1이 있는 것
		arr[1][0] =1;
		//앞에 1이 아닌 것
		arr[1][1] =0;
		for(int i = 2;i<=N;i++) {
			arr[i][0] = arr[i-1][0] %10007 + arr[i-1][1] %10007;
			arr[i][1] = arr[i-1][0] %10007;
		}
		System.out.println((arr[N][0]+arr[N][1])%10007);
	}

}