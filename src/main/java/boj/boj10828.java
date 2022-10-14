package boj;

import java.util.Scanner;
import java.util.Stack;

public class boj10828 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while(n>=0) {
            n--;
            String str = scanner.nextLine();

            if(str.startsWith("push")) {
                String[] arr = str.split(" ");
                int num = Integer.parseInt(arr[1]);
                stack.push(num);
            }

            if(str.startsWith("pop")) {
                if(!stack.isEmpty()) {
                    sb.append(stack.pop());
                    sb.append("\n");
                } else {
                    sb.append("-1");
                    sb.append("\n");
                }
            }

            if(str.startsWith("size")) {
                sb.append(stack.size());
                sb.append("\n");
            }

            if(str.startsWith("empty")) {
                if(stack.isEmpty()) {
                    sb.append("1");
                    sb.append("\n");
                } else {
                    sb.append("0");
                    sb.append("\n");
                }
            }

            if(str.startsWith("top")) {
                if(!stack.isEmpty()) {
                    sb.append(stack.peek());
                    sb.append("\n");
                } else {
                    sb.append("-1");
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
