/*
 * 문제
 * 1. 8*8을 만들때 
 * 2. 흰색 검정이 번갈아서 나오도록 만들어야함
 * 3. 판을 바꿔서 해당 조건이 맞도록 만드는 방법
 * 
 * 풀이
 * 1. N M 입력
 * 2. arr[N][M]생성
 * 3. arr 입력
 * 4. for(int i = 0;i<N-8;i++)
 * 5. 	for(int j = 0;j<M-8;j++)
 * 			5.1.count = 0; 으로 시작 -> 틀린 갯수
 * 			5.2. color = arr[i][j]의 값을 저장 		
 * 6. 		for(int k = 0;k<8;k++)
 * 7.			for(int l = 0;l<8;l++)
 * 8.				if(k+l%2==0)
 * 9.					color랑 다르면 count++
 * 10.				else
 * 11.					color랑 같으면 count++
 * 12.     count가 32보다 크면 count-32해주기
 * 13. count 최소값 갱신  	
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i = 0 ;i<N;i++) {
			String temp = br.readLine();
			for(int j = 0;j<M;j++) {
				if(temp.charAt(j)=='W') {
					arr[i][j] = 0;
				}else {
					arr[i][j] = 1;
				}
			}
		}
		int answer = Integer.MAX_VALUE;
		for(int i = 0;i<N-7;i++) {
			for(int j = 0;j<M-7;j++) {
				int color = arr[i][j];
				int count = 0;
				for(int k = 0 ;k<8;k++) {
					for(int l = 0;l<8;l++) {
						if((k+l)%2==0) {
							if(arr[i+k][j+l]!=color) {
								count++;
							}
						}else {
							if(arr[i+k][j+l]==color) {
								count++;
							}
						}
					}
				}
				if(count>=32) count=64-count;
				if(answer>count) answer = count;
			}
		}
		System.out.println(answer);
	}
}