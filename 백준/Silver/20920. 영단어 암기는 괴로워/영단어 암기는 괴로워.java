/*
 * 문제
 * 1. 영어 단어장 만들기
 * 2. 많이 나온 것 앞쪽
 * 3. 길이가 긴 것  앞쪽
 * 4. 알파벳 사전 순 앞쪽
 * 5. M보다 짧으면 제거
 * 
 * 풀이
 * 1. N, M입력
 * 2. arr[N]생성
 * 3. arr 채우기 => 길이 M이상 제거
 * 4. arr정렬 => length -> compareto
 * 5.출력
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String,Integer> map = new HashMap<>();
		for(int i = 0;i<N;i++) {
			String temp = br.readLine();
			if(temp.length()<M) continue;
			if(map.containsKey(temp)) {
				map.put(temp, map.get(temp)+1);
			}else {
				map.put(temp, 1);
			}
		}
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list,(o1,o2)->{
			if(map.get(o1)==map.get(o2)) {
				if(o1.length()==o2.length()) {
				return o1.compareTo(o2);
			}
			return o2.length()-o1.length();
			}
			return map.get(o2)-map.get(o1);
		});
		StringBuilder sb = new StringBuilder();
		for(String temp : list) {
			sb.append(temp+"\n");
		}
		System.out.println(sb);
	}
}