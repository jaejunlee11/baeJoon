/*
 * 0. 현재잔을 마신 경우, 전잔도 마신 경우, 현재잔을 안마신 경우, 2잔을 패스한 경우
 * 1. N입력 받기 ->포도주 잔
 * 2. 포도주 배열에 넣기 -> drinks
 * 3. 현시점 현재잔을 마신 경우 arr1, 전잔도 마신 경우 arr2, 현재잔을 안마신 경우 arr3
 * 4. 1개 -> arr1[1]= drinks[1], arr2[1] = drinks[1], arr3[1] = 0 ,arr4[1] =0
 * 5. 2개 -> arr1[2]= arr3[1] + drinks[2], arr2[2] = arr1[1]+drinks[2], arr3[2] = Math.max(arr1[1],arr2[1]) ,arr4[1] =arr3[1]
 * 6. N개 -> arr1[N] = arr3[N-1] + drinks[N], arr2[N] = arr1[N-1]+drinks[N], arr3[N] = Math.max(arr1[N-1],arr2[N-1]) , arr4[N] = arr3[N-1]
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] drinks = new int[N+1];
		for(int i = 1;i<=N;i++) {
			drinks[i] = Integer.parseInt(br.readLine());
		}
		if(N==1) {
			System.out.println(drinks[1]);
			return;
		}
		if(N==2) {
			System.out.println(drinks[1]+drinks[2]);
			return;
		}
		int[][] arr = new int[N+1][4];
		arr[2][0] = drinks[2];
		arr[2][1] = drinks[1]+drinks[2];
		arr[2][2] = drinks[1];
		arr[2][3] = drinks[1];
		for(int i = 3;i<=N;i++) {
			arr[i][0] = arr[i-1][2] + drinks[i];
			arr[i][1] = Math.max(arr[i-1][0] + drinks[i], arr[i-2][3]+drinks[i-1]+drinks[i]);
			arr[i][2] = Math.max(arr[i-1][0], arr[i-1][1]);
			arr[i][3] = arr[i-1][2];
		}
		int answer = Math.max(arr[N][0], arr[N][1]);
		System.out.println(Math.max(answer,arr[N][2]));
	}
}