package groom;

import java.util.Scanner;

public class countWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = 0;
        boolean check = false;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == ' ') {
                check = false;
            } else {
                if(!check) {
                    count++;
                    check = true;
                }
            }
        }
        System.out.println(count);
    }
}
