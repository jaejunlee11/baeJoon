
/*
 * 문제
 * 1. 숫자가 주어짐
 * 2. 연속되는 소수의 합으로 숫자 만들 수 있는 경우의 수 구하기
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N+1]생성
 * 3. arr[1]= true
 * 4. for(3~N)
 * 	4.0. arr[i] true면 pass count=2
 * 	4.1. while(i*count<=N)
 * 		4.1.1. arr[i*count] = true
 * 5. for문돌기
 * 	5.1. list에 arr[i]=false인 것 넣기
 * 6. start = 0, end = 0, value = list.get(0)
 * 6.while돌기
 * 	6.0. end == list크기면 종료
 * 	6.1.value<target => end++, value += list.get(end)
 * 	6.2. value>target => start++, value -= list.get(start)
 * 	6.3. value==target => anser++, end++, value -= list.get(end)
 * 7. answer 출력
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		if(N==1) {
			System.out.println(0);
			return;
		}
		boolean[] arr = new boolean[N+1];
		arr[0] = true;
		arr[1] = true;
		for(int i =2;i<=N;i++) {
			if(arr[i]) continue;
			int count = 2;
			while(count*i<=N) {
				arr[i*count] = true;
				count++;
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 0;i<=N;i++) {
			if(!arr[i]) list.add(i);
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(list);
		int start = 0;
		int end = 0;
		int value = list.get(0);
		int size = list.size();
		int asnwer = 0;
		while(true) {
//			System.out.println(value);
			if(value<N) {
				end++;
				if(end==size) break;
				value += list.get(end);
			}else if(value>N) {
				value -= list.get(start);
				start++;
				
			}else {
				asnwer++;
//				System.out.println(start + " " + end);
//				System.out.println(value);
//				for(int j = start ; j<=end;j++) {
//					System.out.println(list.get(j));
//				}
//				System.out.println(value);
				end++;
				if(end==size) break;
				value+=list.get(end);
			}
		}
		System.out.println(asnwer);
	}
}
