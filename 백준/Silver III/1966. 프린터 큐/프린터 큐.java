/*
 * 문제
 * 1. 테케가 주어짐
 * 2. 총 문서 갯수와 궁금한 번호 입력
 * 3. 난이도가 들어있는 문서 입력
 * 4. 궁금한 문서가 몇번째로 출력되는지 구하기
 * 
 * 풀이
 * 1. 테케 입력
 * 2. 문서 갯수 N, 원하는 문서 번호 M 출력
 * 3. int[] 배열을 담는 큐 만들기, 중요도 문서가 몇 개있는지 배열 만들기 important[10]
 * 4. 원하는 문서 번호는 [중요도,1], 나머지는 [중요도,0]을 입력 -> 중요도 문서 수도 추가
 * 5. 가장 높은 난이도 문서가 남아있으면 해당 문서 부터 빼내기 -> 빼내면서 count
 * 6. 원하는 문서가 빠져나가면 종료 후 cunt 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] importants = new int[10];
			Deque<int[]> que = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			int maxImportant =0;
			for(int i = 0;i<N;i++) {
				int important = Integer.parseInt(st.nextToken());
				maxImportant = Math.max(maxImportant, important);
				importants[important]++;
				if(i==M) {
					que.add(new int[] {important,1});
				}else {
					que.add(new int[] {important,0});
				}
			}
			int count = 0;
			while(true) {
				int[] temp = que.poll();
				if(temp[0]==maxImportant) {
					if(temp[1]==1) {
						count++;
						break;
					}
					importants[maxImportant]--;
					count++;
					if(importants[maxImportant]==0) {
						for(int i = maxImportant-1;i>0;i--) {
							if(importants[i]>0) {
								maxImportant=i;
								break;
							}
						}
					}
				}
				else {
					que.add(temp);
				}
			}
			System.out.println(count);
		}
	}
}