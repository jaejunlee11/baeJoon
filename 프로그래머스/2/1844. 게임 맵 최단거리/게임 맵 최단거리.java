import java.util.*;
class Solution {
	int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	int finished = 0;
	int N;
	int M;
	Queue<int[]> que = new ArrayDeque<int[]>(); 
	boolean[][] visited;
    public int solution(int[][] maps) {
    	N = maps.length;
    	M = maps[0].length;
    	visited = new boolean[N][M];
    	visited[0][0] = true;
    	que.offer(new int[] {0,0,1});
    	int answer =0;
    	while(!que.isEmpty()) {
    		int[] point = que.poll();
    		int r = point[0];
    		int c = point[1];
    		answer = point[2];
    		if(r==N-1 && c== M-1) {	
    			return answer;
    		}
    		for(int i=0;i<4;i++) {
    			int nr = r + dir[i][0];
    			int nc = c + dir[i][1];
    			if(nr<0 || nc<0 || nr>=N || nc>=M || maps[nr][nc] == 0 || visited[nr][nc] == true) continue;
    			visited[nr][nc] = true;
    			que.add(new int[] {nr,nc,answer+1});
    		}
    	}
        return -1;
    }
}