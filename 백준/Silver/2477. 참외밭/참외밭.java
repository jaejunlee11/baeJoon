import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. 참외갯수 입력
 * 2. 육각형 그리기(반시계) -> 일반적인 모양 북(4) -> 서(2) -> 님(3) -> 동(1)
 * 						  ㄱ모양 추가로 남(3) -> 동(1)
 * 	2-1. 추가안된 부분 -> 최대 길이(2개의 곱)
 * 	2-2. 겹친 부분 -> 최대 길이 위치로 판단 (2개의 곱)
 * 	 2-2-1. 최대길이 == 2개,4개 이후의 값
 * 	2-3. 곱의 차 구하기
 * 3. 참외 갯수 * 크기
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		for(int i =0;i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int width = 0;
		int height = 0;
		for(int i = 0; i<6;i++) {
			if(i%2==0) {
				if(width<arr[i]) {
					width = arr[i];
				}
			}else {
				if(height<arr[i]) {
					height = arr[i];
				}
			}
		}
		int innerHeigth = 0;
		int innerWidth = 0;
		for(int i =0 ;i < 6;i++) {
			if(width == arr[(i+1)%6]+arr[(i+5)%6]) {
				innerHeigth = arr[i];
			}
			if(height == arr[(i+1)%6]+arr[(i+5)%6]) {
				innerWidth = arr[i];
			}
		}
		System.out.println(N*(width*height-innerHeigth*innerWidth));
	}
}