package boj;

import java.util.Scanner;
import java.util.Stack;

public class boj9012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=0;i<n;i++) {
            String str = scanner.next();
            if(isCorrect(str)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='(') {
                stack.push('(');
            } else if(stack.empty()) {
                return false;
            } else {
                stack.pop();
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
