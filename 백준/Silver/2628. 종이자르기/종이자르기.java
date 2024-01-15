/*
 * 1. 종이의 가로 세로 입력 받음
 * 2. 몇번 자를지 입력 받음
 * 3. 가로 세로 따로 자르는 위치 입력 받음
 * 4. 자르는 위치를 보고 최대 크기를 뽑아냄
 * 5. 가로 세로 곱해서 출력
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int heigth =  Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[] widthArr = new int[width];
		int[] heigthArr = new int[heigth];
		for(int i = 0;i<N;i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int way = Integer.parseInt(st1.nextToken());
			if(way ==0) {
				heigthArr[Integer.parseInt(st1.nextToken())] =1;
			}else {
				widthArr[Integer.parseInt(st1.nextToken())] =1;
			}
		}
		int hightMax = 0;
		int widthMax = 0;
		int tempMax = 0;
		for(int i = 0;i<width;i++) {
			if(widthArr[i]==0) {
				tempMax++;
			}else {
				if(widthMax<tempMax) {
					widthMax = tempMax;
				}
				tempMax=1;
			}
		}
		if(widthMax<tempMax) {
			widthMax = tempMax;
		}
		tempMax=0;
		for(int i = 0;i<heigth;i++) {
			if(heigthArr[i]==0) {
				tempMax++;
			}else {
				if(hightMax<tempMax) {
					hightMax = tempMax;
				}
				tempMax=1;
			}
		}
		if(hightMax<tempMax) {
			hightMax = tempMax;
		}
		System.out.println(widthMax*hightMax);
	}

}