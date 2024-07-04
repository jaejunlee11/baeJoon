import java.io.*;
import java.util.*;
/*
문제
1. 문자에 폭탄 설치
2. 폭발시 문자가 사라짐
3. 연속적으로 폭팔도 가능함
4. 폭팔이 끝나고 남은 문자 출력

풀이(메모리 초과)
1. word 입력
2. boom 입력
3. while돌리기
    3.1. word의 boom을 replace
    3.2. word변화가 없으면 break
4. 남은 것 출력

풀이
1. words 입력
2. boom 입력
3. boom 크기 boomSize
4. word 크기 wordsSize
5. stack생성
6. for믄 돌기 => words크기, start = 0
    6.1. words(i) == boom(start) => stack에 words(i), start담기 => start++
    6.2. 아닌 경우 => words(i),-1담기
    6.3. start == boomSize인 경우 => start크기 만큼 pop => peek으로 start = [1] +1값으로 설정
7. poll로 문자열 출력
 */
public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        String boom = br.readLine();
        int boomSize = boom.length();
        int wordsSize = words.length();
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int start = 0;
        for(int i = 0;i<wordsSize;i++){
            int temp = words.charAt(i);
            if(temp == boom.charAt(start)){
                stack.push(new int[] {temp, start});
                start++;
                if(start==boomSize){
                    for(int j = 0;j<boomSize;j++){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        start = 0;
                    }else{
                        start = stack.peek()[1] + 1;
                    }
                }
            }else{
                start = 0;
                if(temp == boom.charAt(0)){
                    stack.push(new int[] {temp, start});
                    start++;
                }else{
                    stack.push(new int[] {temp, -1});
                }

            }
        }
        if(stack.isEmpty()){
            System.out.print("FRULA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append((char)stack.pollLast()[0]);
        }
        System.out.print(sb);
    }
}
/*
abcdef
abd
 */