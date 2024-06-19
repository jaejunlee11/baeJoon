import java.io.*;
import java.util.*;
/*
 * 문제
 * 1. 3*3격자판 존재
 * 2. 격자판을 채워나감
 * 3. 해당 판을 보고 가능한 것인지 확인
 * 
 * 풀이
 * 1. s 입력 받기
 * 2. arr[9] 생성, count1 = 0, count2 = 0
 * 3. arr채우기
 * 4. for문 돌리기 => 0~2
 * 	4.1. for문 돌리기 0~2, r=0, c=0
 * 		4.1.1. r += arr[i][j]
 * 		4.1.2. c += arr[j][i]
 * 	4.2. r==0 => count1++, r==3 => count2++
 * 	4.3. c==0 => count1++, c==3 => count2++
 * 	4.4. arr[0]+arr[4]+arr[8] == 0 => count1++, arr[0]+arr[4]+arr[8] == 3 => count2++
 * 	4.5. arr[2] + arr[4] + arr[6] == 0 => count1++, arr[2] + arr[4] + arr[6] == 3 => count2++
 * 5. count1>=1 && count2>=1 => invalid
 * 6. valid
 */
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s.equals("end")) break;
			int[] arr = new int[9];
			int oCount = 0;
			int xCount = 0;
			for(int i = 0;i<9;i++) {
				if(s.charAt(i)=='X') {
					arr[i]=0;
					xCount++;
				}else if(s.charAt(i)=='O') {
					arr[i]=1;
					oCount++;
				}else {
					arr[i]=100;
				}
			}
			if((xCount-oCount)!=1 && (xCount-oCount)!=0) {
				System.out.println("invalid");
				continue;
			}
			int count1=0;
			int count2=0;
			for(int i = 0;i<3;i++) {
				int r = 0;
				int c = 0;
				for(int j = 0;j<3;j++) {
					r+=arr[i*3+j];
					c+=arr[j*3+i];
				}
				if(r==0) {
					count1++;
				}
				if(c==0) {
					count1++;
				}
				if(r==3) {
					count2++;
				}
				if(c==3) {
					count2++;
				}
			}
			if((arr[0]+arr[4]+arr[8]) == 0) {
				count1++;
			}
			if((arr[0]+arr[4]+arr[8]) == 3) {
				count2++;
			}
			if((arr[2] + arr[4] + arr[6]) == 0) {
				count1++;
			}
			if((arr[2] + arr[4] + arr[6]) == 3) {
				count2++;
			}
			if(count1>=1 && count2>=1) {
				System.out.println("invalid");
			}else if(oCount+xCount==9){
				if(count2>=1) {
					System.out.println("invalid");
				}else {
					System.out.println("valid");
				}
			}else {
				if(count1>=1||count2>=1) {
					if(count1>=1 && oCount-xCount==0) {
						System.out.println("invalid");
					}else if(count2>=1 && oCount-xCount<0) {
						System.out.println("invalid");
					}else {
						System.out.println("valid");
					}
				}else {
					System.out.println("invalid");
				}
			}
		}
		
	}
}