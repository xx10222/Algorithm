package ssg;

import java.util.ArrayList;
import java.util.List;

public class test2 {
    static List<String> answer;
    public static void main(String[] args) {
        String[] dictionary = new String[]{"popop", "abcd", "dsfsdfs", "serwerwe", "werwerwer" ,"dfdfderwer", "abee", "abeef"};
        answer = new ArrayList<>();
        for(int i=0;i<dictionary.length;i++) {
            answer.add(dictionary[i]);
        }
        String[][] command = new String[][] {{"lengthMatch", "@@@@"}};

        for(String[] line : command) {
            String com = line[0]; // 명령어
            String value = line[1]; // 값

            switch(com) {
                case "prefix":
                    prefix(value);
                    break;
                case "postfix":
                    postfix(value);
                    break;
                case "lengthMatch":
                    lengthMatch(value);
                    break;
            }
        }

        System.out.println(answer.toString());
    }

    private static void prefix(String value) {
        answer.removeIf(str -> !str.startsWith(value));
    }

    private static void postfix(String value) {
        answer.removeIf(str -> !str.endsWith(value));
    }

    private static void lengthMatch(String value) {
        int len = value.length(); // 단어 길이
        answer.removeIf(str -> str.length()!=len); // 길이가 다른 단어 제거

        if(value.startsWith("@") && !value.endsWith("@")) { // @ + 접미사
            for(int i=0;i<value.length();i++) {
                if(value.charAt(i)!='@') {
                    value = value.substring(i);
                    break;
                }
            }
            postfix(value);
        } else if(!value.startsWith("@") && value.endsWith("@")){ // 접두사+@
            for(int i=0;i<value.length();i++) {
                if(value.charAt(i)=='@') {
                    value = value.substring(0, i);
                    break;
                }
            }
            prefix(value);
        }
        System.out.println(answer.toString());

    }
}
