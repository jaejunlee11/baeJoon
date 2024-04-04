/*
 * 문제
 * 1. 승무패 정보가 들어올때 해당 승부가 가능한지 구하기
 * 
 * 풀이
 * 1. arr[15]생성, score[6][3], HashSet생성
 * 2. 중복 순열 돌리기
 * 
 * 중복 순열
 * 1. depth==15
 * 	1.1. score채우기
 * 	1.2. for문을 돌려서 score를 sb를 통해서 String으로 만든 이후 HashSet에 넣기
 * 	1.3. return
 * 2. for문 돌리기
 * 	2.1. arr[depth]=i;
 * 	2.2. recur(depth+1);
 */
import java.util.*;
import java.io.*;

public class Main {
	static int[] arr = new int[15];
	static int[][] score = new int[6][3];
	 static int[][][] play;
	 static int[] answer = {0,0,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        play = new int[4][6][3];
        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++) {
                for(int k=0; k<3; k++) {
                    play[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
//		long time = System.currentTimeMillis();
		recur(0);
		for(int k = 0;k<4;k++) {
			System.out.print(answer[k]+" ");
		}
//		System.out.println(System.currentTimeMillis()-time);
		
	}
	private static void recur(int depth) {
		if(depth==15) {
			for(int i =0;i<6;i++) {
				for(int j = 0;j<3;j++) {
					score[i][j]=0;
				}
			}
			int count = 0;
			for(int j = 0;j<6;j++) {
				for(int i = j+1;i<6;i++) {
					if(arr[count]==0) {
						score[j][0]+=1;
						score[i][2]+=1;
					}else if(arr[count]==1) {
						score[j][1]+=1;
						score[i][1]+=1;
					}else if(arr[count]==2) {
						score[j][2]+=1;
						score[i][0]+=1;
					}
					count++;
				}
			}
//			for(int i =0;i<6;i++) {
//				for(int j = 0;j<3;j++) {
//					System.out.print(score[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
			A : for(int k=0; k<4; k++) {
				if(answer[k]==1) continue A;
	            for(int r=0; r<6; r++) {
	                for(int c=0; c<3; c++) {
	                    if(!(play[k][r][c]==score[r][c])) continue A;
	                }
	            }
	            answer[k]=1;
	        }

			return;
		}
		for(int i = 0;i<3;i++) {
			arr[depth]=i;
			recur(depth+1);
		}
	}
}