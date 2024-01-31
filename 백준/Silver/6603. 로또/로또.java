/*
 * 문제
 * 1. 로또 갯수 입력 -> N범위 7~12
 * 2. 로또 종류 입력 -> 입력값 범위
 * 3. 로또 가능성 전부 출력
 * 4. 0 나오면 종료
 * 풀이 
 * 1. 로또 갯수 N입력(static)
 * 2. 로또 번호 배열 생성(static) -> 입력 받기(new로 다시 만들고 입력 받기) => lottoes
 * 3. 번호를 담아놓는 배열 생성(static) -> 6칸짜리 => numbers
 * 3. 재귀 돌리기 -> (idx = 0, start = 0)
 * 
 * 재귀 => 복잡도 대략 5
 * 1. idx가 6이면 bumbers 원소 출력 후 종료
 * 2. for문 돌리기 (start->N-1) 반복
 * 	2.1. numbers에 원소 넣기
 * 	2.2. 재귀 돌리기 -> (idx +1, start = i+1)
 * 
 * 시간 복잡도 -> 12C6 * 5 * test_case 정도 => 약 5000*테스트 케이스=> 시간초과 나도록 짜놓지는 않았을 듯(그래도 print가 많으니 StringBuilder사용)
 * + StringBuilder static으로 만들기
 * 
 * 체크리스트
 * 1. 변수 타입 => int 타입으로 충분
 * 2. 오버플로우 => 더하기 연산 X 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] lottoes;
	public static int[] numbers = new int[6];
	public static StringBuilder sb =new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			lottoes = new int[N];
			for(int i = 0;i<N;i++) {
				lottoes[i]= Integer.parseInt(st.nextToken());
			}
			recur(0,0);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static void recur(int idx,int start) {
		if(idx==6) {
			for(int lotto : numbers) {
				sb.append(lotto + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start ; i<N;i++) {
			numbers[idx] = lottoes[i];
			recur(idx+1,i+1);
		}
	}
}