package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj2751 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++) {
            arr.add(scanner.nextInt());
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int num : arr) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}
