/*
 * 문제
 * 1. 음계 8개가 주어짐
 * 2. 연속으로 올라가면 ascending
 * 3. 연속으로 내려가면 descending
 * 4. 아니면 mixed
 * 
 * 풀이
 * 1. arr[8]생성
 * 2. arr 입력
 * 3. arr[0]가 8인 경우 
 * 	3.1. for문 돌기 (1~7)
 * 		3.1.1. arr[i] != 8-i면 mixed출력
 * 	3.2. dexcending 출력
 * 4. arr[1]이 1인 경우
 * 	4.1. for문 돌기 1~7
 * 		4.1.1. arr[i]!=i+1 이면 mixed출력
 * 	4.2.ascending 출력
 * 5. mixed출력   
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[8];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<8;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(arr[0]==1) {
			for(int i =1 ;i<8;i++) {
				if(arr[i]!=i+1) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("ascending");
		}else if(arr[0]==8) {
			for(int i =1;i<8;i++) {
				if(arr[i]!=8-i) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}
	}
}