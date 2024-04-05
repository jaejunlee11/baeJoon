/*
 * 문제
 * 1. 상어가 존재
 * 2. 낚시왕이 1칸씩 이동하면서 상어를 잡음
 * 3. 상어들이 각자에 속력에 맞게 이동
 * 4. 상어가 겹치면 큰 상어가 잡아먹음
 * 5. 잡은 상어의 합은
 * 
 * 풀이
 * 1. R,C,M입력
 * 2. arr[R][C]생성
 * 3. shark Priorityqueue생성(크기로 역정렬)
 * 4. shark 담기 => (r-1,c-1,속력,이동방향,크기)
 * 5. for문 돌기 => C만큼 돌기
 * 	5.1. shark에서 poll하기
 * 	5.2. dir이 상인 경우 => 속도 + (R-1)+(R-1)-r 을 (R-1)로 나누기 => 결과값%2==0인 경우 방향 바꾸기 + 나온 좌표, 아닌 경우 (R-1)-나머지값
 * 	5.3. dir이 하인 경우 => 속도 + r을 (R-1)로 나눴을때 결과값이 짝수 => 나머지값을 좌표로 바로 사용, 홀수=> (R-1)-나머지값 사용 + 방향 변경
 * 	5.4. dir이 좌인 경우 => 속도 + (C-1)+(C-1)-c를 (C-1)로 나누기 => (C-1)-나머지(홀수) or 나온 좌표값(짝수)
 * 	5.5. dir이 우인 경우 => 속도 + c를 (C-1)로 나누기 => (C-1)-나머지(홀수) or 나온 좌표값(짝수)
 * 	5.6. 해당 좌표의 arr을 확인하여 0이면 2번째 큐와 좌표에 숫자 넣기
 * 	5.7. 이미 숫자가 있는 경우 pass
 * 	5.8. shark를 전부 뺸 경우 => arr[x][i]를 탐색하여 처음 만난 상어의 크기를 answer에 더하기
 * 6.answer 출력
 */
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[R][C];
		PriorityQueue<int[]> shark1 = new PriorityQueue<>((o1,o2)->o2[4]-o1[4]);
		PriorityQueue<int[]> shark2 = new PriorityQueue<>((o1,o2)->o2[4]-o1[4]);
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			shark2.add(new int[] {r,c,v,dir,size});
		}
		int answer = 0;
		for(int t = 0; t<C;t++) {
			List<int[]> sharkList = new ArrayList<>();
			while(!shark2.isEmpty()) {
				int[] shark = shark2.poll();
				if(shark[1]!=t) {
					shark1.add(shark);
				}else {
					sharkList.add(shark);
				}
			}
			Collections.sort(sharkList,(o1,o2)->o1[0]-o2[0]);
			if(sharkList.size()!=0) {
				answer += sharkList.get(0)[4];
				for(int i = 1;i<sharkList.size();i++) {
					shark1.add(sharkList.get(i));
				}
			}


			arr = new int[R][C];
			shark2 = new PriorityQueue<>((o1,o2)->o2[4]-o1[4]);

			A : while(!shark1.isEmpty()) {
				int[] shark = shark1.poll();
				int r = shark[0];
				int c = shark[1];
				int v = shark[2];
				if(shark[3]==1) {
					int temp = (2 * (R-1) + v - r)/(R-1);
					if(temp%2==0) {
						int nr = (2 * (R-1) + v - r)%(R-1);
						if(arr[nr][c]!=0) continue A;
						arr[nr][c]=shark[4];
						shark2.add(new int[] {nr,c,v,2,shark[4]});
					}else {
						int nr = (R-1)-((2 * (R-1) + v - r)%(R-1));
						if(arr[nr][c]!=0) continue A;
						arr[nr][c]=shark[4];
						shark2.add(new int[] {nr,c,v,1,shark[4]});
					}
				}else if(shark[3]==2) {
					int temp = (v + r)/(R-1);
					if(temp%2==0) {
						int nr =(v + r)%(R-1);
						if(arr[nr][c]!=0) continue A;
						arr[nr][c]=shark[4];
						shark2.add(new int[] {nr,c,v,2,shark[4]});
					}else {
						int nr = (R-1)-((v + r)%(R-1));
						if(arr[nr][c]!=0) continue A;
						arr[nr][c]=shark[4];
						shark2.add(new int[] {nr,c,v,1,shark[4]});
					}
				}else if(shark[3]==4) {
					int temp = (2 * (C-1) + v - c)/(C-1);
					if(temp%2==0) {
						int nc = (2 * (C-1) + v - c)%(C-1);
						if(arr[r][nc]!=0) continue A;
						arr[r][nc]=shark[4];
						shark2.add(new int[] {r,nc,v,3,shark[4]});
					}else {
						int nc = (C-1)-((2 * (C-1) + v - c)%(C-1));
						if(arr[r][nc]!=0) continue A;
						arr[r][nc]=shark[4];
						shark2.add(new int[] {r,nc,v,4,shark[4]});
					}
				}else if(shark[3]==3) {
					int temp = (v + c)/(C-1);
					if(temp%2==0) {
						int nc =(v + c)%(C-1);
						if(arr[r][nc]!=0) continue A;
						arr[r][nc]=shark[4];
						shark2.add(new int[] {r,nc,v,3,shark[4]});
					}else {
						int nc = (C-1)-((v + c)%(C-1));
						if(arr[r][nc]!=0) continue A;
						arr[r][nc]=shark[4];
						shark2.add(new int[] {r,nc,v,4,shark[4]});
					}
				}
			}
		}
		System.out.println(answer);
	}
}