/*
 * 1. 현재 리스트 크기, 태수 점수, 최대 등수 입력 받기 -> 만약 리스트가 0 이면 무조건 1등
 * 2. 점수 리스트 입력 받기
 * 3. 리스트를 순회 하며 현재 점수의 등수 찾기 -> 점수 >= 순회 중인 점수
 * 	3.1. 해당 점수를 가진 배열의 index+1이 등수
 * 	3.1.1 만약 동일한 점수로 등수가 나온다면 뒤에 동일한 점수가 있는지 체크하며 sameCount 계산
 * 4. rank이 최대 랭킹 보다 큰경우 -1 출력
 * 	4.1 동점자가 있는 경우 rank + 1 (=> 가장 뒤에있는 사람 다음)이  최대 랭킹 보다 크면 -1 출력
 * 5. 아닌 경우 rank 출력
 * 	5.1 동점자가 있는 경우 rank - smaeCount+1 출력
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 배열 크기
		int N = Integer.parseInt(st.nextToken());
		//태수 새 점수
		int score = Integer.parseInt(st.nextToken());
		//최대 랭킹
		int P = Integer.parseInt(st.nextToken()); 
		//리스트에 사람이 없는 경우
		if(N==0) {
				System.out.println(1);
		}else {
			//현재 점수 배열
			int[] scores = new int[N];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0; i<N;i++) {
				scores[i] = Integer.parseInt(st2.nextToken());
			}
			//랭킹
			int rank = N+1;
			int sameCount = 0;
			for(int i = 0; i<N;i++) {
				if(scores[i]<score&&sameCount==0) {
					//바로 랭킹을 바꾸고 탈출
					rank = i+1;
					break;
				}else if(scores[i]==score) {
					//가장 뒤의 사람의 등수 및 동점자 숫자 확인
					rank = i+1;
					sameCount++;
				}
			}
			//동점자가 있는 경우
			if(sameCount != 0) {
				if(rank +1 > P) {
					System.out.println(-1);
				}else {
					//동점자만큼 빼준 것이 등수
					System.out.println(rank-sameCount+1);
				}
			}
			//동점자가 없는 경우
			else {
				if(rank>P) {
					System.out.println(-1);
				}else {
					System.out.println(rank);
				}
			}
		}
	}
}