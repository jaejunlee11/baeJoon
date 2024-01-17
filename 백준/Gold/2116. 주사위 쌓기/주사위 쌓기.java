/*
 * 1. 주사위 입력 받기
 * 2. 첫번째 주사위의 6면 돌아가면서 선택
 * 3. 첫번째 주사위의 반대편을 다음 주사위의 윗면으로 설정 -> 이때 나머지면 중 가장 큰값 선택
 * 4. 마지막 주사위까지 반복
 * 5. 6면을 탐색하며 최대값 찾기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int maxDepth;
	static int bigNum(int a, int b) {
		if(a<=5 && b<=5) {
			return 6;
		}else if((a==6 && b<=4) || (a<=4 && b==6)) {
			return 5;
		}
		return 4;
	}
	//그냥 배열을 사용하면 더 단순
	static int nextBottomNum(int a,int[] dice) {
		if(a==0) {
			return dice[5];
		}else if(a==1) {
			return dice[3];
		}else if(a==2) {
			return dice [4];
		}else if(a==3) {
			return dice[1];
		}else if(a==4) {
			return dice[2];
		}else {
			return dice[0];
		}
	}
	static int diceSum(int top,int[][] dices,int tempCount,int depth) {
		if(depth==maxDepth) {
			return tempCount;
		}
		int topNum =0;
		for(int i = 0; i< 6;i++) {
			if(dices[depth][i]==top) {
				topNum = i;
				break;
				}
		}
		int nextBottom =0 ;
			if(topNum==0) {
				nextBottom = nextBottomNum(0,dices[depth]);
				tempCount += bigNum(nextBottom,dices[depth][0]);
			}else if(topNum==1) {
				nextBottom = nextBottomNum(1,dices[depth]);
				tempCount += bigNum(nextBottom,dices[depth][1]);
			}else if(topNum==2) {
				nextBottom = nextBottomNum(2,dices[depth]);
				tempCount += bigNum(nextBottom,dices[depth][2]);
			}else if(topNum==3) {
				nextBottom = nextBottomNum(3,dices[depth]);
				tempCount += bigNum(nextBottom,dices[depth][3]);
			}else if(topNum==4) {
				nextBottom = nextBottomNum(4,dices[depth]);
				tempCount += bigNum(nextBottom,dices[depth][4]);
			}else if(topNum==5) {
				nextBottom = nextBottomNum(5,dices[depth]);
				tempCount += bigNum(nextBottom,dices[depth][5]);
			}
			return diceSum(nextBottom,dices,tempCount,++depth);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dices = new int[N][6];
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int maxCount = 0;
		maxDepth = N;
		for(int i = 1;i<7;i++) {
			int tempCount = diceSum(i,dices,0,0);
			if(maxCount<tempCount) maxCount = tempCount;
		}
		System.out.println(maxCount);
	}
}