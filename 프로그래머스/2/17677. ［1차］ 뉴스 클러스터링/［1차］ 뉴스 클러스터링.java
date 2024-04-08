/*
문제
1. 문자열 2개 제공
2. 문자열에서 2글자씩 영어단어를 뽑아냄
3. 영어가 아닌 문자는 제외
4. 이때 합집합과 교집합을 구해서 유사도 구하기

풀이
1. arr1[26*26], arr2[26*26]생성
2. str1순회 (0~length-2)
    2.1. 'a'=<str1[i]<='z'이면 temp1 = st1.cahrAt(i)
    2.2. 'A'=<str1[i]<='Z'이면 temp1 = st1.cahrAt(i)
    2.3. 'a'=<str1[i+1]<='z'이면 temp2 = st1.cahrAt(i)
    2.4. 'A'=<str1[i+1]<='Z'이면 temp2 = st1.cahrAt(i)'
    2.5. arr1[temp1*26+temp2]++
    2.6. 이때 만약 도중에 조건 안맞는게 있으면 continue
3. str2순회 => 동일하게 채우기
4. for문 탐색 => 26*26, cCount = 0, uCount = 0
    4.1. cCount += Math.min(arr1[],arr2[])
    4.2. uCount += Math.max(arr1[],arr2[])
5. 65536*cCount/ucount
*/
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int[] arr1 = new int[26*26];
        int[] arr2 = new int[26*26];
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        for(int i = 0;i<str1.length()-1;i++){
            int temp1 = 0;
            int temp2 = 0;
            if('A'<=str1.charAt(i) && str1.charAt(i)<='Z'){
                temp1 = str1.charAt(i)-'A';
            }else{
                continue;
            }
            if('A'<=str1.charAt(i+1) && str1.charAt(i+1)<='Z'){
                temp2 = str1.charAt(i+1)-'A';
            }else{
                continue;
            }
            arr1[temp1*26+temp2]++;
        }
        for(int i = 0;i<str2.length()-1;i++){
            int temp1 = 0;
            int temp2 = 0;
            if('A'<=str2.charAt(i) && str2.charAt(i)<='Z'){
                temp1 = str2.charAt(i)-'A';
            }else{
                continue;
            }
            if('A'<=str2.charAt(i+1) && str2.charAt(i+1)<='Z'){
                temp2 = str2.charAt(i+1)-'A';
            }else{
                continue;
            }
            arr2[temp1*26+temp2]++;
        }
        int cCount = 0;
        int uCount = 0;
        for(int i = 0;i<26*26;i++){
            cCount += Math.min(arr1[i],arr2[i]);
            uCount += Math.max(arr1[i],arr2[i]);
        }
        if(uCount==0) return 65536;
        return 65536*cCount/uCount;
    }
}