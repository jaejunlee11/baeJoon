/*
 * 문제
 * 1. 열쇠가 있으면 문을 열 수 있음
 * 2. 가장자리에 *이 아닌 곳으로 들어갈 수 있음
 * 3. 열쇠를 주우면 사용할 수 있음
 * 4. 훔칠 수 있는 최대 문서의 수는?
 * 
 * 풀이
 * 1. 테케 입력
 * 2. h,w입력
 * 3. map[h][w] 생성, visited[h][w] 생성
 * 4. map 입력
 * 5. key[26]생성
 * 6. tempString 입력 => key[temp.charAt(0)-'a'] = true
 * 7. que 생성 {r,c,door}
 * 7. map 가장 자리 순회 => visited처리 + que담기 => 문인 경우 map - 'A'를 door에 저장, ., key인 경우 -1 door에 저장
 * 8. while(true)
 * 	8.1. queSize 체크
 * 	8.2. while(queSize만큼)
 * 		8.2.1. loc = que.poll
 * 		8.2.2. loc[2]가 -1인 경우, loc[2]가 -1이 아닌 경우 => key확인, fals면 다시 que에 넣기
 * 		8.2.2. for 4방 탐색
 * 			8.2.2.1. nr = loc[0] + dir
 * 			8.2.2.2. nc = loc[1] + dir
 * 			8.2.2.3. 경계 체크 + visited 체크
 * 			8.2.2.4. visited처리
 * 			8.2.2.5. map이 * 이면 continue
 * 			8.2.2.6. map이 . 이면 que에 담기
 * 			8.2.2.7. map이 문이면 que에 door값 계산해서 담기
 * 			8.2.2.8. map이 key이면 que에 담기 + key[] = true로 변경
 * 			8.2.2.9. $이면 answer + 1
 * 	8.3. queSize 체크 => 아까와 동일하면 break
 * 9. answer 출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			boolean[] key = new boolean[26];
			boolean[][] visited = new boolean[h][w];
			char[][] map = new char[h][w];
			for(int i = 0;i<h;i++) {
				String temp = br.readLine();
				for(int j = 0;j<w;j++) {
					map[i][j] = temp.charAt(j);
				}
			}
			String keys = br.readLine();
			if(!keys.equals("0")) {
				for(int i = 0;i<keys.length();i++) {
					key[keys.charAt(i)-'a']=true;
				}
			}
			int answer = 0;
			Deque<int[]> que = new ArrayDeque<>();
			for(int i = 0;i<h;i++) {
				visited[i][0] = true;
				if(map[i][0]!='*') {
					if(map[i][0]=='.') {
						que.add(new int[] {i,0,-1});
					}else if(map[i][0]<='z' && map[i][0]>='a'){
						que.add(new int[] {i,0,-1});
						key[map[i][0]-'a'] = true;
					}else if(map[i][0]=='$'){
						que.add(new int[] {i,0,-1});
						answer++;
					} else{
						que.add(new int[] {i,0,map[i][0]-'A'});
					}
				}
				visited[i][w-1] = true;
				if(map[i][w-1]!='*') {
					if(map[i][w-1]=='.') {
						que.add(new int[] {i,w-1,-1});
					}else if(map[i][w-1]<='z' && map[i][w-1]>='a'){
						que.add(new int[] {i,w-1,-1});
						key[map[i][w-1]-'a'] = true;
					}else if(map[i][w-1]=='$'){
						que.add(new int[] {i,w-1,-1});
						answer++;
					} else{
						que.add(new int[] {i,w-1,map[i][w-1]-'A'});
					}
				}
			}
			for(int i = 1;i<w-1;i++) {
				visited[0][i] = true;
				if(map[0][i]!='*') {
					if(map[0][i]=='.') {
						que.add(new int[] {0,i,-1});
					}else if(map[0][i]<='z' && map[0][i]>='a'){
						que.add(new int[] {0,i,-1});
						key[map[0][i]-'a'] = true;
					}else if(map[0][i]=='$'){
						que.add(new int[] {0,i,-1});
						answer++;
					} else {
						que.add(new int[] {0,i,map[0][i]-'A'});
					}
				}
				visited[h-1][i] = true;
				if(map[h-1][i]!='*') {
					if(map[h-1][i]=='.') {
						que.add(new int[] {h-1,i,-1});
					}else if(map[h-1][i]<='z' && map[h-1][i]>='a'){
						que.add(new int[] {h-1,i,-1});
						key[map[h-1][i]-'a'] = true;
					}else if(map[h-1][i]=='$'){
						que.add(new int[] {h-1,i,-1});
						answer++;
					} else{
						que.add(new int[] {h-1,i,map[h-1][i]-'A'});
					}
				}
			}
			int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
			while(true) {
				int queSize = que.size();
//				System.out.println(queSize);
				boolean flag = false;
				while(queSize-- >0) {
					int[] loc = que.poll();
//					System.out.println(Arrays.toString(loc));
					if(loc[2]!=-1) {
						if(!key[loc[2]]) {
							que.add(loc);
							continue;
						}
					}
					flag=true;
					int r = loc[0];
					int c = loc[1];
					for(int k = 0;k<4;k++) {
						int nr = r + dir[k][0];
						int nc = c + dir[k][1];
						if(nr>= h || nc>=w || nr<0 || nc<0) continue;
						if(visited[nr][nc]) continue;
						visited[nr][nc] = true;
						if(map[nr][nc] == '*') continue;
						if(map[nr][nc]<='Z' && map[nr][nc]>='A') {
							que.add(new int[] {nr,nc,map[nr][nc]-'A'});
							continue;
						}
						
						if(map[nr][nc] == '$') {
							answer++;
						}
						if(map[nr][nc]<='z' && map[nr][nc]>='a') {
							key[map[nr][nc]-'a'] = true;
						}
						que.add(new int[] {nr,nc,-1});
					}
				}
//				System.out.println(Arrays.toString(key));
				if(flag==false) break;
			}
			System.out.println(answer);
		}
	}
}