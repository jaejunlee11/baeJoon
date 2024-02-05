import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Long,Integer> map = new HashMap<Long,Integer>();
		for(int i = 0;i<N;i++) {
			long temp=Long.parseLong(br.readLine());
			if(map.containsKey(temp)) {
				map.replace(temp, (map.get(temp)+1));
			}else {
				map.put(temp, 1);
			}
		}
		List<Long> keyList = new ArrayList<Long>(map.keySet());
		Collections.sort(keyList,(o1,o2)->{
			if(map.get(o2).equals(map.get(o1))) {
				return o1.compareTo(o2);
			}else {
				return map.get(o2).compareTo(map.get(o1));
			}
		});
		System.out.println(keyList.get(0));
	}
}