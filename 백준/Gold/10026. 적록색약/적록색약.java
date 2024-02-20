import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] arr;
	static int N;
	static boolean[][] checked;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for(int i = 0 ;i<N;i++) {
			String temp = br.readLine();
			for(int j = 0;j<N;j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		checked = new boolean[N][N];
		int answer = 0;
		for(int i = 0 ;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(checked[i][j]) continue;
				dfs1(i,j,arr[i][j]);
				answer++;
			}
		}
		System.out.print(answer+" ");
		checked = new boolean[N][N];
		answer = 0;
		for(int i = 0 ;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(checked[i][j]) continue;
				dfs2(i,j,arr[i][j]);
				answer++;
			}
		}
		System.out.println(answer);
	}
	static void dfs1(int r, int c,char color) {
		checked[r][c] = true;
		for(int k = 0;k<4;k++) {
		int nr = r +dir[k][0];
		int nc = c + dir[k][1];
		if(nr<0 || nc<0 || nr >= N || nc >= N) continue;
		if(arr[nr][nc]!=color) continue;
		if(checked[nr][nc]) continue;
		checked[nr][nc]= true;
		dfs1(nr,nc,color);
	}
	}
	static void dfs2(int r, int c,char color) {
		checked[r][c] = true;
		for(int k = 0;k<4;k++) {
		int nr = r +dir[k][0];
		int nc = c + dir[k][1];
		if(nr<0 || nc<0 || nr >= N || nc >= N) continue;
		if(arr[nr][nc]!='B') {
			if(color=='B') continue;
		}
		if(arr[nr][nc]=='B') {
			if(!(color=='B')) continue;
		}
		if(checked[nr][nc]) continue;
		checked[nr][nc]= true;
		dfs2(nr,nc,color);
	}
	}
}