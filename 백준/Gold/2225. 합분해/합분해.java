/*
 * 문제
 * 1. N ,K입력 -> N은 1~200, K는 1~200
 * 2. 0~N을 K개 사용해서 N만들기
 * 
 * 풀이 -> dp로 풀어보기
 * 1. N,K입력 받기
 * 2. arr[N+1][K+1]배열 만들기
 * 3. N = 1, K=x일때 => x
 * 4. N = x, k=1일때 => 1 
 * 5. N = 2, k=2일때 => 02 20 11 =>3 (1,1) + (1,2) 
 * 6. N = 3, k=2일때 => 03 30 21 12 =>4 (3,1) + (2,2)
 * 7. N = 4, k=2일때 => 04 40 13 31 22=>5 (4,1) + (3,2) ??
 * 8. N = 2, k=3일때 => 002 020 200 110 011 101 =>6 (2,2) + (1,3)
 * 9. N = x, k=y일때 => (x,y-1) + (x-1,y)
 * 
 * 진짜 풀이
 * 1. N,K입력 받기
 * 2. arr[N+1][K+1]배열 만들기 ->long타입
 * 3. N=1 ,K=x인 것 => x로 채우기
 * 4. N=x , K=1인 것 => 1로 채우기
 * 5. 배열을 순회하면서 arr[x][y] = arr[x][y-1] + arr[x-1][y] ->이때 나누기 연산을 해서 넣어주기
 * 6. arr[N][K]출력
 * 
 * 고려해야할 것
 * 1. 메모리 초과 40000개 배열 -> 160000byte -> 널널함
 * 2. 타입 -> 10억에서 나눠주고 있으니 long타입 사용하면 될 듯?
 * 
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[][] arr = new long[N+1][K+1];
		for(int i = 1;i<N+1;i++) {
			arr[i][1] =1;
		}
		for(int i = 1;i<K+1;i++) {
			arr[1][i] =i;
		}
		for(int i = 2;i<N+1;i++) {
			for(int j = 2;j<K+1;j++) {
				arr[i][j] = (arr[i][j-1] + arr[i-1][j])%1000000000;
			}
		}
		System.out.println(arr[N][K]);
	}
}