/*
 * 문제
 * 1. 3의 거듭 제곱의 형태로 수가 주어짐
 * 2. 가운데가 빈형태의 별을 찍어야함 -> 각 3의 거듭 제곱의 가운데 위치 마다 빈칸
 * 
 * 풀이
 * 1. 전체에 별을 찍는다고 가정
 * 2. n입력 받기 -> 3^k => k구하기
 * 3. if((i%3^j) == 3의 제곱 값시작점) => 3의 제곱 값 만큼 빈칸 출력 후 j를 그만큼 이동
 * 
 * 시간 복잡도
 * 1. k가 8일 경우 -> 4천만 * 8 =>3억 2천
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int maxK = (int) Math.pow(N, 1.0/3.0);
		int K = 1;
		int x = 3;
		boolean flag = false;
		StringBuilder sb =  new StringBuilder();
		for(int i =0;i<N/3;i++) {
			//i값에 따라서 제한이 가능 -> 3,3,3,9,3,3,3 => 81인 경우 -> 3,3,3,9,9,27,9,9,3,3 => 243인 경우 -> 3(1),3(2),3(1),9(3),9(2),27(4),27(3),81(5),27(3),27(4),9(2),9(3),3(1),3(2),3(1)
			if(i%(x)==0) {
				if(flag) {
					K--;
					x/=3;
				}else {
					K++;
					x*=3;
					if(K==maxK) flag=true;
				}
				
			}
			A : for(int j = 0;j<N;j++) {
				
				for(int k = 1;k<=K;k++) {
//					if((i/((int) Math.pow(3, k))) + (i%((int) Math.pow(3, k))) >= (int) Math.pow(3, k-1) && (i/((int) Math.pow(3, k))) + (i%((int) Math.pow(3, k))) < ((int) Math.pow(3, k-1)) *2 && (j/((int) Math.pow(3, k))) + (j%((int) Math.pow(3, k))) >= (int) Math.pow(3, k-1) && (j/((int) Math.pow(3, k))) + (j%((int) Math.pow(3, k))) < ((int) Math.pow(3, k-1)) *2 ) {
					if((j%((int) Math.pow(3, k))) == (int) Math.pow(3, k-1) && (i%((int) Math.pow(3, k))) >= (int) Math.pow(3, k-1) && (i%((int) Math.pow(3, k))) < ((int) Math.pow(3, k-1)) *2 ) {
						j--;
						for(int l = 0 ; l<(int) Math.pow(3, k-1);l++) {
							sb.append(" ");
							j++;
						}
						continue A;
						}
					}
				sb.append("*");
			}
			sb.append("\n");
		}
		StringBuilder sb1 = new StringBuilder(sb.toString());
		for(int i =N/3;i<(N/3)*2;i++) {
			//i값에 따라서 제한이 가능 -> 3,3,3,9,3,3,3 => 81인 경우 -> 3,3,3,9,9,27,9,9,3,3 => 243인 경우 -> 3(1),3(2),3(1),9(3),9(2),27(4),27(3),81(5),27(3),27(4),9(2),9(3),3(1),3(2),3(1)
			if(i%(x)==0) {
				if(flag) {
					K--;
					x/=3;
				}else {
					K++;
					x*=3;
					if(K==maxK) flag=true;
				}
				
			}
			A : for(int j = 0;j<N;j++) {
				
				for(int k = 1;k<=K;k++) {
//					if((i/((int) Math.pow(3, k))) + (i%((int) Math.pow(3, k))) >= (int) Math.pow(3, k-1) && (i/((int) Math.pow(3, k))) + (i%((int) Math.pow(3, k))) < ((int) Math.pow(3, k-1)) *2 && (j/((int) Math.pow(3, k))) + (j%((int) Math.pow(3, k))) >= (int) Math.pow(3, k-1) && (j/((int) Math.pow(3, k))) + (j%((int) Math.pow(3, k))) < ((int) Math.pow(3, k-1)) *2 ) {
					if((j%((int) Math.pow(3, k))) == (int) Math.pow(3, k-1) && (i%((int) Math.pow(3, k))) >= (int) Math.pow(3, k-1) && (i%((int) Math.pow(3, k))) < ((int) Math.pow(3, k-1)) *2 ) {
						j--;
						for(int l = 0 ; l<(int) Math.pow(3, k-1);l++) {
							sb.append(" ");
							j++;
						}
						continue A;
						}
					}
				sb.append("*");
			}
			sb.append("\n");
		}
		sb.append(sb1);
		System.out.println(sb);
	}
}