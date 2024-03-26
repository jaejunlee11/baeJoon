/*
 * 문제
 * 1. 블록이 존재
 * 2. 블록 사이에 빗물이 고임
 * 3. 총 빗불의 숫자 구하기
 * 
 * 풀이
 * 1. H,W입력
 * 2. arr[W][H]생성 
 * 3. arr 채우기 
 * 3. for문 돌리기 H 
 * 	3.1. for문 돌리기 W =>flag= false, temp = 0
 * 		3.1.1. 0을 만나는 경우 => flag가 turue면 temp++
 * 		3.1.2. 1을 만나는 경우 => flag = true, answer+=temp, temp=0으로 초기화
 * 4. answer출
 * 
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] arr = new int[W][H];
		st = new StringTokenizer(br.readLine());
		for(int i= 0;i<W;i++) {
			int h = Integer.parseInt(st.nextToken());
			for(int j = 0;j<h;j++) {
				arr[i][j]=1;
			}
		}
		int answer = 0;
		for(int i = 0;i<H;i++) {
			boolean flag= false;
			int temp=0;
			for(int j = 0;j<W;j++) {
				if(arr[j][i]==0) {
					if(flag) {
						temp++;
					}
				}else {
					flag=true;
					answer+=temp;
					temp=0;
				}
			}
		}
		System.out.println(answer);
	}
}