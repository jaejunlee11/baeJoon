import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, max;
    static boolean[] visit;
    static int[] picked;
    static int[][] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visit = new boolean[9];
        picked = new int[9];
        scores = new int[N][9];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        picked[3];
        perm(0);
        System.out.println(max);

    }
    static void perm(int idx) {
        if(idx ==9) {
            int score = getPoint();
            if(score>max) {
                max = score;
            }
            return;
        }

        for(int i=1; i<9; i++) {
            if (visit[i]) continue;
            if(idx==3) idx++;
            picked[idx] = i;
            visit[i] =true;
            perm(idx+1);
            visit[i] = false;
        }
    }
    static int  getPoint() {
		//		System.out.println(Arrays.toString(picked));
		int point = 0;
		int nowP = 0;//현재 순번
		A : for(int i = 0;i<N;i++) {
			int nowO = 0;//out카운트
			int[] runnerArr = {0,0,0};//현재 주자들
			//타격
			while(true) {
				int result = scores[i][picked[nowP]];
				switch(result){
				case 0 :
				{
					nowO++;
					nowP++;
					if(nowP==9) nowP=0;
					if(nowO==3) continue A;
					break;
				}
				case 1 :
				{
					if(runnerArr[2]==1) {
						point++;
					}
					runnerArr[2] = runnerArr[1];
					runnerArr[1] = runnerArr[0];
					runnerArr[0] = 1;
					nowP++;
					if(nowP==9) nowP=0;
					break;
				}
				case 2 :
				{
					for(int j = 1;j<3;j++) {
						if(runnerArr[j]==1) {
							point++;
						}
					}
					runnerArr[2] = runnerArr[0];
					runnerArr[1] = 1;
					runnerArr[0] = 0;
					nowP++;
					if(nowP==9) nowP=0;
					break;
				}
				case 3 :
				{
					for(int j = 0;j<3;j++) {
						if(runnerArr[j]==1) {
							point++;
						}
					}
					runnerArr[2] = 1;
					runnerArr[1] = 0;
					runnerArr[0] = 0;
					nowP++;
					if(nowP==9) nowP=0;
					break;
				}
				case 4 :
				{
					for(int j = 0;j<3;j++) {
						if(runnerArr[j]==1) {
							point++;
						}
					}
					point++;
					runnerArr[2] = 0;
					runnerArr[1] = 0;
					runnerArr[0] = 0;
					nowP++;
					if(nowP==9) nowP=0;
					break;
				}
				}	
			}

		}
		return point;
	}
//    static int calScore() {
//        //ining
//        int score=0, i=0;
//        for(int g=0; g<N; g++) {
//
//            boolean[] field=new boolean[4];
//            int out=0;
//            while(out<3) {
//                int hitter =picked[i];
//                int hit =scores[g][hitter];
//
//                if(hit==0) {
//                    out++;
//                }
//                else if (hit==4) {
//                    for(int k=1; k<=3; k++) {
//                        if(field[k]) {
//                            field[k]=false;
//                            score++;
//                        }
//                    }
//                    score++;
//
//                }
//                else {
//                    boolean[] on = new boolean[4];
//                    for(int k=1; k<=3; k++) {
//                        if(field[k]) {
//                            field[k] = false;
//                            if(k+hit >3) {
//                                score++;
//                            }
//                            else {
//                                on[k+hit] =true;
//                            }
//                        }
//                    }
//                    for(int k=1; k<=3; k++){
//                        if(on[k]) field[k]=true;
//                    }
//                    field[hit] = true;
//
//                }
//
//                i=(i+1)%9;
//            }
//        }
//        return score;
//    }
}