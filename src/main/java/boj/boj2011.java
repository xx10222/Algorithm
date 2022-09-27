package boj;

import java.util.Scanner;

public class boj2011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if(s.charAt(0)=='0') {
            System.out.println("0");
            return;
        }

        long[] dp = new long[s.length()+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=s.length();i++) {
            char c = s.charAt(i-1); //현재 문자
            char prev = s.charAt(i-2); //앞 문자

            if(c == '0') { //현재 문자가 0인 경우
                if(prev == '1' || prev == '2') { //앞문자가 1 또는 2여야만 암호 해독 가능
                    dp[i] = dp[i-2] %1000000;
                } else { // 앞문자와 연결이 안되면 잘못된 문자열이므로 종료
                    break;
                }
            } else {
                // 앞 문자가 0이면 경우의 수 변화 없음
                if(prev=='0') {
                    dp[i] = dp[i-1] % 1000000;
                    continue;
                }

                // 앞 문자와 연결할 수 있는지 확인
                int num = (prev-'0')*10 + (c-'0');
                if(num >= 1 && num <= 26) {
                    dp[i] = (dp[i-2]+dp[i-1]) % 1000000;
                    continue;
                }
                dp[i] = dp[i-1]%1000000;
            }
        }
        System.out.println(dp[s.length()]%1000000);
    }
}
