

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 배달
 *
 * 조건
 * 마을 개수(정점) N : 1 ~ 50
 * 도로 정보의 개수(간선) M : 1 ~ 2000
 * 양방향 통행(무향 그래프)
 * 입력 방식 : 정점 a 정점 b 가중치 c
 * c : 1 ~ 10000
 *
 * 문제에서 구하고자 하는 것
 * 음식 주문을 받을 수 있는 마을의 개수 (1번 마을 기준 <- 시작 정점)
 *
 * 문제 해결 프로세스
 * 인접 행렬 생성
 * 1번 탐색으로 시작해 dfs, 가중치가 k를 넘지 않는 경우만
 *
 * 고려한 시간 복잡도
 * 50 * 50 = 2500
 *
 * */

public class Solution {
    static List<int[]>[] adjList;
    static boolean[] isChecked;
    static int count = 1;
    static boolean[] visited;

    public int solution(int N, int[][] road, int K) {
               adjList = new List[N+1];
        for(int i = 1; i < N+1; i++) {
            adjList[i] = new ArrayList<>();
        }
        isChecked = new boolean[N+1];
        visited = new boolean[N+1];
        for(int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            adjList[a].add(new int[]{b, c});
            adjList[b].add(new int[]{a, c});
        }
        int[] dis = new int[N+1];
        isChecked[1] = true;
        visited[1] = true;
        for(int i = 2;i<=N;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        int v = 1;
        for(int i = 0;i<N;i++){
            int min = dis[v];
            for(int[] line : adjList[v]){
                int d = line[0];
                if(visited[d]) continue;
                if(dis[d]>min + line[1]){
                    dis[d] = min + line[1];
                }
            }
            int temp = Integer.MAX_VALUE;
            for(int j = 1;j<=N;j++){
                if(visited[j]) continue;
                if(temp>dis[j]){
                    temp = dis[j];
                    v = j;
                }
            }
            visited[v]=true;
        }
        int answer = 0;
        for(int i = 1;i<=N;i++){
            if(dis[i]<=K) answer++;
        }
        return answer;
    }
}
