import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tempLine = br.readLine();
		int count = -1;
		for(String e:tempLine.split("")) {
			if(count%10 == 9) {
				System.out.println("");
			}
			System.out.print(e);
			count++;
		}
	}

}