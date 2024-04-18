/*
풀이
0. course크기 map[order크기]생성 <String, Integer>
1. for문 돌리기 => orders
    1.0 picked[orders[크기-1]] 생성, maxCount[order크기]
    1.1. order.length = N
    1.2. recur(0,0,"")
2. for문돌리기 order크기
    2.1. map[i]의 key를 꺼내기
    2.2. key순회 value가 maxCount[i]인 값들을 answer리스트에 넣기
3. answerList정렬
4. answer 배열로 변경 후 출력


recur(int index,int depth,String word)
1. for문 돌리기 => course 크기
    1.1. course[i] == depth
        1.1.0. map[i].contain(temp)면  map.put(temp,map.get(temp)+1);
        1.1.0. map.get(temp)+1으로 maxCount갱신
        1.1.1. 아니면 map[i].put(temp,1)
        1.1.2. break;
2. depth == N이면 return;
3. for문 돌리기 index ~ N
    3.1. recur(i+1,depth+1,word+order.charAt(i));
*/
import java.util.*;
class Solution {
    Map<String,Integer>[] maps;
    int[] maxCount;
    int[] courseC;
    int N;
    int courseSize;
    String[] ordersC;
    public String[] solution(String[] orders, int[] course) {
        courseSize = course.length;
        int ordersSize = orders.length;
        maps = new Map[courseSize];
        maxCount = new int[courseSize];
        courseC = course.clone();
        ordersC = orders.clone();
        for(int i = 0;i<ordersSize;i++){
            String temp = orders[i];
            String[] tempChar = temp.split("");
            Arrays.sort(tempChar);
            String b = "";
            for(String a : tempChar){
                b+=a;
            }
            System.out.println(b);
            ordersC[i] = b;
        }
        for(int i = 0;i<courseSize;i++){
            maps[i] = new HashMap();
        }
        for(int i = 0;i<ordersSize;i++){
            N = orders[i].length();
            recur(0,0,"",ordersC[i]);
        }
        List<String> answerList = new ArrayList<>();
        for(int i = 0;i<courseSize;i++){
            Set<String> set = maps[i].keySet();
            for(String word : set){
                if(maps[i].get(word)==maxCount[i] && maxCount[i]!=1){
                    answerList.add(word);
                }
            }
        }
        Collections.sort(answerList);
        String[] answer = {};
        answer = answerList.toArray(new String[answerList.size()]);
        return answer;
    }
    private void recur(int index,int depth,String word,String order){
        for(int i = 0;i<courseSize;i++){
            if(courseC[i]==depth){
                if(maps[i].containsKey(word)){
                    int temp = maps[i].get(word);
                    temp++;
                    if(temp>maxCount[i]){
                        maxCount[i]=temp;
                    }
                    maps[i].replace(word,temp);
                }else{
                    maps[i].put(word,1);
                }
            }
        }
        if(depth==N) return;
        for(int i = index;i<N;i++){
            recur(i+1,depth+1,word+order.charAt(i),order);
        }
    }
}