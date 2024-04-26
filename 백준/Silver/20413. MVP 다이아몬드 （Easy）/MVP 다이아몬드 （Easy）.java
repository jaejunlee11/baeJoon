import java.io.*;
import java.util.*;
/*
 * 문제
 * 1. 2개월 동안의 과금액으로 등급이 측정
 * 2. 과금은 다이아몬드 기준치 까지만
 * 3. 한번 올라가면 더 이상 안내려감
 * 4. 최대 과금액 구하기
 * 
 * 풀이
 * 1. point[4]생성
 * 2. N입력
 * 3. point채우기
 * 4. mvp 입력 , answerArr[N+1]
 * 5. for문 돌리기 => 1, N
 * 	5.1. charAt == B
 * 		5.1.1. answer[i] = Math.max((point[0]-1-answerArr[i-1]),0)
 * 6. answerArr합 구하기
 */
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] point = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<4;i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		String mvp = br.readLine();
		int[] answerArr = new int[N+1];
		for(int i = 1;i<=N;i++) {
			if(mvp.charAt(i-1)=='B') {
				answerArr[i] = Math.max((point[0]-1-answerArr[i-1]),0);
			}else if(mvp.charAt(i-1)=='S') {
				answerArr[i] = Math.max((point[1]-1-answerArr[i-1]),0);
			}else if(mvp.charAt(i-1)=='G') {
				answerArr[i] = Math.max((point[2]-1-answerArr[i-1]),0);
			}else if(mvp.charAt(i-1)=='P') {
				answerArr[i] = Math.max((point[3]-1-answerArr[i-1]),0);
			}else {
				answerArr[i] = point[3];
			}
		}
		int answer = 0;
		for(int i : answerArr) {
			answer+=i;
		}
		System.out.println(answer);
	}
}
/*
5
10 20 30 40
BPDDD
*/