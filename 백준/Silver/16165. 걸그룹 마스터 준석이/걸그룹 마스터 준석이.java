/*
 * 묹제
 * 1. 걸그룹 존재
 * 2. 걸그룹 이름, 인원수 , 멤버의 이름들 입력
 * 3. 문제가 주어짐
 * 4. 0 팀이름 ,1 멤버 이름 
 * 5. 가장 첫번째 멤버 이름, 걸그룹 이름 출력
 * 
 * 풀이
 * 1. 걸그룹 수, 문제 수 입력
 * 2. 걸그룹 HashMap생성(String,String) , (String,String)
 * 3. List생성 후 입력 받기 => List정렬 후 HashMap에 첫번째 값 넣기 + 2번째 hashmap에 넣기 
 * 4. 문제입력
 * 	4.1. 0 => 1번째 hashMap을 보고 꺼내기 
 * 	4.2. 1 => 2번째 hashMap보고 꺼내기 
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String,List<String>> girlGruop = new HashMap<>();
		Map<String,String> peopleName = new HashMap<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i = 0;i<N;i++) {
			String girGroupName = br.readLine();
			int num = Integer.parseInt(br.readLine());
			List<String> tempList = new ArrayList<>();
			for(int j = 0;j<num;j++) {
				String name = br.readLine();
				tempList.add(name);
				peopleName.put(name, girGroupName);
			}
			Collections.sort(tempList);
			girlGruop.put(girGroupName,tempList);
		}
		for(int i = 0;i<M;i++) {
			String question = br.readLine();
			int q = Integer.parseInt(br.readLine());
			if(q==0) {
				List<String> tempList = girlGruop.get(question);
				for(String output : tempList) {
					System.out.println(output);
				}
			}else {
				System.out.println(peopleName.get(question));
			}
		}
	}
}