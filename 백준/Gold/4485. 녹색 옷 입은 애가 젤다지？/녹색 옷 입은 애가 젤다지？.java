/*
 * 문제
 * 1. 판이 존재
 * 2. 루피가 존재
 * 3. 루피가 최소가 되도록 하기
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N][N]생성
 * 3. List[N*N] 생성
 * 4. for문 돌리기 => N
 * 	4.1.for문 돌리기 =>N
 * 		4.1.0. 4방향 탐색
 * 			4.1.1.1. nr = i+dir[k][0] => 경계체크
 * 			4.1.1.2. arrlist[i*N+j].add(nr*i + nc, arr[nr][nc])
 * 5. dis[N*N]생성 , 최대값은 150000으로 세팅, start = 0
 * 6. while 돌리기
 * 	6.1. for(arrlist[start]) => start visited처리
 * 		6.1.1. end = loc[0] => visited 체크
 * 		6.1.2. dis[end] > dis[start] + loc[1] 이면 dis[end]갱신
 * 	6.2. visited안된 것들 중 최소값 찾기 => start 갱신 => 전부 visited면 종료
 * 7. dis[N*N-1]출력
 */
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        String pre = "Problem ";
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;
        while(true) {
        	count++;
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            int arr[][] = new int[N][N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                     arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            List<int[]> arrlist[] = new ArrayList[N*N];
            for(int i = 0;i<N;i++) {
            	for(int j = 0;j<N;j++) {
            		arrlist[i*N+j] = new ArrayList<>();
            		for(int k = 0;k<4;k++) {
            			int nr = i + dir[k][0];
            			int nc = j + dir[k][1];
            			if(nr<0 || nc < 0 || nr>=N || nc>=N) continue;
            			arrlist[i*N+j].add(new int[] {nr*N+nc,arr[nr][nc]});
            		}
            	}
            }
            int[] dis = new int[N*N];
            boolean[] visited = new boolean[N*N];
            for(int i = 0;i<N*N;i++) {
            	dis[i] = 150000;
            }
            dis[0] = arr[0][0];
            int start = 0;
            
//            for(List<int[]> list : arrlist) {
//            	for(int[] arr1 : list) {
//            		System.out.println(Arrays.toString(arr1));
//            	}
//            	System.out.println();
//            }
//            System.out.println();
//            System.out.println();
            while(true) {
            	visited[start] = true;
            	for(int[] loc : arrlist[start]) {
            		int end = loc[0];
            		if(dis[end]>dis[start] + loc[1]) {
            			dis[end] = dis[start] + loc[1];
            		}
            	}
            	
            	int min = Integer.MAX_VALUE;
            	for(int i = 0;i<N*N-1;i++) {
            		if(visited[i]) continue;
            		if(min>dis[i]) {
            			min = dis[i];
            			start = i;
            		}
            	}
//            	System.out.println(Arrays.toString(dis));
            	if(min==Integer.MAX_VALUE) break;
            }
            
            sb.append("Problem " + count + ": "+ dis[N*N-1]+"\n");
        }
        System.out.println(sb);
    }

}