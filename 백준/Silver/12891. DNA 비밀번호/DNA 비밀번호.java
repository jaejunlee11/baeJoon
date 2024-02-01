/*
 * 문제 
 *	1. DNA문자열 길이 입력, 부분 문자열의 길이 입력 -> 1000000이하
 *	2. DNA문자열 입력
 *	3. ACGT순으로 최소 등장 숫자 입력 
 *	4. 문자열을 잘라서 확인하면서 조건 만족시 +1
 * 플이
 *  1. DNA문자열 길이 입력 dnaL(static),  부분 문자열의 길이 입력 -> subL(static)
 *  2. 각 dna문자열의 길이를 담을 배열 생성(static) -> actg[4];
 *  3. DNA문자열을 저장 arr
 *  4. for문으로 부분 문자열의 길이만큼만 charat으로 actg에 맞게 ++ =>체크해서 조건 맞으면 ++
 *  5. for문으로 전체 문자열 길이 -부분문자여의 길이만큼 돌기
 *  	5.1. i번째 문자 --, i+부분문자열의 길이 ++
 *   	5.2. 체크해서 조건 맞으면 ++
 *   6.출력
 *   
 *   시간 복잡도
 *   1. 문자 비교, 조건체크 6번?
 *   2. 1000000개정도
 *   3. 안날듯
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int dnaL = Integer.parseInt(st.nextToken());
		int subL = Integer.parseInt(st.nextToken());
		
		int[] actg = new int[4];
		int[] check = new int[4];
		String arr = br.readLine();
		//첫번째 sub문자열 담기
		for(int i = 0;i<subL;i++) {
			switch(arr.charAt(i)) {
			case 'A':{
				actg[0]++;
				break;
			}
			case 'C':{
				actg[1]++;
				break;
			}
			case 'G':{
				actg[2]++;
				break;
			}
			case 'T':{
				actg[3]++;
				break;
			}
			}
		}
		//열쇠 갯수
		int count= 0 ;
		//조건 체크 배열
		st = new StringTokenizer(br.readLine());
		check[0]=Integer.parseInt(st.nextToken());
		check[1]=Integer.parseInt(st.nextToken());
		check[2]=Integer.parseInt(st.nextToken());
		check[3]=Integer.parseInt(st.nextToken());
		//조건 체크
		boolean flag =true;
		for(int i = 0;i<4;i++) {
			if(check[i]>actg[i]) {
				flag = false;
				break;
			}
		}
		if(flag) count ++;
		
		//뒤쪽 순회
		for(int k =0;k<(dnaL-subL);k++) {
			switch(arr.charAt(k)) {
			case 'A':{
				actg[0]--;
				break;
			}
			case 'C':{
				actg[1]--;
				break;
			}
			case 'G':{
				actg[2]--;
				break;
			}
			case 'T':{
				actg[3]--;
				break;
			}
			}
			
			switch(arr.charAt(k+subL)) {
			case 'A':{
				actg[0]++;
				break;
			}
			case 'C':{
				actg[1]++;
				break;
			}
			case 'G':{
				actg[2]++;
				break;
			}
			case 'T':{
				actg[3]++;
				break;
			}
			}
			//조건 체크
			flag =true;
			for(int i = 0;i<4;i++) {
				if(check[i]>actg[i]) {
					flag = false;
					break;
					
				}
			}
			if(flag) count ++;
		}
		System.out.println(count);
	}
	
}