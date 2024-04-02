/*
 * 문제
 * 1. 기타가 존재
 * 2. 기타는 노래할 수 있는 곡이 존재
 * 3. 최소한의 기타로 모든 노래 연주하기
 * 
 * 풀이
 * 1. N, M입력
 * 2. arr String[N][2] 생성
 * 3. arr 입력
 * 4. songs[N][M]생성
 * 5. for문 돌리기 N
 * 	5.1. arr[i][1].chartAt을 통해서 songs채우기
 * 6. for문 돌리기 N
 * 	6.1. 조합으로 N개 뽑기
 * 		6.1.1. 전부 완료되면 종료 => i출력후 종료
 * 7. -1 출력
 * 
 * 조합(index,depth, n)
 * 1. depth==n
 * 	1.1. for문 돌기 n
 * 		1.1.1. songs[picked[i]]를 순회하면서 true인 것 set에 넣기
 * 	1.2. set의 크기가 n이면 true리턴
 * 2. for문 돌리기 index~N
 * 	2.1. picked[depth] = i;
 * 	2.2. if(recur(i+1,depth+1,n)) return
 * 3. return false
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int songNum;
	static String[][] arr;
	static boolean[][] songs;
	static int[] pikced;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new String[N][2];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		songs = new boolean[N][M];
		for(int i = 0;i<N;i++) {
			String temp = arr[i][1];
			for(int j = 0;j<M;j++) {
				char pass = temp.charAt(j);
				if(pass=='Y') songs[i][j] = true;
			}
		}
		Set<Integer> set = new HashSet<>();
		for(int i = 0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(songs[i][j]) set.add(j);
			}
		}
		songNum = set.size();
		if(songNum==0) {
			System.out.println("-1");
			return;
		}
		for(int i = 1;i<=N;i++) {
			pikced = new int[i];
			if(recur(0,0,i)) {
				System.out.println(i);
				return;
			}
		}
	}
	private static boolean recur(int index,int depth, int n) {
		if(depth==n) {
			Set<Integer> set = new HashSet<>();
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<M;j++) {
					if(songs[pikced[i]][j]) set.add(j);
				}
			}
			if(set.size()==songNum) return true;
			return false;
		}
		for(int i = index;i<N;i++) {
			pikced[depth] = i;
			if(recur(i+1,depth+1,n)) return true;
		}
		return false;
	}
}