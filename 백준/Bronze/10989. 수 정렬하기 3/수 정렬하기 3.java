import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		for(int i = 0;i<N;i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0 ;i<10001;i++) {
			sb.append((i+"\n").repeat(arr[i]));
		}
		System.out.println(sb);
	}
}