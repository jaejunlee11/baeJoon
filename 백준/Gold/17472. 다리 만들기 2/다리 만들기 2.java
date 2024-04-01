/*
 * 문제
 * 1. 판이 존재
 * 2. 판 위에 섬이 존재
 * 3. 섬들을 이어주는 다리를 생성
 * 4. 섬을 전부 연결하는 다리를 만들 때 다리의 최소값 구하기
 * 
 * 풀이
 * 1. N,M입력
 * 2. arr[N][M]생성
 * 3. arr채우기
 * 4. visited배열 생성
 * 5. arr을 탐색, count=1로 시작
 * 	5.1. 1만나면 visited처리하면서 bfs돌기 => count로 채우기
 * 	5.2. count++
 * 6. arr을 탐색 + 간선 그래프 graph priority que 생성
 * 	6.1. 숫자를 만나는 경우 => a 저장
 * 	6.2. 사방 탐색
 * 		6.2.1. 해당 방향으로 계속 이동while문 => move=0으로 시작
 * 			6.2.1.0. nr = r + (move+1) * dir[] => 경계체크 
 * 			6.2.1.1. 숫자를 만나는 경우(move가 1 이하인 경우 pass) =>  que.add({a,만난값,move})
 * 			6.2.1.2. move++
 * 7. line = count-2 //이어야하는 갯수 + init()
 * 8. while(line>0)
 * 	8.1. int[] tmep = que.poll
 * 	8.2. !union(temp[0],temp[1]) continue
 * 	8.3. answer+=line
 * 	8.4. line--
 * 9.answer 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[] parents;
	static boolean[][] visited;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		visited=new boolean[N][M];
		count=1;
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		for(int i = 0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(visited[i][j])continue;
				if(arr[i][j]==1) {
					visited[i][j] = true;
					Deque<int[]> que = new ArrayDeque<>();
					que.add(new int[] {i,j});
					arr[i][j] = count;
					while(!que.isEmpty()) {
						int[] loc = que.poll();
						for(int k = 0;k<4;k++) {
							int nr = loc[0] + dir[k][0];
							int nc = loc[1] + dir[k][1];
							if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
							if(visited[nr][nc]) continue;
							if(arr[nr][nc]!=1) continue;
							visited[nr][nc]= true;
							que.add(new int[] {nr,nc});
							arr[nr][nc] = count;
						}
					}
					count++;
				}
			}
		}
//		for(int i = 0;i<N;i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		PriorityQueue<int[]> que = new PriorityQueue<>((o1,o2)->{
			return o1[2]-o2[2];
		}); 
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(arr[i][j]!=0) {
					int a = arr[i][j];
					for(int k = 0;k<4;k++) {
						int move = 0;
						while(true) {
							int nr = i + (move+1) * dir[k][0];
							int nc = j + (move+1) * dir[k][1];
							if(nr<0 || nc<0 || nr>=N || nc>=M) break;
							if(arr[nr][nc]!=0) {
								if(a==arr[nr][nc] || move<=1) break;
								que.add(new int[] {a,arr[nr][nc],move});
								break;
							}
							move++;
						}
					}
				}
			}
		}
		int line = count-2;
		int answer = 0;
		init();
		while(line>0) {
			if(que.isEmpty()) {
				System.out.println("-1");
				return;
			}
			int temp[] = que.poll();
			if(union(temp[0],temp[1])) {
				answer += temp[2];
				line--;
			}
		}
		System.out.println(answer);
	}
	private static void init() {
		parents = new int[count];
		for(int i = 1;i<count;i++) {
			parents[i]=i;
		}
	}
	
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parents[rootA] = rootB;
		return true;
	}
}