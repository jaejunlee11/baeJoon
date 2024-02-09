import java.util.*;

public class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		Integer[] temp1 = new Integer[progresses.length];
		Integer[] temp2 = new Integer[speeds.length];
		for(int i = 0;i<temp1.length;i++) {
			temp1[i] = progresses[i];
			temp2[i] = speeds[i];
		}
		List<Integer> progressList = new ArrayList<>(Arrays.asList(temp1));
		List<Integer> speedList = new ArrayList<>(Arrays.asList(temp2));
		List<Integer> answerList = new ArrayList<>();
		while(progressList.size()!=0) {
			for(int  i = 0;i<progressList.size();i++) {
				progressList.set(i, progressList.get(i)+speedList.get(i));
			}
			int count = 0;
			for(int i = 0;i<progressList.size();i++) {
				if(progressList.get(i)<100) break;
				count++;
			}
			for(int i = count-1;i>=0;i--) {
				progressList.remove(i);
				speedList.remove(i);
			}
			if(count!=0) answerList.add(count);
		}
        Integer[] answers = answerList.toArray(new Integer[answerList.size()]);
        int[] answer = new int[answers.length];
        for(int i = 0;i<answer.length;i++) {
        	answer[i] = answers[i];
        }
        return answer;
    }
}