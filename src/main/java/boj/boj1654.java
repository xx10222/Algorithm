package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = (Integer.parseInt(br.readLine()));
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        long min = 0;
        long mid = 0;
        max++;

        while (min < max) {
            mid = (min + max) / 2;
            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += (arr[i]/ mid);
            }

            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
