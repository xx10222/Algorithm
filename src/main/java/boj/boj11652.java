package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class boj11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();

        int max = 0;
        long index = 0;
        for(int i=0;i<n;i++) {
            Long num =Long.parseLong(br.readLine());
            map.put(num,map.getOrDefault(num,0)+1);

            if(map.get(num) > max) {
                max = map.get(num);
                index = num;
            } else if(map.get(num) == max) {
                index = Math.min(num, index);
            }
        }

        System.out.println(index);


    }
}
