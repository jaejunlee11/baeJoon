import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int day = 0;
		if(x == 1) {
			day = y;
		}else if(x == 2) {
			day = 31 + y;
		}else if(x<=8) {
			if(x%2==0) {
				day = 90 + (x-4)/2 * 61  + y;
			}else {
				day = 59 + (x-3)/2 * 61 + y;
			}
		}else if(x<=12){
			if(x%2==0) {
				day = 273 + (x-10)/2 * 61  + y;
			}else {
				day = 243 + (x-9)/2 * 61 + y;
			}
		}	
		switch(day%7) {
		case 1:System.out.println("MON");break;
		case 2:System.out.println("TUE");break;
		case 3:System.out.println("WED");break;
		case 4:System.out.println("THU");break;
		case 5:System.out.println("FRI");break;
		case 6:System.out.println("SAT");break;
		case 0:System.out.println("SUN");break;
		}
	}

}