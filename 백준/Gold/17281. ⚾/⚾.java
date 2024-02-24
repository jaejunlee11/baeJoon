/*
 * 문제
 * 1. 9명으로 이루어진 팀 존재
 * 2. 각 이닝 별 결과가 주어져 있음
 * 3. 1번 선수는 4번 타석 고정
 * 4. 최다득점 구하기
 * 
 * 풀이
 * 1. 순열로 8명의 선수의 순번 결정
 * 2. 득점 구하기
 * 	2.1. 현재타석 -> nowP = 1로 시작
 * 	2.2. 현재 아웃 카운트 -> nowO = 0로 시작
 * 	2.3. 현재 주자 배열 -> runnerArr[] ={0,0,0}
 * 	2.4. 1,2,3,4 => ruunerArr에 따라 득점 변경 + runnerArr변경
 * 	2.5. 0인 경우 => nowO증가 => 3이되는 경우 전부 초기화 후 다시 시작
 * 
 * 순열
 * 1. depth==9인 경우
 * 	1.1. 득점 구하기 + 최대값 갱신
 * 2. for(2~9)
 * 	2.0. depth가 4인 경우 depth++
 * 	2.1. visited[i] true
 * 	2.2. picked[depth] = i
 * 	2.3. recur(depht+1)
 * 	2.4. visited[i] false
 * 
 * 시간 복잡도
 * 1. 8! * 27 * 10 => 
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static int[] picked;
	static boolean[] visited;
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		for(int i =0 ;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j<9;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		picked = new int[9];
		visited = new boolean[9];
		recur(0);
		System.out.println(answer);
	}
	static void recur(int depth) {
		if(depth==9) {
			int temp = getPoint();
			answer = Math.max(temp, answer);
			return;
		}
		for(int i = 1;i<9;i++) {
			if(visited[i]) continue;
			if(depth==3) depth++;
			picked[depth] = i;
			visited[i] = true;
			recur(depth+1);
			visited[i] = false;

		}
	}

	static int  getPoint() {
		//		System.out.println(Arrays.toString(picked));
		int point = 0;
		int nowP = 0;//현재 순번
		A : for(int i = 0;i<N;i++) {
			int nowO = 0;//out카운트
			int[] runnerArr = {0,0,0};//현재 주자들
			//타격
			while(true) {
				int result = arr[i][picked[nowP]];
				switch(result){
				case 0 :
				{
					nowO++;
					nowP++;
					if(nowP==9) nowP=0;
					if(nowO==3) continue A;
					break;
				}
				case 1 :
				{
					if(runnerArr[2]==1) {
						point++;
					}
					runnerArr[2] = runnerArr[1];
					runnerArr[1] = runnerArr[0];
					runnerArr[0] = 1;
					nowP++;
					if(nowP==9) nowP=0;
					break;
				}
				case 2 :
				{
					for(int j = 1;j<3;j++) {
						if(runnerArr[j]==1) {
							point++;
						}
					}
					runnerArr[2] = runnerArr[0];
					runnerArr[1] = 1;
					runnerArr[0] = 0;
					nowP++;
					if(nowP==9) nowP=0;
					break;
				}
				case 3 :
				{
					for(int j = 0;j<3;j++) {
						if(runnerArr[j]==1) {
							point++;
						}
					}
					runnerArr[2] = 1;
					runnerArr[1] = 0;
					runnerArr[0] = 0;
					nowP++;
					if(nowP==9) nowP=0;
					break;
				}
				case 4 :
				{
					for(int j = 0;j<3;j++) {
						if(runnerArr[j]==1) {
							point++;
						}
					}
					point++;
					runnerArr[2] = 0;
					runnerArr[1] = 0;
					runnerArr[0] = 0;
					nowP++;
					if(nowP==9) nowP=0;
					break;
				}
				}	
			}

		}
		return point;
	}
}