import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int T;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int air1 = -1;
        int air2 = -1;
        map= new int[R][C];
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==-1) {
                    air2=i;
                }
            }
        }
        air1 = air2-1;
        for(int t = 0;t<T;t++) {
            int[][] copyMap = new int[R][C];
            for(int i = 0;i<R;i++) {
                for(int j = 0;j<C;j++) {
                    if(map[i][j]!=0) {
                        int count = 0;
                        for(int k = 0;k<4;k++) {
                            int nr = i + dir[k][0];
                            int nc = j + dir[k][1];
                            if(nr<0 || nc <0 || nr>=R || nc>=C) continue;
                            if(map[nr][nc]==-1) continue;
                            copyMap[nr][nc] += map[i][j]/5;
                            count++;
                        }
                        copyMap[i][j] += map[i][j]-(map[i][j]/5)*count;
                    }
                }
            }
//            for(int i = 0;i<R;i++) {
//            	for(int j = 0;j<C;j++) {
////            		if(map[i][j]!=0 && map[i][j]!=-1) {
////            			answer+=map[i][j];
////            		}
//            		System.out.print(copyMap[i][j]+" ");
//            	}
//            	System.out.println();
//            }
//            System.out.println();
            
            for(int i = air1-1;i>=1;i--) {
                copyMap[i][0] = copyMap[i-1][0];
            }
            for(int j = 0;j<C-1;j++) {
                copyMap[0][j] = copyMap[0][j+1];
            }
            for(int i = 0;i< air1;i++) {
                copyMap[i][C-1] = copyMap[i+1][C-1];
            }
            for(int j = C-1;j>=2;j--) {
                copyMap[air1][j] = copyMap[air1][j-1];
            }
            copyMap[air1][1] = 0;
            
            for(int i = air2+1;i<R-1;i++) {
                copyMap[i][0] = copyMap[i+1][0];
            }
            for(int j = 0;j<C-1;j++) {
                copyMap[R-1][j] = copyMap[R-1][j+1];
            }
            for(int i = R-1;i>air2;i--) {
                copyMap[i][C-1] = copyMap[i-1][C-1];
            }
            for(int j = C-1;j>=2;j--) {
                copyMap[air2][j] = copyMap[air2][j-1];
            }
            copyMap[air2][1] = 0;
            for(int i = 0;i<R;i++) {
            	for(int j = 0;j<C;j++) {
            		map[i][j] = copyMap[i][j];
            	}
            }
        }
        int answer = 0;
        for(int i = 0;i<R;i++) {
        	for(int j = 0;j<C;j++) {
        		if(map[i][j]!=0 && map[i][j]!=-1) {
        			answer+=map[i][j];
        		}
//        		System.out.print(map[i][j]+" ");
        	}
//        	System.out.println();
        }
        System.out.println(answer);
    }
}