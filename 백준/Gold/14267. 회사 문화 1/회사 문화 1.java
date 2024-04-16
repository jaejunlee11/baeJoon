import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 문제
 * 1. 상사가 직속 부하를 칭찬하면 뎐쇄적으로 내리 칭찬
 * 2. 모든 칭찬에는 칭찬의 정도를 의미하는 수치가 있는데, 이 수치를 부하들도 똑같이 칭찬 받는다. 
 * 3. 직속 상사와 직속 부하 관계에 대해 주어지고, 칭찬에 대한 정보가 주어질때, 각자 얼마의 칭찬을 받았는지 출력
 * 
 * 입력
 * 1. 회사의 직원 수 N, 최초의 칭찬의 횟수 M, 각 직원들은 1부터 N까지 번호가 매겨져 있다. 십만 이하
 * 2. N명의 직속 상사의 번호, 직속 상사의 번호는 본인보다 작으며 최종적으로 1번은 사장
 * 3. M줄에는 직속상사로부터 칭찬을 받은 직원번호 i, 칭찬의 수치 W 천 이하
 *  사장은 칭찬을 받지 않는다. 
 *  
 * 출력
 * 1번부터 N번의 직원까지 칭찬을 받은 정도 출력
 * 
 * 풀이
 * 1. int N, M, int[] node 입력, int[] answer 생성
 * 2. int[][] arr 입력 -> arr[입력 1] += 입력2
 * 3. for i 가 1무터 N + 1까지 answer[i] = answer[node[i]] 
 */
public class Main {
	
	static int N, M;
	static int[] node, answer, arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		node = new int[N + 1];
		for(int i = 1; i < N + 1; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}
		arr = new int[N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			arr[n1] += n2;
		}
		
		answer = new int[N + 1];
		for(int i = 2; i < N + 1; i++) {
			answer[i] = arr[i] + answer[node[i]];
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N + 1; i++) sb.append(answer[i] + " ");
	    System.out.print(sb);
    }

}