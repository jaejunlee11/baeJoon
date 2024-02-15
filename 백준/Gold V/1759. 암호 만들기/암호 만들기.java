/*
 * 문제
 * 1.암호가 모음과 자음으로 주어짐
 * 2. 모음은 최소 1, 자음은 최소 2
 * 3. 알파벳은 오름차순
 * 4. 가능한 조합 구하기
 * 
 * 풀이
 * 1. L,C입력 받기 -> 열쇠 자리, 주어진 영어
 * 2. arr[C]만들기
 * 3. arr 입력 받기 -> arr 정렬
 * 4. 조합 돌기
 * 
 * 조합
 * 1. depth == L인 경우
 * 	1.1. 자음2, 모음1 확인
 * 	1.2. 괜찮으면 출력
 * 2. for문 돌기 -> start - C
 * 	2.1. picked[dept] = arr[i]
 * 	2.2. 조합 돌리기 (depth+1, i+1)
 */
import java.io.*;
import java.util.*;

public class Main {
	static int L;
	static int C;
	static String[] arr;
	static String[] picked;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new String[C];
		picked = new String[L];
		for(int i= 0;i<C;i++) {
			arr[i] = st.nextToken();
		}
		Arrays.sort(arr);
		recur(0,0);
		System.out.println(sb);
	}
	private static void recur(int depth,int start) {
		if(depth==L) {
			String temp ="";
			int mo = 0;
			int ja = 0;
			for(int i =0 ;i<L;i++) {
				temp += picked[i];
				if(picked[i].equals("i") ||picked[i].equals("e") ||picked[i].equals("a") ||picked[i].equals("o") || picked[i].equals("u")) {
					mo++;
				}else {
					ja++;
				}
			}
			if(mo>0&&ja>1) {
				sb.append(temp+"\n");
			}
			return;
		}
		for(int i = start ;i<C;i++) {
			picked[depth] = arr[i];
			recur(depth+1,i+1);
		}
	}
}