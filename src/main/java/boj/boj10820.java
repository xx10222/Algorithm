package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        String str;
        int lower, upper, number, space;

        while((str=br.readLine()) != null) {
            sb = new StringBuilder();
            lower = 0;
            upper = 0;
            number = 0;
            space = 0;

            for(int i=0;i<str.length();i++) {
                Character c = str.charAt(i);
                if(c == ' ') {
                    space++;
                }
                if(c >= 'a' && c <= 'z') {
                    lower++;
                }
                if(c >= 'A' && c <= 'Z') {
                    upper++;
                }
                if(c >= '0' && c <= '9') {
                    number++;
                }
            }
            System.out.println(lower + " " + upper + " " + number + " " + space);
        }
    }

}
