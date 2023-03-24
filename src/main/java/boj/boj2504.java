import java.util.Scanner;
import java.util.Stack;

public class boj2504 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int value = 1; //열린 괄호에 의해 곱해진 숫자가 저장되는 변수

        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            System.out.println("c = " + c);

            switch (c) {
                case '(':
                    value *= 2;
                    stack.push(c);
                    break;
                case '[':
                    value *= 3;
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        answer = 0;
                        break;
                    }
                    if (input.charAt(i - 1) == '(') {
                        answer += value;
                    }
                    stack.pop();
                    value /= 2;
                    break;

                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        answer = 0;
                        break;
                    }
                    if (input.charAt(i - 1) == '[') {
                        answer += value;
                    }
                    stack.pop();
                    value /= 3;
                    break;
            }
            System.out.println("answer = " + answer);
            System.out.println("value = " + value);
        }
        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
