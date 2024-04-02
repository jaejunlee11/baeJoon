
/*
 * 문제
 * 1. 사람 수 n이 존재
 * 2. n명에서 돌아가면서 끝말잇기 진행
 * 3. 이미 나온 단어, 끝 단어가 일치하지 않으면 종료
 * 4. 틀린 사람의 번호와 차례 출력
 * 
 * 풀이
 * 1. set생성
 * 2. words 순회 => count=1 , number =1, lastWord
 * 	2.0. number++ => number>N이면 number=1, count++
 * 	2.1. set에 wrods넣기 => false시 종료
 * 	2.2. count ==1, number==1일 때만 제외 => lastWord와 word.chartAt(0)가 다르면 종료
 * 	2.3. lastWord = word.chartAt(word.length-1);
 * 3. {number, count}출력
 */
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        HashSet<String> set = new HashSet<>();
        int count = 1;
        int number = 0;
        char lastWord='0';
        int[] answer = {0,0};
        for(String word : words) {
        	System.out.println(lastWord);
        	number++;
        	if(number>n) {
        		count++;
        		number=1;
        	}
        	if(!set.add(word)) {
        		answer = new int[] {number,count};
        		break;
        	}
        	if(number==1 && count==1) {
        		lastWord=word.charAt(word.length()-1);
        		continue;
        	}
        	if(lastWord!=word.charAt(0)) {
        		answer = new int[] {number,count};
        		break;
        	}
        	lastWord=word.charAt(word.length()-1);
        }

        return answer;
    }
}