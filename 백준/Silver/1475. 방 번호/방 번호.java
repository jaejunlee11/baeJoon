/*
 * 1. 숫자 입력 받기
 * 2. 각 숫자가 나온 횟수를 담는 배열 생성
 * 2. 숫자 배열을 탐색(각 숫자의 갯수 증가)
 * 3. 6,9를 제외한 값들의 최대값 계산
 * 4. 6,9의 합의 절반값과 최대값을 비교
 * 5. 더 큰 값을 출력
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nums = br.readLine();
		String[] arrs = nums.split("");
		int[] numsCount = new int[10];
		for(String e: arrs) {
			numsCount[Integer.parseInt(e)]++;
		}
		int maxCount = 0;
		int semiCount =0;
		for(int i =0;i<10;i++) {
			if(i==6 || i==9) {
				semiCount += numsCount[i];
			}
			else if(maxCount < numsCount[i]) {
				maxCount = numsCount[i];
				}
		}
		semiCount = semiCount/2 + semiCount%2;
		if(semiCount>maxCount) maxCount = semiCount;
		System.out.println(maxCount);
	}
}