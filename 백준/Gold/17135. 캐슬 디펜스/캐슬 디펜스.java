/*
 * 문제
 * 1. N*M 격자판 존재
 * 2. N+1번행에 성 존재 -> 제일 아래 부분
 * 3. 궁수 3명 배치
 * 4. 궁수는 가장 가까운 적 공격 가장 왼쪽 -> 거리 판단 L1
 * 5. 모든 격자판에서 적 제거시 종료
 * 6. 끝까지 도달한 적은 사라짐
 * 
 * 풀이
 * 1. N M D입력
 * 2. arr[N][M]생성
 * 3. 적 채우기
 * 4. 궁수 위치를 조합으로 뽑기 -> picked[]
 * 5.0. N번 반복
 * 	5.1. 궁수 위치에서 bfs를 통해서 가장 가까운 적 위치 판단 -> 4방 탐색
 * 	5.2. 궁수 셋을 다 돌렸으면 제거 -> 적 갯수 ++
 * 	5.3. 적을 한칸씩 내림
 * 6. 죽인 적 최대값 업데이트
 * 
 * 
 * 조합
 * 1. depth가 3이면 종료
 * 	1.1. 위과정
 * 2. for( index~M)
 * 	2.1.recur(depth+1, i+1)
 * 
 * bfs -> dir{ {0,-1},{-1,0},{0,1}}
 * 1. 큐에 궁수 넣기
 * 2. while()
 * 	2.0. D만큼 반복 했으면 종료
 * 	2.1. 큐 사이즈 체크
 * 	2.2. for(큐사이즈)
 * 		2.2.1. 4방 탐색 -> 적 까지
 * 
 * 455 * 15 * 1000 
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[] picked;
	static int N;
	static int M;
	static int D;
	static int answer = 0;
	static int[][] dir = {{0,-1},{-1,0},{0,1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D =	Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		picked = new int[3];
		for(int i= 0 ;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recur(0,0);
		System.out.println(answer);
	}
	static void recur(int depth,int index) {
		if(depth == 3) {
//			System.out.println("==============================="+Arrays.toString(picked));
			
			int tempAnser = 0;
			int[][] tempArr =new int[N][M];
			for(int i = 0;i<N;i++) {
				tempArr[i] = arr[i].clone();
			}
			for(int game = 0;game<N;game++) {
//				for(int i = 0;i<N;i++) {
//					System.out.println(Arrays.toString(tempArr[i]));
//					
//				}
//				System.out.println();
				int[][] die = {{-1,-1},{-1,-1},{-1,-1}};
				A : for(int i = 0 ;i<3;i++) {
					if(tempArr[N-1][picked[i]]==1) {
						for(int[] loc : die) {
							if(loc[0]==N-1 && loc[1]==picked[i]) {
								die[i][0] = N-1;
								die[i][1] = picked[i];
								continue A;
							}
						}
						die[i][0] = N-1;
						die[i][1] = picked[i];
						tempAnser++;
						continue A;
					}
					boolean[][] checked = new boolean[N][M];
					Deque<int[]> que = new ArrayDeque<>();
					checked[N-1][picked[i]]= true;
					que.add(new int[] {N-1,picked[i]});
					depth = 0;
					B : while(true) {
						depth++;
						if(depth==D) break;
						int Q = que.size();
						if(Q==0) break;
						while(Q-- >0) {
							int[] loc = que.poll();
							for(int k = 0 ;k<3;k++) {
								int nr = loc[0]+dir[k][0];
								int nc = loc[1] + dir[k][1];
								if(nr<0 ||nc<0||nr>=N||nc>=M) continue;
								if(checked[nr][nc]) continue;
								checked[nr][nc] = true;
								if(tempArr[nr][nc]==1) {
									for(int[] loc2 : die) {
										if(loc2[0]==nr && loc2[1]==nc) {
											die[i][0] = nr;
											die[i][1] = nc;
											break B;
										}
									}
									die[i][0] = nr;
									die[i][1] = nc;
									tempAnser++;
									break B;

								}
								que.add(new int[] {nr,nc});
							}

						}
					}
				}
				for(int[] loc2 : die) {
						if(loc2[0]==-1) continue;
						tempArr[loc2[0]][loc2[1]] =0;
				}
				for(int i = N-1;i>0;i--) {
					tempArr[i] = tempArr[i-1].clone();
				}
				tempArr[0] = new int[M];
			}
			answer = Math.max(answer, tempAnser);
			return;
		}
		for(int i = index;i<M;i++) {
			picked[depth]=i;
			recur(depth+1,i+1);
		}
	}
}