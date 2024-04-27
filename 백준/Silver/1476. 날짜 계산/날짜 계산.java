
/*
 * 문제
 * 1. 지구, 태양, 달 
 * 2.각 숫자가 올라감
 * 3. 범위가 넘어가면 다시 1로 초기화
 * 4. 현재 숫자를 보고 1 1 1 에서 시작해서 몇년이 지났는가? 
 * 
 * 풀이
 * 1. e, s, m입력, startE = 1, startS = 1, startM = 1
 * 2. for문 돌리기 => 1 ~ 15*28*19 + 1
 * 	2.1. if(startE == e, ..) i 출력 후 종료
 * 	2.2. startE ++ 후 % 계산
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int startE = 1;
		int startS = 1;
		int startM = 1;
		int count = 1;
		while(true) {
			if(startE==e && startS == s && startM == m) {
				System.out.println(count);
				return;
			}
			count++;
			startE++;
			startS++;
			startM++;
			startE = startE % 15;
			startS = startS % 28;
			startM = startM % 19;
			if(startE==0) {
				startE = 15;
			}
			if(startS==0) {
				startS = 28;
			}
			if(startM==0) {
				startM = 19;
			}
		}
	}
}
