public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        A : for(String skillTree : skill_trees) {
        	int start=0;
        	for(int i = 0;i<skillTree.length();i++) {
        		if(skillTree.charAt(i)==skill.charAt(start)) start++;
        		if(start>=skill.length()-1) {
        			answer++;
        			continue A;
        		}
        		for(int j = start+1;j<skill.length();j++) {
        			if(skillTree.charAt(i)==skill.charAt(j)) continue A;
        		}
        	}
        	answer++;
        }
        return answer;
    }
}