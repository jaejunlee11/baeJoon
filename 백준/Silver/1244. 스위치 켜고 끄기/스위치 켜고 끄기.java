/*
 * 1. 스위치 갯수 입력 받기
 * 2. 스위치 상태 입력 받기
 * 3. 사람 입력 받기
 * 4. 성별 및 번호 입력 받기(남1, 여2)
 *     4.1. 남자는 배수 번호 바꾸기
 *     4.2. 여자의 경우 양옆이 일치하는지 확인
 *         4.3. 일치하는 경우 그 다음도 일치하는지 확인
 *         4.4. 일치하지 않는 경우 해당 범위 숫자 바꾸기
 * 5. 스위치 출력
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] switchArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++) {
        	if(Integer.parseInt(st.nextToken())==0) {
        		switchArr[i] = -1;
        	}else {
        		switchArr[i]=1;
        	}
        }
        int peopleNum = Integer.parseInt(br.readLine());
        for(int i = 0;i<peopleNum;i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st1.nextToken());
            int num = Integer.parseInt(st1.nextToken());
            if(s==1) {
            	int temp = num;
            	while(temp<=N) {
            		switchArr[temp-1]*=-1;
            		temp+=num;
            	}
            }else {
            	int temp = 1;
            	switchArr[num-1]*=-1;
            	while(num-1-temp>=0 && num-1+temp<N && switchArr[num-1-temp] == switchArr[num-1+temp]) {
            		switchArr[num-1-temp]*=-1;
            		switchArr[num-1+temp]*=-1;
            		temp++;
            	}
            }
        }
        for(int i = 0;i<N;i++) {
        		if(switchArr[i] == -1) {
            		System.out.print(0+" ");
            	}else {
            		System.out.print(1+ " ");
            	}
        		if(i%20==19) {
        			System.out.println();
        		}
        }
    }
}