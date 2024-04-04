/*
 * 문제
 * 1. 100칸짜리 판이 존재
 * 2. 1*1,...5*5색종이가 5개씩 존재
 * 3. 최소한의 색종이로 붙이기
 * 
 * 아이디어
 * 1. map을 탐색하며 1을 만나는 경우 해당 후보들을 붙이면서 진행 => 5^25
 * 2. 색종이가 떨어진 경우 돌아가서 다른 색종이를 붙임
 * 3. 모든 탐색을 마치고 돌아와서 최소값 출력
 * 4. 도중에 이미 최소값 보다 많이 사용한 경우 백트래킹
 * 
 * 풀이
 * 1. arr[10][10]생성
 * 2. arr채우기, answer = Max, paper ={0,5,5,5,5,5}
 * 3. dfs돌기 => answer 갱신
 * 
 * dfs(index,map,paper[])
 * 0. r = index/10, c=index%10 => index = 100일때 (25-paper값의 합)으로 answer갱신
 * 1. map[r,c]가 0인 경우 => dfs(index+1,map[],paper[])
 * 2. map[r,c]가 1인 경우
 * 	2.1. for 5~1까지 돌기
 * 		2.1.0. mapcopy[복사], papercopy[복사]
 * 		2.1.1. paper[i]==0이면 continue
 * 		2.1.2. for(r~r+i)
 * 			2.1.2.1. for(c~c+i) => 1이면 mapcopy = 0, 0이 있으면 continue;
 * 		2.1.3. papercopy[i]--;
 * 		2.1.4. dfs(index+i,copymap,copypaper)
 */
//	메모리 298520	시간 916
import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int answer;
    static int[] paper= {0,5,5,5,5,5};;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[10][10];
        for(int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;
        dfs(0);
        if(answer == Integer.MAX_VALUE) {
        	System.out.println(-1);
        	return;
        }
        System.out.println(answer);
    }
    
    private static void dfs(int index) {
    	if(index==100) {
    		int temp = 0;
    		for(int i = 1;i<=5;i++) {
    			temp += paper[i];
    		}
    		answer = Math.min(answer, 25-temp);
    		return;
    	}
    	int r = index/10;
    	int c = index%10;
    	if(map[r][c]==0) dfs(index+1);
    	if(map[r][c]==1) {
    		A : for(int k = 5;k>=1;k--) {
    			if(paper[k]==0) continue A;
    			for(int i = r;i<r+k;i++) {
    				for(int j = c;j<c+k;j++) {
    					if(i>=10 || j>=10) continue A;
    					if(map[i][j]==0) continue A; 
    				}
    			}
    			for(int i = r;i<r+k;i++) {
    				for(int j = c;j<c+k;j++) {
    					map[i][j]=0;
    				}
    			}
    			paper[k]--;
    			dfs(index+1);
    			paper[k]++;
    			for(int i = r;i<r+k;i++) {
    				for(int j = c;j<c+k;j++) {
    					map[i][j]=1;
    				}
    			}
    		}
    	}
    }

}