import java.io.*;
import java.util.*;


/*
 * 문제
 * 1. L개의 암호문 갯수, C개의 암호 문자
 * 2. 암호 문자가 주어짐
 * 3. 가능한 암호 조합 출력 -> 조건 오름차순, 모음1개, 자음 2개
 * 
 * 풀이
 * 1. L개의 암호문 갯수, C개의 암호문자 입력
 * 2. arr[L] 생성
 * 3. arr챙우기 -> arr 정렬
 * 4. 조합을 돌면서 출력
 * 
 * 0.used
 * 조합
 * 1. L개가 차면 종료 후 조건 체크
 * 	1.1. 모음1개, 자음2개 확인
 * 	1.2. used를 붙여서 출력
 * 2. for문 돌기(start ~ C)
 * 	2.1. used에 채우기
 * 	2.2. (depth+1,i+1)
 */
public class Main {
	static int L;
	static int C;
	static int[] used;
	static int[] arr;
	static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr =new int[C];
		used = new int[L];
		for(int i = 0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0) - 'a';
		}
		Arrays.sort(arr);
		recur(0,0);
		System.out.println(answer);
	}
	static void recur(int depth, int start) {
		if(depth == L) {
			int mo = 0;
			int za = 0;
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<L;i++) {
				int temp = arr[used[i]];
				if(temp==0 || temp==4 ||temp==8||temp==14||temp == 20) {
					mo++;
				}else {
					za++;
				}
				sb.append((char)(temp+'a'));
			}
			if(mo>=1 && za >=2) {
				answer.append(sb + "\n");
			}
			return;
		}
		
		for(int i = start;i<C;i++) {
			used[depth] = i;
			recur(depth+1,i+1);
		}
	}
}