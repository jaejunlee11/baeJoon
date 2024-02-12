/*
 * 문제
 * 1. 이름이 주어짐
 * 2. 해당 이름을 만들기 위해서 이동해야하는 횟수 구하기
 * 
 * 풀이
 * 1. 이름 입력 받기
 * 2. 이름 크기의 배열 만들기
 * 3. charat() - 'A'로 값을 입력 넣기
 * 4. 배열을 전부 순회하면서 A를 만나면
 * 	4.1. 지금까지 온 거리 *2 + 반대로 돈 거리
 * 	4.2. 반대로 온거리 *2 + 지금까지 온 거리
 * 	4.3. 그냥 일자로 가기
 * 5. 가장 작은 값이 좌우 이동
 * 6. 13을 기준으로 작으면 그냥 값, 아니면 26-값 더 해주기
 */
import java.io.*;
import java.util.*;
public class Solution {
	 public static int solution(String name) {
		 int nameL = name.length();
		 int[] arr = new int[nameL];
		 for(int i = 0 ;i<nameL;i++) {
			 arr[i] = name.charAt(i)-'A';
		 }
		 int minValue = nameL-1;
		 for(int i = 1;i<nameL;i++) {
			 if(arr[i]==0) {
				 for(int j  = 0 ;j<nameL-i;j++) {
					 if(arr[i+j]!=0) {
						 int tmep = Math.min((i-1)*2+nameL-i-j,i-1+(nameL-i-j)*2 );
						 minValue = Math.min(minValue, tmep);
						 break;
					 }
                     if(j==nameL-i-1){
						 minValue = Math.min(minValue, i-1 );
						 break;
                     }
				 }
			 }
		 }
		 for(int i = 0;i<nameL;i++) {
			 if(arr[i]>13) {
				 minValue+=(26-arr[i]);
			 }else {
				 minValue += arr[i];
			 }
		 }
		return minValue;
	}
}
