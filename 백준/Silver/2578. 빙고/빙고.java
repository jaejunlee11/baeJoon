import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*1. 빙고판 입력 받기 -> 배열의 인덱스를 숫자 -> 저장되는 값을 위치
  2. 25개 숫자 입력 받기 -> 받는 숫자의 인덱스를 활용하여 위치 파악
  3. 받아온 숫자로 배열 돌기
   3-1. 빙고 보드 배열 따로 만들기 -> 위치 숫자값을 활용하여 하나씩 채우기
   3-2. 일치하는 숫자에 맞게 빙고 보드 배열 채우기
   3-3. 빙고 확인 로직을 계속해서 돌리며 3개가 생기면 종료
  4. 종료된 횟수 출력
 */
public class Main {
	public static boolean checkBingo(int[][] bingo) {
		int bingoNum = 0;
		for(int i = 0; i<5;i++) {
			int rawSum = 0;
			int lineSum = 0;
			for(int j = 0; j< 5; j++) {
				rawSum += bingo[i][j];
				lineSum += bingo[j][i];
			}
			if(rawSum == 5) {
				bingoNum++;
			}
			if(lineSum == 5) {
				bingoNum++;
			}
		}
		int sideSum1 = 0;
		int sideSum2 = 0;
		for(int i = 0; i<5;i++) {
			sideSum1+= bingo[i][i];
			sideSum2+=bingo[4-i][i];
		}
		if(sideSum1 == 5) {
			bingoNum++;
		}
		if(sideSum2 == 5) {
			bingoNum++;
		}
		
		if(bingoNum >=3) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] bingoBoard = new int[26];
		for(int i = 0; i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j< 5; j++) {
				bingoBoard[Integer.parseInt(st.nextToken())] = i*5+j;
			}
		}
		int[] bingoNums = new int[25];
		for(int i = 0; i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j< 5; j++) {
				bingoNums[i*5+j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] bingo = new int[5][5];
		for(int i = 0 ; i < 25; i++) {
			int bingoPosition = bingoBoard[bingoNums[i]];
			int bingoY = bingoPosition%5;
			int bingoX = bingoPosition/5;
			bingo[bingoX][bingoY] = 1;
			if(checkBingo(bingo) == true) {
				System.out.println(i+1);
				break;
			}
		}
	}

}