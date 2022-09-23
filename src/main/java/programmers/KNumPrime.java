package programmers;

public class KNumPrime {
    public int solution(int n, int k) {
        int answer = 0;
        String s = "";
        while(n>0) {
            s = (n%k) + s;
            n/=k;
        }
        s = s.replaceAll("00", "0");

        String[] arr = s.split("0");

        for(String a : arr) {
            long num = Long.parseLong(a);
            if(isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrime(long num) {
        if(num==1) {
            return false;
        }
        if(num==2) {
            return true;
        }
        for(long i=3;i<=Math.sqrt(num);i++) {
            if(num%i==0) {
                return false;
            }
        }
        return true;
    }
}
