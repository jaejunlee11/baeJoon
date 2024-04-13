/*
 * 문제
 * 1. 보석 N개 존재
 * 2. 보석의 무게 M, 가치V존재
 * 3. K개의 가방 존재, 무게 제한 존재
 * 4. 최대 가치 만들기
 * 
 * 풀이
 * 1. N, K입력 => 보석 갯수, 가방 갯수
 * 2. arr1[N][2]생성, arr2[K]생성
 * 3. arr1 채우기
 * 4. arr2 채우기
 * 5. arr1 o1[0]기준으로 정렬
 * 6. arr2 정렬
 * 7. priorityque 생성 o2-o1기준
 * 8. for문 돌리기 K , int inCount = 0;
 * 	8.1. for믄 돌리기 inCount~N
 * 		8.1.1. arr1[j][0]<=arr2[i] => que에 arr1[j][1]에 넣기
 * 		8.1.2. else => incount=j이후 break
 * 	8.2. answer += que.poll()
 * 9.answer 출력
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr1 = new int[N][2];
		int[] arr2 = new int[K];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr1[i][0] = Integer.parseInt(st.nextToken());
			arr1[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1,(o1,o2)->o1[0]-o2[0]);
		Arrays.sort(arr2);
		PriorityQueue<Integer> que = new PriorityQueue(Collections.reverseOrder());
		long answer = 0;
		int inCount = 0;
		for(int i = 0;i<K;i++) {
			for(int j = inCount;j<N;j++) {
				if(arr1[j][0]<=arr2[i]) {
//					System.out.println("넣기" + arr1[j][1]);
					que.add(arr1[j][1]);
					if(j==N-1) inCount = N;
				}else {
					inCount = j;
					break;
				}
			}
			if(!que.isEmpty()) {
				answer+=que.poll();
//				System.out.println(answer);
			}
			
		}
		System.out.println(answer);
	}
}