import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] shortPeople = new int[9];
		for(int i =0;i<9;i++) {
			shortPeople[i] = Integer.parseInt(br.readLine());
		}
		int sum = 0;
		for(int e : shortPeople) {
			sum+=e;
		}
		A: for(int i = 0 ; i <9;i++) {
			for(int j = 0;j<9;j++) {
				if(i == j) {
					
				}else {
					if((sum - shortPeople[i]-shortPeople[j]) == 100) {
						int x =shortPeople[i];
						int y = shortPeople[j];
						Arrays.sort(shortPeople);
						for(int k = 0;k<9;k++) {
							if(shortPeople[k]!=x && shortPeople[k]!=y)
								System.out.println(	shortPeople[k]);
						}
						break A;
					}
				}
			}
		}
	}

}
