package boj;

import java.util.Scanner;

public class boj11655 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        // 대문자, 소문자 구분 - 각자 13글자씩 밀어준다
        // A=65 Z=90 a=97 z=122
        for(int i=0;i<s.length();i++) {
            int c = s.charAt(i);
            if(c >= 'a' && c <= 'z') {
                c += 13;
                if(c > 122) {
                    c = 97 + (c-123);
                }
            } else if(c >= 'A' && c <= 'Z') {
                c += 13;
                if(c > 90) {
                    c = 65 + (c-91);
                }
            }
            sb.append((char)c);
        }
        System.out.println(sb);
    }
}
