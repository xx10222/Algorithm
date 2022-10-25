package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj11656 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> list = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            list.add(s.substring(i));
        }
        Collections.sort(list);
        for(String str : list) {
            System.out.println(str);
        }
    }
}
