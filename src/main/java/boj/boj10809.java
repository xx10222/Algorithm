package boj;

import java.util.Scanner;

public class boj10809 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] arr = new int[26]; //a-97
        for(int i=0;i<26;i++) {
            arr[i]=-1;
        }
        for(int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            int index = c-97;
            if(arr[index]==-1) {
                arr[index]=i;
            }
        }
        for(int i=0;i<26;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
