/*
 * 문제
 * 1. M*N칸 존재
 * 2. 아기 상어, 물고기 존재
 * 3. 각 물고기들은 크기가 존재 => 아기상어는 처음에 2
 * 4. 아기상어가 자기 보다 큰 물고기는 이동 불가
 * 5. 자기보다 작은 물고기는 먹을 수 있음
 * 6. 먹을 수 있는 가장 가까운 물고기를 먹음(거리가 같으면 가장 위쪽, 왼쪽)
 * 7. 자기 크기만큼 물고기를 먹으면 커짐
 * 8. 더 이상 물고기를 못 먹을 때의 시간
 * 
 * 풀이
 * 1. N입력
 * 2. arr[N]생성
 * 3. arr채우기
 * 4. while 돌리기 size=2, count=0, time=0
 * 	4.1. 아기상어 위치에서 레벨별 bfs 사용 => 상, 좌, 하, 우 순서
 * 	4.2. 먹을 수 있는 물고기를 만나면 
 * 		4.2.1. time에 레벨 (move) 추가
 * 		4.2.2. count++ => 만약 size와 같으면 size++, count=0
 * 	4.3.먹을 수 있는 물고기가 없으면 종료 => time 출력
 * 
 * 
 * bfs
 * 1. 큐생성 + 큐에 아기상어 위치 넣기 
 * 2. while문 돌리기 move = 0
 * 	2.1. que사이즈 체크 + move++
 * 	2.2. 사이즈만큼 반복
 * 		2.2.1. que에서 꺼내기
 * 		2.2.2. 4방 탐색
 * 			2.2.2.1. 경계체크
 * 			2.2.2.2. size 보다 크면 continue
 * 			2.2.2.3. size 보다 작으면 break
 * 			2.2.2.4. 큐에 담기
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int r = 0;
		int c = 0;
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==9) {
					r= i;
					c= j;
					arr[i][j]=0;
				}
			}
		}
		int size = 2;
		int count = 0;
		int time = 0;
		int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}};
		while(true) {
			boolean[][] visited = new boolean[N][N];
			Deque<int[]> que = new ArrayDeque<>();
			List<int[]> list = new ArrayList<>();
			que.add(new int[] {r,c});
			visited[r][c] = true;
			int move = 0;
			boolean flag = false;
			
			A : while(!que.isEmpty()) {
				int queSize= que.size();
				move++;
				while(queSize-->0) {
					int[] tempLoc = que.poll();
					for(int k = 0;k<4;k++) {
						int nr = tempLoc[0] + dir[k][0];
						int nc = tempLoc[1] + dir[k][1];
						if(nr<0||nc<0||nr>=N||nc>=N) continue;
						if(visited[nr][nc]) continue;
						if(arr[nr][nc]>size) continue;
						if(arr[nr][nc]<size && arr[nr][nc]!=0) {
							list.add(new int[] {nr,nc});
							flag= true;
							continue;
						}
						que.add(new int[] {nr,nc});
						visited[nr][nc] = true;
//						System.out.println(time +" " + move);
//						for(int i = 0;i<N;i++) {
//							System.out.println(Arrays.toString(visited[i]));
//						}
					}
				}
				if(flag) break;
			}
			if(flag) {
				Collections.sort(list,(o1,o2)->{
					if(o1[0]==o2[0]) {
						return o1[1]-o2[1];
					}
					return o1[0]-o2[0];
				});
				int nr = list.get(0)[0];
				int nc = list.get(0)[1];
				arr[nr][nc]=0;
				r= nr;
				c = nc;
				time+=move;
				count++;
				if(count==size) {
					count=0;
					size++;
				}
			}else {
				System.out.println(time);
				return;
			}
		}
	}
}