/*
 * 문제
 * 1. 도시 갯수 주어짐 N
 * 2. 도시의 거리가 주어짐
 * 3. 도시의 기름 가격이 주어짐
 * 4. 가장 싸게 주유해서 갈 수 있는 최소 값
 * 
 * 풀이
 * 1. 도시 갯수를 입력 받음 N
 * 2. 도시까지의 거리 배열 dis[N-1]
 * 3. 주유 가격 배열 gas[N]
 * 4. for문 돌기
 * 	4.1. 다음 도시 가격 확인 -> 더 비싼 경우 그 다음 도시도 확인 -> 제일 싼 도시 까지의 거리 * 비용
 * 5.출력
 * 
 * 생각할 것
 * 1. long타입
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dis = new int[N-1];
		int[] gas = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N-1;i++) {
			dis[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			gas[i] = Integer.parseInt(st.nextToken());
		}
		long answer = 0 ;
		for(int i = 0;i<N-1;) {
			if(i==N-2) {
				answer += (gas[i]*dis[i]);
				break;
			}
			if(gas[i]>gas[i+1]) {
				answer += (gas[i]*dis[i]);
				i++;
			}
			else {
				for(int j = i+1;j<N;j++) {
					if(j==N-1) {
						answer+=gas[i]*dis[j-1];
						i=j;
						break;
						}
					if(gas[i]>gas[j]) {
						i=j;
						break;
					}else {
						answer+=gas[i]*dis[j-1];
					}
				}
			}
		}
		System.out.println(answer);
 	}
}