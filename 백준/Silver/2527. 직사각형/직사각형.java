/*
 * 1. 첫번째 직사각형 입력 받기
 * 2. 두번째 직사각형 입력 받기
 * 3. 각 좌표의 대소 비교를 통해 얼마나 겹치는지 판단
 * 	3.1 첫번째 사각형의 y좌표 사이에 2번째 사각형의 y좌표 값이 들어오는지 판단(일치하는지는 별개로 판단)
 * 	3.2 첫번째 사각형의 x좌표 사이에 2번째 사각형의 x좌표 값이 들어오는지 판단(일치하는지 별개로 판단)
 * 4.안쪽 + 안쪽 => a
 * 	 안쪽 + 일치 => b
 * 	 일치 + 일치 => c
 * 	 안겹침 => d
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i =0 ;i<4;i++) {
			//사각형 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int fistX1 = Integer.parseInt(st.nextToken());
			int fistY1 = Integer.parseInt(st.nextToken());
			int fistX2 = Integer.parseInt(st.nextToken());
			int fistY2 = Integer.parseInt(st.nextToken());
			int secondX1 = Integer.parseInt(st.nextToken());
			int secondY1 = Integer.parseInt(st.nextToken());
			int secondX2 = Integer.parseInt(st.nextToken());
			int secondY2 = Integer.parseInt(st.nextToken());
			//겹치는지, 일치하는지 판단하는 변수
			boolean inX =false;
			boolean sameX = false;
			boolean inY = false;
			boolean sameY = false;
			if((fistX1 <= secondX1 && secondX1<fistX2) || (fistX1 >= secondX1 && secondX2>fistX1)) {
				inX =true;
			}else if(fistX1 == secondX2 || fistX2 == secondX1) {
				sameX=true;
			}
			if((fistY1 <= secondY1 && secondY1<fistY2) || (fistY1 >= secondY1 && secondY2>fistY1)) {
				inY =true;
			}else if(fistY1 == secondY2 || fistY2 == secondY1) {
				sameY=true;
			}
			if(inY && inX) {
				System.out.println("a");
			}else if((sameX && inY) || (sameY && inX) ) {
				System.out.println("b");
			}else if(sameX && sameY) {
				System.out.println("c");
			}else {
				System.out.println("d");
			}
		}
			
			
	}
}