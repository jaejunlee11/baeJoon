/*
 * 
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		for(int i = 1;i<=N;i++) {
			arr[i]=i;
		}
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] temp = arr.clone();
			int count = b;
			for(int j = a;j<=b;j++) {
				arr[j] = temp[count--];
			}
		}
		for(int i = 1;i<=N;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}