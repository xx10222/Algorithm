package groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class moday2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0;i<n;i++) {
            int v = scanner.nextInt();
            int[] arr = new int[v];
            double avg = 0;
            for(int j=0;j<v;j++) {
                arr[j] = scanner.nextInt();
                avg += arr[j];
            }
            avg /= v;
            int count = 0;
            for(int j=0;j<v;j++) {
                if(arr[j]>=avg) {
                    count++;
                }
            }
            System.out.println(count+"/"+v);
        }
    }
}
