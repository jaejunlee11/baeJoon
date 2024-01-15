/*
 * 1. 숫자 입력 받기
 * 2. 숫자의 1/2이상의 숫자를 for문으로 돌면서 2번째 숫자들 중 가장 많은 숫자가 나오는 값 확인하기?
 *  2.1. 숫자가 0 미만의 값이 나올 때까지 돌리기
 * 3. 숫자가 1,2,3인 경우 따로 하드 코딩 해주기
 * 4. 최대 숫자와 배열 출력하기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxCount = 0;
		int[] arr = new int[32];
		for(int i = 0;i<N;i++) {
			int[] tempArr = new int[32];
			tempArr[0] = N;
			int tempNum = i+1;
			int tempCount = 1;
			while(tempNum>=0) {
				tempArr[tempCount] = tempNum;
				tempNum = tempArr[tempCount-1]-tempNum;
				tempCount++;
			}
			if(tempCount>maxCount) {
				maxCount = tempCount;
				arr = tempArr.clone();
			}
		}
		System.out.println(maxCount);
		for(int i = 0 ; i <maxCount;i++) {
			System.out.print(arr[i]+ " ");
		}
	}
}