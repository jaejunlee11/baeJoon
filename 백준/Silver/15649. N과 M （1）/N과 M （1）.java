
/*
 * 1. N M 입력 받기
 * 2. 재귀 함수 돌리기 -> idx -> 현재 배열 길이
 * 3. 들렸던 것인지 확인 -> visited
 * 4. 담겨있는 배열 -> arr
 */
import java.io.*;
import java.util.*;

public class Main {
	static public int N;
	static public int M;
	static public int[] arr;
	static public boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N+1];
		recur(0);
	}
	
	public static void recur(int idx) {
		if(idx==M) {
			for(int i :arr) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i<=N;i++) {
			if(visited[i]) continue;
			arr[idx] = i;
			visited[i] = true;
			recur(idx+1);
			visited[i] = false;
		}
	}
}
