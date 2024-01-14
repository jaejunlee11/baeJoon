/*
 * 1. 판 크기 입력 받음
 * 2. 시작 점 입력 받음
 * 3. 이동 시간 입력 받음
// * 4. 이동 시간 만큼 for문 (x좌표 +1, y좌표 +1)
// * 	4-1. x좌표가 일치하는 경우 x좌표 이동 방향 반대로 변경
// * 	4-2. y좌표가 일치하는 경우 y좌표 이동 방향 반대로 변경
 * 4. 입력 받은 시간에 시작점을 더하고  판 크기의 2배의 나머지를 계산(x,y따로 계산)
 * 5. 나머지에 맞춰 도착점 계산(판크기 보다 큰경우 -> 2*판크기 - x, 작은 경우 -> x)
 * 6. 도착점 출력
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int mapX = Integer.parseInt(st1.nextToken());
		int mapY = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st2.nextToken());
		int y = Integer.parseInt(st2.nextToken());
		int N = Integer.parseInt(br.readLine());
		int finalX = (x+N)% (mapX*2);
		int finalY = (y+N)% (mapY*2);
		if(finalX > mapX) {
			finalX = mapX*2-finalX;
		}
		if(finalY > mapY) {
			finalY = mapY*2-finalY;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.format("%d %d",finalX,finalY) + "\n");
		bw.flush();
	}

}
