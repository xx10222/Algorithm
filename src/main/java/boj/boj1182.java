import java.util.Scanner;

public class boj1182 {
    public static int n,s;
    public static int[] arr;
    public static int answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.nextInt();
        arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        answer = 0;
        dfs(0, 0);

        System.out.println(answer);

    }

    public static void dfs(int i, int count) {
        if(i==n) {
            return;
        }

        if(count + arr[i] ==s) {
            answer++;
        }

        dfs(i+1, count);
        dfs(i+1, count + arr[i]);
    }
}
