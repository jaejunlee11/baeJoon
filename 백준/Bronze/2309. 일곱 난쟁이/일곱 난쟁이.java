/*
 * 문제
 * 1. 9난쟁이 키 입력 받기
 * 2. 7명으로 키 100 만들기
 * 3. 7명 오름차순으로 출력 
 * 
 * 풀이
 * 1.9난쟁이 키 입력 받기 -> arr
 * 2.난쟁이 담을 배열 -> short[7]
 * 2.재귀->(depth,cm, start)
 * 
 * 재귀함수
 * 1.depth가 7이되었을때 (cm가 100이 되면 sysout으로 출력 -> return true) ->  return false
 * 2.for start부터 9까지 돌기
 * 3.short[depth] = arr[i]
 * 3.if 재귀(depth+1,cm+arr[i],i+1) : return true;
 * 4. return false
 */
import java.io.*;
import java.util.*;

public class Main {
	public static int[] shortP = new int[7];
	public static int[] arr = new int[9];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i  =0;i<9;i++) {
			arr[i] = sc.nextInt();
		}
		recur(0,0,0);
	}
	public static boolean recur(int depth,int cm, int start) {
		if(depth==7) {
			if(cm==100) {
				Arrays.sort(shortP);
				for(int i :shortP) {
					System.out.println(i);
				}
				return true;
			}
			return false;
		}
		for(int i = start;i<9;i++) {
			shortP[depth] = arr[i];
			if(recur(depth+1,cm+arr[i],i+1)) return true;
		}
		return false;
	}
}