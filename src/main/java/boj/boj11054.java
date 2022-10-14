package boj;

import java.util.Scanner;

public class boj11054 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] udp = new int[n]; // 증가 수열
        int[] ddp = new int[n]; // 감소 수열
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }

        for(int i=0;i<n;i++) {
            udp[i]=1;
            for(int j=0;j<i;j++) {
                if(arr[j]<arr[i] && udp[i]<udp[j]+1) {
                    udp[i] = udp[j]+1;
                }
            }
        }

        for(int i=n-1;i>=0;i--) {
            ddp[i]=1;
            for(int j=n-1;j>i;j--) {
                if(arr[i]>arr[j] && ddp[i]<ddp[j]+1) {
                    ddp[i]=ddp[j]+1;
                }
            }
        }

        int answer = 0;
        for(int i=0;i<n;i++) {
            if(answer < udp[i]+ddp[i]) {
                answer = udp[i]+ddp[i];
            }
        }

        answer -= 1;
        System.out.println(answer);
    }
}
