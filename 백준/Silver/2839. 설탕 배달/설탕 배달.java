/*
 * 1. 5로 나눠서 5kg 포대 갯수 구하기 -> 이때 4,7일 때 문제 발생
 * 2. 나머지 계산
 * 	2.1. 나머지가 1인 경우 -> 포대 1개 추가(1kg -> 6kg 포대 1개 감소 -> 3kg포대 2개)
 * 	2.2. 나머지가 2인 경우 -> 포대 2개 추가 (2kg -> 12kg 포대 2개 감소 ->3kg포대 4개)
 * 	2.3. 나머지가 3인 경우 -> 포대 1개 추가 (3kg -> 3kg포대 1개)
 * 	2.3. 나머지가 4인 경우 -> 포대 2개 추가 (4kg -> 9kg 포대 1개 감소 -> 3kg 포대 3개)
 */
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N==4 ||N==7 ) {
			System.out.println(-1);
		}else {
			int count = N/5;
			int temp = N%5;
			switch(temp) {
			case 0: break;
			case 1: count +=1; break;
			case 2 : count +=2; break;
			case 3 : count +=1; break;
			case 4 : count +=2; break;
			}
			System.out.println(count);
		}
	}
}
