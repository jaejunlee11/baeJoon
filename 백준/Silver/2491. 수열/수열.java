import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*
 * 1. 수열 갯수 받기
 * 2. 수열 갯수 만큼 배열 생성 및 입력 받기
 * 3. 배열 돌리기
 * 	3.1 임시의 연속되는 횟수 카운트(작아지는 것, 커지는 것 동시 확인)
 * 	3.2 임시 값이 더 크면 최대 값 업데이트
 */

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//수열 갯수
		int N = Integer.parseInt(br.readLine());
		//수열 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ;i < N; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//최종 연속 최대값
		int maxnum = 0;
		//커지는 방향 연속값
		int tempBigNum = 0;
		//작아지는 방향 연속값
		int tempSmallNum = 0;
		for(int i = 0; i<N-1;i++) {
			if(arr[i]<arr[i+1]) {
				tempBigNum++;
				if(maxnum<tempSmallNum) {
					maxnum = tempSmallNum;
				}
				tempSmallNum =0 ;
			}else if(arr[i]>arr[i+1]) {
				tempSmallNum++;
				if(maxnum<tempBigNum) {
					maxnum = tempBigNum;
				}
				tempBigNum = 0;
			}else if(arr[i]==arr[i+1]) {
				tempSmallNum++;
				tempBigNum++;
			}
		}
		if(maxnum<tempBigNum) {
			maxnum = tempBigNum;
		}
		if(maxnum<tempSmallNum) {
			maxnum = tempSmallNum;
		}
		System.out.println(maxnum+1);
	}

}