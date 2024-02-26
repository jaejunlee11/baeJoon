/*
 * 문제
 * 1. 프로젝트가 존재
 * 2. 프로젝트를 맡을 수 있는 수가 한정 -> N개가 있음
 * 3. 3월1일에서 11월30일 사이에는 프로젝트가 쉬는 날이 없이 진행
 * 4. 맡을 수 있는 프로젝트의 최소 개수
 * 5. 3월1일에서 11월 30일 사이에 쉬는 날이 있으면 0출력
 * 
 * 풀이
 * 1. N 입력 받기
 * 2. arr[N][4] 생성 -> 프로젝트 시작일 , 종료 일 
 * 3. arr을  종료일이 늦는 순서로 정렬
 * 4. arr을 앞에서 부터 확인하여 3월 1일 이전의 것을 선택
 * 5. while을 돌며 arr을 앞에서 부터 확인하여 아까 선택한 배열의 날짜 보다 작은 것을 선택(탐색은 선택한 것 까지만)
 * 	5.1. arr에서 선택한 마지막 값이 12월을 넘어가면 종료
 * 6. 만약 아무것도 못고르면 0 출력
 * 
 * 시간 복잡도
 * 1. 100000 부터 1까지의 합 = 5000000000
 * 2. 다만 날짜가 11월 30일 부터 3월 1일까지가 300일 정도이기 때문에 겹쳐진 날짜는 생략되어 아마 충분
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][4];
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,(o1,o2)->{
			if(o1[2]==o2[2]) {
				return o2[3]-o1[3];
			}
			return o2[2]-o1[2];
		});
		int answer = 0;
		int month = 3;
		int day = 1;
		int end = N;
		while(true) {
			boolean flag = true;
			for(int i = 0;i<end;i++) {
				if(arr[i][0]<month) {
					month = arr[i][2];
					day = arr[i][3];
					flag = false;
					end = i;
					break;
				}
				if(arr[i][0]==month) {
					if(arr[i][1]<=day) {
						month = arr[i][2];
						day = arr[i][3];
						flag = false;
						end = i;
						break;
					}
				}
			}
			if(flag) {
				System.out.println(0);
				return;
			}
			answer++;
			if(month>11) {
				System.out.println(answer);
				return;
			}
		}
	}
}