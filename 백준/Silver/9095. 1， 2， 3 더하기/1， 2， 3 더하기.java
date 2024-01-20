import java.util.Arrays;

/*
 * 1. 1 -> 마지막 1 : 1 , 마지막 2 : 0, 마지막이 3 : 0
 * 2. 2 -> 마지막 1 : 1 , 마지막 2 : 1, 마지막이 3 : 0
 * 3. 3 -> 마지막 1 : 2 , 마지막 2 : 1, 마지막이 3 : 1
 * 4. 4 -> 마지막 1 : 4 , 마지막 2 : 2, 마지막이 3 : 1
 * 5. N -> 마지막 1 : 이전 것 합 , 마지막 2 : 이전 마지막 1, 마지막이 3 : 이전 마지막 2
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] tests = new int[T];
		int testMax = 0;
		for(int test_case = 0; test_case < T;test_case++) {
			tests[test_case] = Integer.parseInt(br.readLine());
			if(tests[test_case]>testMax) testMax = tests[test_case];
		}
		int[][] answers = new int[testMax+1][3];
		answers[1][0] = 1;
		for(int i = 2;i<=testMax;i++) {
			answers[i][0] = answers[i-1][0]+answers[i-1][1]+answers[i-1][2];
			answers[i][1] = answers[i-1][0];
			answers[i][2] = answers[i-1][1];
		}
		for(int test_case = 0; test_case < T;test_case++) {
			System.out.println((answers[tests[test_case]][0]+answers[tests[test_case]][1]+answers[tests[test_case]][2]));
		}
	}
}
