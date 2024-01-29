/*
 * 0. (자기위치, 타겟 , 갯수)
 * 1. 원판이 1개인 경우 -> (1,3,1)
 * 2. 원판이 2개인 경우 -> 1개를 2번 타겟으로(1,2) -> 1개를 3번 타겟으로(1,3) -> 1개를 3번 타겟으로(2,3)
 * 3. 원판이 3개인 경우 -> 2개를 2번 타겟으로 -> 1개를 3번 타겟으로 -> 2개를 3번 타겟으로
 * 4. 원판이 4개인 경우 -> 3개를 2번 타겟으로 -> 1개를 3번 타겟으로 -> 3개를 3번 타겟으로
 * 재귀함수
 * 1. (자기위치, 타겟 , 갯수) -> (자기위치, (자기,타겟 제외 타겟), 개수 -1) => (자기위치, 타겟,1) => ((자기,타겟 제외 타겟),타겟,개수-1)
 * 
 * 더 빨라야함
 * 1. 숫자 구하는건 숫자만 계산
 * 
 * 재귀함수
 * 1. bfs(탑 갯수) = (탑 갯수 -1) +1 + (탑 갯수-1)
 */
import java.util.*;
import java.math.*;

public class Main {
//	public static long bfs(long count) {
//		if(count == 1) {
//			return 1;
//		}
//		return  (bfs(--count))*2 + 1;
//	}
	public static void bfsprint(int myPoint, int targetPoint, int count) {
		if(count == 1) {
			System.out.println(myPoint + " " + targetPoint);
			return;
		}
		int target = 6- myPoint - targetPoint;
		bfsprint(myPoint,target,--count);
		System.out.println(myPoint + " " + targetPoint);
		bfsprint(target,targetPoint,count);
	}
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	BigInteger N = new BigInteger("2");
    	BigInteger one = new BigInteger("1");
    	System.out.println(N.pow(n).subtract(one));
    	if(n<=20) {
    		bfsprint(1,3,n);
    	}
	}
}