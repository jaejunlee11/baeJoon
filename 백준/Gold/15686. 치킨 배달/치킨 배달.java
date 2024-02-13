/*
 * 문제
 * 1. 치킨 집, 빈칸, 집이 존재
 * 2. 각 집에서의 최소 치킨집 거리가 치킨 거리
 * 3. 도시의 치킨 거리는 모든 집의 치킨 거리의 합
 * 4. 폐업 후의 치킨 거리의 최소 값 구하기
 * 
 * 풀이
 * 1. 도시 크기 N(50) , 남길 치킨집 입력 받기 M (13)
 * 2. 치킨 집 리스트 만들기int[] 를 받는, 도시 리스트 만들기 int[]를 받는
 * 3. 치킨 집, 집 리스트 채우기
 * 4. 치킨 집, 집 리스트 배열로 바꾸기(?)
 * 5. 조합을 돌면서 치킨 거리 최소값 구하기
 * 
 * 조합
 * 1. depth가 M이 될때
 * 	1.1. 각 집에서의 치킨 거리 계산
 * 2. for문 돌리기(start~치킨 집)
 * 	2.1. picked[depth] = i;
 * 	2.2. recur(depth+1,i+1)
 * 
 * 시간 복잡도
 * 1. 13C6(720) * 100 * 6 = 4200만 충분
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int chickCount;
	static int homeCount;
	static int[][] homeArr;
	static int[][] chickArr;
	static int[] picked;
	static int minValue = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());
		List<int[]> home = new ArrayList<>();
		List<int[]> chicken = new ArrayList<>();
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				String temp = st.nextToken(); 
				if(temp.equals("1")) {
					home.add(new int[] {i,j});
				}else if(temp.equals("2")) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		chickCount = chicken.size();
		homeCount =home.size();
		homeArr = home.toArray(new int[homeCount][2]);
		chickArr = chicken.toArray(new int[chickCount][2]);
		picked = new int[M];
		recur(0,0);
		System.out.println(minValue);
	}
	
	public static void recur(int depth,int start) {
		if(depth==M) {
			int temp = 0;
			for(int i = 0;i<homeCount;i++) {
				int tempMin = Integer.MAX_VALUE;
				for(int j = 0;j<M;j++) {
					tempMin = Math.min(tempMin,(Math.abs(homeArr[i][0]-chickArr[picked[j]][0])+Math.abs(homeArr[i][1]-chickArr[picked[j]][1])));
				}
				temp += tempMin;
			}
			minValue=Math.min(minValue, temp);
			return;
		}
		for(int i = start;i<chickCount;i++) {
			picked[depth] = i;
			recur(depth+1,i+1);
		}
	}
}