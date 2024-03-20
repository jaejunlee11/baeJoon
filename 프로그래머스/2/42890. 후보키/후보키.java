
/*
 * 문제
 * 1. 후보키 최대 갯수
 * 2 유일성 : 유일하게 존재
 * 3.최소성 : 최소한의 개수로 구성
 * 
 * 풀이
 * 1. relation의 크기 구하기
 * 2. for(relation의 크기)
 * 	2.1. recur 돌리기
 * 
 * recur(depth, arr,index)
 * 1. for문 돌리기(arr크기)
 * 	1.1. set에 넣고 크기가 arr과 다르면 return
 * 2. depth == relation크기 return
 * 
 * 3. for문 돌리기(index~relation 크기)
 * 	3.1. arr temp에 복제
 * 		3.1.1. temp에 relation[i]붙이기
 * 		3.1.2. recur(depth+1,temp,i+1)
 * 
 * 문제점
 * 1. 0 > 01 > 012식으로 이동이되기때문에 12가 최소성을 만족하는 후보키인데 거를 수 가 없음, 같은 원리로 02가 최소성을 만족해도
 * 
 * 해결책
 * 1. 
 */
import java.util.*;
class Solution {
	static int relationSize;
	static int arrSize;
	static String[][] rela;
	static int answer;
	static List<String> answerList = new ArrayList<>();
    static public int solution(String[][] relation) {
        answer = 0;
        relationSize = relation[0].length;
        arrSize = relation.length;
        rela = relation;
//        System.out.println(arrSize);
//        System.out.println(relationSize);
        String[] temp = new String[arrSize];
        for(int i = 0;i<arrSize;i++) {
        	temp[i] = "";
        }
        recur(0,temp,0,"");
        Collections.sort(answerList,(o1,o2)->{return o1.length()-o2.length();});
        boolean[] visited= new boolean[answerList.size()];
        for(int i = 0;i<answerList.size();i++) {
//        	System.out.println(answerList.get(i));
        	if(visited[i]) continue;
        	for(int j = i+1;j<answerList.size();j++) {
        		
        		String tempS = "(.*)";
        		for(int k = 0;k<answerList.get(i).length();k++) {
        			tempS+=(answerList.get(i).charAt(k)+"(.*)");
        		}
//        		System.out.println(tempS);
            	if(answerList.get(j).matches(tempS)) {
            		visited[j]=true;
            	}
            }
        }
        for(int i = 0;i<answerList.size();i++) {
        	if(!visited[i]) answer++;
        }
        return answer;
    }
    static private void recur(int depth,String[] arr,int index,String ans) {
    	if(depth==relationSize) {
    		return;
    	}
//    	System.out.println(Arrays.toString(arr));
    	for(int i = index;i<relationSize;i++) {
    		String[] temp = arr.clone();
    		for(int j = 0;j<arrSize;j++) {
    			temp[j] = temp[j]+rela[j][i];
    		}
    		Set<String> set = new HashSet<>();
    		for(int k = 0;k<arrSize;k++) {
    			set.add(temp[k]);
    		}
    		if(set.size()!=arrSize) {
    			recur(depth+1,temp,i+1,ans+i);
    		}else {
    			answerList.add(ans+i);
    		}
    	}
    }
	// public static void main(String[] args) {
	// String[][] relation = new String[][]{ {"a","1","aaa","c","ng"},
	// {"a","1","bbb","e","g"},
	// {"c","1","aaa","d","ng"},
	// {"d","2","bbb","d","ng"}};
	// System.out.println(solution(relation));
	// }
}
