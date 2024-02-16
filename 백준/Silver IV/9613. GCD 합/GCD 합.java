/*
 * 문제
 * 1. 테케 주어짐
 * 2. 나올 숫자 갯수와 숫자 주어짐
 * 3. 모든 최소 공약수의 합 구하기
 * 
 * 풀이
 * 1. 테케 입력
 * 2. 나올 숫자 갯수 입력->arr[N]만들기
 * 3. 배열 채우기
 * 4. 조합 돌면서 최소 공배수의 합 구하기
 * 
 * 조합
 * 1. depth가 2이면 최소 공배수 구하고 더해주기
 * 2. for문 돌기 start~N
 * 	2.1. picked[depth] = arr[i]
 * 	2.2. 조합 돌리기(depth+1,i+1)
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static long answer;
	static int[] picked;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			answer = 0;
			picked = new int[2];
			Arrays.sort(arr);
			for(int i = 0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			recur(0,0);
			System.out.println(answer);
		}
	}
	public static void recur(int depth,int start) {
		if(depth==2) {
			answer += gcd(picked[1],picked[0]);
			return;
		}
		for(int i = start;i<N;i++) {
			picked[depth] = arr[i];
			recur(depth+1,i+1);
		}
	}
	public static int gcd(int a, int b) {
		if(a<b) {
			int temp = a;
			a = b;
			b = temp;
		}
		if(a%b==0) return b;
		return gcd(a%b,b);
	}
}