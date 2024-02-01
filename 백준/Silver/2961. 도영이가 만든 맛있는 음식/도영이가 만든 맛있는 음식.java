import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 * 문제
 * 1. 요리 갯수 N입력
 * 2. 요리의 숫자 2개 입력
 * 	2.1. 섞었을 때 곱은 신맛
 * 	2.2. 섞었을 때 합은 쓴맛
 * 3.요리 여러개 섞어서 최소 만들기
 * 
 * 풀이
 * 0.minAnswer(static)최소 값
 * 1.요리 갯수 N입력 -> 요리 담을 배열 arr[N][2] 생성
 * 2.요리의 숫자 N번 입력
 * 	2.1. arr[N][0] = 신맛, arr[N][1] 쓴맛
 * 3.부분 집합 돌리기 => (depth)
 * 
 * 부분 집합
 * 1. 마지막 도달하면 arr[N][0]들의 곱, arr[N][1]들의 합 의 차 구하기 => minAnswer 랑 비교
 * 2. for문 돌리기 -> N만큼
 * 	2.1. true넣기 => recur(depth+1)
 * 	2.2.false넣기 => reucur(depth+1)
 */
public class Main {

	public static int N;
	public static int[][] arr;
	public static boolean[] picked;
	public static int minAnswer=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		picked = new boolean[N];
		StringTokenizer st;
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		recur(0,0);
		System.out.println(minAnswer);
	}

	public static void recur(int depth,int pickNum) {
		if(depth == N) {
			int sinTaste = 1;
			int senTaste = 0;
			for(int i = 0 ; i < N ;i ++) {
				if(picked[i]) {
					sinTaste *= arr[i][0];
					senTaste += arr[i][1];
				}
			}
			if(minAnswer>(Math.abs(sinTaste-senTaste)) && pickNum!=0) {
				minAnswer =Math.abs(sinTaste-senTaste);
			}
			return;
		}
		picked[depth] = true;
		recur(depth+1,pickNum+1);
		picked[depth] = false;
		recur(depth+1,pickNum);

	}
}