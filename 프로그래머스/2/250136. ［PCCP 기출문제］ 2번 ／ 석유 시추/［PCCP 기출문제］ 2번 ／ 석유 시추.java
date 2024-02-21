
/*
 * 문제
 * 1. 세로 가로 n*m인 땅 존재
 * 2. 석유가 덩어리로 존재 -> 1
 * 3. 한 지점에서 쭉 뽑을때 => m개의 선택지
 * 4. 석유를 만나면 전부 뽑음
 * 5. 최대한 많이 뽑을 수 있는 양은?
 * 
 * 풀이
 * 1. 배열을 입력 받음
 * 2. 모든 땅을 순회
 * 	2.1. 석유를 만나면 bfs로 돌기
 * 	2.2. 이때 리스트에 위치 값을 저장
 * 	2.3. 모두 돌고 크기를 계산 후 위치에 값들을 해당 값으로 변경
 * 3. 각 열의 합을 계산하여 최대 값 찾기
 */
import java.util.*;
public class Solution {
	int N;
	int M;
	int[][] arr;
	boolean visited[][];
    public int solution(int[][] land) {
    	N = land.length;
    	M = land[0].length;
    	arr =land;
    	visited = new boolean[N][M];
    	int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    	for(int i = 0;i<N;i++) {
    		for(int j = 0;j<M;j++) {
    			if(visited[i][j]) continue;
    			if(arr[i][j]==1) {
    				Deque<int[]> que = new ArrayDeque<>();
    				Deque<int[]> money = new ArrayDeque<>();
    				que.add(new int[] {i,j});
    				money.add(new int[] {i,j});
    				int count= 1;
    				visited[i][j]=true;
    				while(!que.isEmpty()) {
    					int[] loc = que.poll();
    					for(int k = 0;k<4;k++) {
    						int nr = loc[0]+dir[k][0];
    						int nc = loc[1]+dir[k][1];
    						if(nr<0||nc<0||nr>=N||nc>=M) continue;
    						if(arr[nr][nc]!=1)continue;
    						if(visited[nr][nc]) continue;
    						visited[nr][nc]=true;
    						que.add(new int[] {nr,nc});
    						money.add(new int[] {nr,nc});
    						count++;
    					}
    				}
    				boolean checked[] = new boolean[M];
    				while(!money.isEmpty()) {
    					int[] loc = money.poll();
    					if(checked[loc[1]]) {
    						arr[loc[0]][loc[1]]=0;
                            continue;
    					};
    					checked[loc[1]]=true;
    					arr[loc[0]][loc[1]]=count;
    				}
    			}
    		}
    	}
    	int answer = 0;
    	
    	for(int i = 0;i<M;i++) {
    		int tempSum =0;
    		for(int j = 0 ;j<N;j++) {
    			tempSum+=arr[j][i];
    		}
    		answer = Math.max(answer, tempSum);
    	}
        
        return answer;
    }
}
