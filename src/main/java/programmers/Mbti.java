package programmers;

import java.util.HashMap;

public class Mbti {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] key = {"R","T","C","F","J","M","A","N"};
        for(int i = 0; i < key.length; i++){
            hashMap.put(key[i], 0);
        }

        for(int i=0;i<survey.length;i++) {
            int choice = choices[i];
            if(choice == 4) {
                continue;
            }
            if(choice<4) { //4-choice
                String s = String.valueOf(survey[i].charAt(0));
                hashMap.put(s, hashMap.get(s) + (4-choice));
            } else { //choice-4
                String s = String.valueOf(survey[i].charAt(1));
                hashMap.put(s, hashMap.get(s) + (choice-4));
            }
        }

        answer += getType("R", "T", hashMap);
        answer += getType("C", "F", hashMap);
        answer += getType("J", "M", hashMap);
        answer += getType("A", "N", hashMap);

        return answer;
    }
    public String getType(String a, String b, HashMap<String, Integer> hashMap) {
        int num1 = hashMap.get(a);
        int num2 = hashMap.get(b);
        if(num1 == num2) {
            return (a.compareTo(b)<0) ? a : b;
        }
        if(num1 > num2) {
            return a;
        } else {
            return b;
        }
    }
}
