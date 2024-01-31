/*
 * 문제
 * 1. 타일은 가로2 세로1 or 가로1 세로2
 * 2. N입력
 * 3. 채워야할 칸은 세로3 가로 N
 * 풀이
 * 1. N입력
 * 2. N+1 배열 생성 -> arr
 * 3. 1일때 불가능 -> 0
 * 2. 2일때 -> 가가가, 세세가(위쪽에 세로가 있다), 가세세(아래쪽에 세로가 있다) =>3
 * 3. 3일때 ->불가능
 * 4. 4일때 -> 앞이 가가가인경우 arr[i-1][0] -> arr[i][0] = arr[i-1][0], arr[i][1] = arr[i-1][0],arr[i][2] = arr[i-1][0]
 * 	4.1. 앞이 세세가인 경우 arr[i-1][1] -> arr[i][0] = arr[i-1][1], arr[i][1] = arr[i-1][1]*2,arr[i][2] = arr[i-1][1]
 * 4.1. 앞이 가세세인 경우 arr[i-1][2] -> arr[i][0] = arr[i-1][2], arr[i][1] = arr[i-1][1],arr[i][2] = arr[i-1][2]*2
 * 5. N일때 ->홀수인경우 홀수가 나옴 => 타일크기가 2라 불가능
 * 	5.1. arr[N][0] = arr[N-2][0] + arr[N-2][1] +arr[N-2][2]
 * 	5.2. arr[N][1] = arr[N-2][0] + arr[N-2][1] * 2 + arr[N-2][2]
 * 	5.3. arr[N][2] = arr[N-2][0] + arr[N-2][1] +arr[N-2][2]*2
 * 6.arr[N]의 합
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N%2==1) {System.out.println(0); return;}
		int[][] arr=new int[N+1][3];
		arr[2][0] = 1;
		arr[2][1] = 1;
		arr[2][2] = 1;
		for(int i =4;i<=N;i+=2) {
			arr[i][0] = arr[i-2][0] + arr[i-2][1] +arr[i-2][2];
			arr[i][1] = arr[i-2][0] + arr[i-2][1] * 2 + arr[i-2][2];
			arr[i][2] = arr[i-2][0] + arr[i-2][1] + arr[i-2][2] * 2;
			
		}
		System.out.println(arr[N][0]+arr[N][1]+arr[N][2]);
	}
}