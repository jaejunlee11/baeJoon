/*
 * 문제
 * 1. 단어의 갯수 주어짐 -> 최대 10
 * 2. 단어가 나옴 -> 최대 8글자
 * 3. 단어들을 숫자로 치환 => 0~9
 * 4. 합의 최대값 구하기
 * 
 * 풀이
 * 1. 단어 갯수 주어짐 -> N
 * 2. 각 단어의 최대 길이 구하기 -> M => 최대 8
 * 3. 배열 만들기 -> arr[N][M]
 * 4. 단어를 거꾸로 배열에 넣기 -> ex) abc => arr[N][0] -> c, 1 -> b, 2 ->c
 * 5. 단어 갯수 카운팅용 배열 만들기 -> spell[26][2] => 0에는 그냥 숫자 넣어주기
 * 6. 배열을 순회하면서 -> 각 행 *10^n을 더해주기
 * 7. spell 정렬=>0이 아닌 것들로 spellNum배열 만들기 -> spellNum[n] -> 큰 숫자순으로 넣기
 * 8. 각 숫자에 맞게 변환 후 더하기 연산
 * 9. 결과 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		int M = 0;
		for(int i =0 ;i<N;i++) {
			String temp =  br.readLine();
			words[i] = temp;
			M = Math.max(M, temp.length());
		}
		int[][] arr = new int[N][M];
		for(int i =0;i<N;i++) {
			int temp = words[i].length();
			for(int j = 0;j<temp;j++) {
				arr[i][j] = words[i].charAt(temp-j-1)-'A'+1;
			}
		}
		int[][] spell = new int[27][2];
		for(int i = 0;i<27;i++) {
			spell[i][0] = i;
		}
		for(int i =0;i<M;i++) {
			for(int j = 0;j<N;j++) {
//				System.out.println(Arrays.deepToString(spell));
				if(arr[j][i]==0) continue;
				spell[arr[j][i]][1] += (int)Math.pow(10, i);
			}
		}
//		System.out.println(Arrays.deepToString(spell));
		Arrays.sort(spell,(o1,o2)->o2[1]-o1[1]);
		int [] [] spellNum = new int[27][2];
		int count = 9;
		A : for(int i = 0;i<27;i++) {
			for(int j = 0;j<27;j++) {
				if(spell[i][0]==j) {
					if(spell[i][1]==0) break A;
					spellNum[j][0] = j;
					spellNum[j][1] = count--;
			}
			if(count==0) break;
			}
			
		}
		int sum = 0;
		for(int i = 0;i<N;i++) {
			int tmep =words[i].length();
			for(int j = 0;j<tmep;j++) {
				sum+=(int)Math.pow(10, tmep-j-1) * spellNum[words[i].charAt(j)-'A'+1][1];
			}
		}
		System.out.println(sum);
	}
}