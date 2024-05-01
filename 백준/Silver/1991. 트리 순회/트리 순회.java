/*
 * 문제
 * 1. 트리가 주어짐
 * 2. 트리 원소 수와 각 원소의 자식들이 주어짐
 * 3. 전위, 중위, 후위 순회 출력
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N][2] 생성
 * 3. arr 채우기
 * 4. dfs1(0)돌리기
 * 5. dfs2(0)돌리기
 * 6. dfs3(0)돌리기
 * 
 * dfs1(int now) => 전위 순회
 * 1. now출력
 * 2. arr[now][0]!=-1이면 dfs(arr[now][0])
 * 3. arr[now][1]!=-1이면 dfs(arr[now][1])
 * 
 * dfs2
 * 1. arr[now][0]!=-1이면 dfs(arr[now][0])
 * 2. now출력
 * 3. arr[now][1]!=-1이면 dfs(arr[now][1])
 * 
 * dfs3
 * 1. arr[now][0]!=-1이면 dfs(arr[now][0])
 * 2. arr[now][1]!=-1이면 dfs(arr[now][1])
 * 3. now출력
 */
import java.io.*;
import java.util.*;	
public class Main {
	static StringBuilder sb  = new StringBuilder();
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = st.nextToken().charAt(0)-'A';
			int b = st.nextToken().charAt(0)-'A';
			int c = st.nextToken().charAt(0)-'A';
			if(0<=b &&b<=25) {
				arr[a][0] = b;
			}else {
				arr[a][0] = -1;
			}
			if(0<=c && c<=25) {
				arr[a][1] = c;
			}else {
				arr[a][1] = -1;
			}
		}
		dfs1(0);
		sb.append("\n");
		dfs2(0);
		sb.append("\n");
		dfs3(0);
		System.out.println(sb);
	}
	private static void dfs1(int now) {
		sb.append((char)(now+'A'));
		if(arr[now][0]!=-1) dfs1(arr[now][0]);
		if(arr[now][1]!=-1) dfs1(arr[now][1]);
		
	}
	
	private static void dfs2(int now) {
		if(arr[now][0]!=-1) dfs2(arr[now][0]);
		sb.append((char)(now+'A'));
		if(arr[now][1]!=-1) dfs2(arr[now][1]);
		
	}
	
	private static void dfs3(int now) {
		if(arr[now][0]!=-1) dfs3(arr[now][0]);
		if(arr[now][1]!=-1) dfs3(arr[now][1]);
		sb.append((char)(now+'A'));
	}
}