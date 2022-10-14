package boj;

import java.util.Scanner;

public class boj10799 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        int answer = 0;
        int open = 0;
        if(str.charAt(0)=='(') {
            open++;
        }
        for(int i=1;i<str.length();i++) {
            char c = str.charAt(i);
            if(c=='(') { // 괄호(막대기) 시작
                open++;
            } else {
                open--; // 괄호(막대기) 끝
                if(str.charAt(i-1)=='(') {
                    answer += open;
                } else {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
