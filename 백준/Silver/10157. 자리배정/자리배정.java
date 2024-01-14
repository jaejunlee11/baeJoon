/*
 * 1. 판 크기 입력 받기
 * 2. 대기 번호 받기(판 크기 보다 큰 경우 0출력후 종료)
 * 3. 대기번호만큼 for문을 돌리기
 * 	3.1. y값을 (y길이 -1)증가
 * 	3.2. x값을 (x길이 -1)증가
 * 	3.3. y값을 (y길이-1)감소
 * 	3.4. x값을 (x길이 -2)감소
 * 	3.5. y길이 x길이 2씩 감소 후 반복
 * 4. x,y값 출력
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//가로
		int C = Integer.parseInt(st.nextToken());
		//세로
		int R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		if(R*C<N) {
			System.out.println("0");
		}else {
			int count = 0;
			int dir = 0;
			int x = 1;
			int y = 0;
			while(true) {
				if(dir==0) {
					count+=(R);
					if(count>=N) {
						y += (R - (count -N));
						break;
					}else {
						y+= (R);
						dir ++;
					}
				}else if(dir ==1) {
					count+=(C-1);
					if(count>=N) {
						x += (C-1 - (count -N));
						break;
					}else {
						x+= (C-1);
						dir++;
					}
				}else if(dir ==2) {
					count+=(R-1);
					if(count>=N) {
						y -= (R-1 - (count -N));
						break;
					}else {
						y-= (R-1);
						dir++;
					}
				}else if(dir ==3) {
					count+=(C-2);
					if(count>=N) {
						x -= (C-2 - (count -N));
						break;
					}else {
						x-= (C-2);
						dir=0;
						C-=2;
						R-=2;
					}
				}
			}
			System.out.println(x+" "+y);
		}
	}

}