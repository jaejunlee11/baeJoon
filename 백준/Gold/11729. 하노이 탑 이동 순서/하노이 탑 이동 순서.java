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
 * 1. 숫자 구하는건 숫자만 계산 => 2^n -1
 * 
 * 재귀함수
 * 1. bfs(탑 갯수) = (탑 갯수 -1) +1 + (탑 갯수-1)
 */
import java.util.*;
import java.io.*;

public class Main {

	public static void bfsprint(int myPoint, int targetPoint, int count,BufferedWriter bw) throws Exception{
		if(count == 1) {
			bw.write(myPoint + " " + targetPoint+"\n");
			return;
		}
		int target = 6- myPoint - targetPoint;
		bfsprint(myPoint,target,--count,bw);
//		bw.write(myPoint + " " + targetPoint+"\n");
		bfsprint(myPoint,targetPoint,1,bw);
		bfsprint(target,targetPoint,count,bw);
	}
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	bw.write((int)Math.pow(2, N)-1+"\n");
    	bfsprint(1,3,N,bw);
    	bw.flush();
	}
}