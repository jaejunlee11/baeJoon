/*
 * 1. 줄 수 입력 받기
 * 2. 첫번째 줄 N위치에 별찍기
 * 3. 2번째 줄부터 N-1번째 줄까지 N-i,N+i위치에 별찍기
 * 4. N번째 줄에 2*N-1개 별 찍기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println("*");
		}else if (N==2) {
			System.out.println(" *");
			System.out.println("***");
		}else {
			for(int i = 0;i<N;i++) {
				if(i==0) {
					for(int j = 0;j<N-i-1;j++) {
						System.out.print(" ");
					}
					System.out.print("*");
					System.out.println();
				}else if(i == N-1) {
					for(int j = 0; j<2*N-1;j++) {
						System.out.print("*");
					}
				}else {
					for(int j = 0;j<N-i-1;j++) {
						System.out.print(" ");
					}
					System.out.print("*");
					for(int j = 0;j<2*i-1;j++) {
						System.out.print(" ");
					}
					System.out.print("*");
					System.out.println();
				}
			}
		}

	}

}