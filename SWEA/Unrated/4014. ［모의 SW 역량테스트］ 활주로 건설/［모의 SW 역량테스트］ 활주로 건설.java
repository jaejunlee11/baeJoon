
/*
 * 문제
 * 1. N*N활주로 존재 => 20최대 
 * 2. 가로 또는 세로로 설치 가능한지 확인
 * 3. 경사로를 설치하여 연결 시켜주는 것 가능 
 * 4. 경사로의 길이가 x => x가 넘어가면 설치 불가능
 * 5. 경사로가 설치 가능한 갯수 구하기
 * 
 *  풀이
 *  1. 테케 입력
 *  2. N,X입력
 *  3. arr[N][N]생성
 *  4. arr입력
 *  5. for문 돌기 => N
 *  	5.0. start = arr[i][0], count = 1, count2 = 0
 *  	5.1.for문 돌기 =>1~N-1
 *  		5.1.1. start와 동일하면 cout2==0 이면 count++, 아니면 count2--
 *  		5.1.2. start 보다 1크면 count가 x보다 작은 경우 종료
 *  		5.1.3. start 보다 1크고 count가 더 큰경우 count=1, start 갱신
 *  		5.1.4. start 보다 1작으면 count2가 0이 아닌 경우 종료
 *  		5.1.5. start 보다 1작고 조건에 안걸리면 count2=x-1, count=0
 *  		5.1.6. 2이상 차이나면 종료
 *  	5.2.  끝까지 도달시 answer ++; 
 *  
 *  시간 복잡도
 *  1. 20 * 20 + 20*20 => 800 충분 
 */
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t =1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for(int i = 0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = 0;
			A : for(int i = 0;i<N;i++) {
				int start = arr[i][0];
				int count1 = 1;
				int count2 = 0;
				for(int j = 1;j<N;j++) {	
					int temp = arr[i][j];
					if(Math.abs(temp-start)>=2) continue A;
					if(temp==start) {
						if(count2>0) count2--;
						else count1++;
					}else if(temp>start) {
						if(count1<X) continue A;
						count1 = 1;
						start = temp;
					}else if(temp<start) {
						if(count2!=0) continue A;
						count2 = X-1;
						count1 = 0;
						start = temp;
					}
				}
				if(count2!=0) continue A;
//				System.out.println(start+" " + i);
				answer++;
			}
			A : for(int i = 0;i<N;i++) {
				int start = arr[0][i];
				int count1 = 1;
				int count2 = 0;
				for(int j = 1;j<N;j++) {
					int temp = arr[j][i];
					if(Math.abs(temp-start)>=2) continue A;
					if(temp==start) {
						if(count2>0) count2--;
						else count1++;
					}else if(temp>start) {
						if(count1<X) continue A;
						count1 = 1;
						start = temp;
					}else if(temp<start) {
						if(count2!=0) continue A;
						count2 = X-1;
						count1 = 0;
						start = temp;
					}
				}
				if(count2!=0) continue A;
//				System.out.println(start+" " + i);
				answer++;
			}
			System.out.println("#" + t+" "+answer);
		}
	}
}
