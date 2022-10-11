package programmers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchRanking {
    static Map<String, List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for(int i=0;i<info.length;i++) {
            String[] arr = info[i].split(" ");
            // 가능한 모든 조합의 문자열을 map의 key 값으로 저장
            makeSentence(arr, "", 0);
        }

        // 문자열 별 점수 리스트를 오름차순으로 정렬한다
        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for(int i=0;i<query.length;i++) {
            int count = 0; // 만족하는 인원 수
            String[] arr = query[i].split(" ");
            // - and - and - and chicken 100
            int score = Integer.parseInt(arr[7]);
            StringBuilder sb = new StringBuilder();
            sb.append(arr[0]);
            sb.append(arr[2]);
            sb.append(arr[4]);
            sb.append(arr[6]);
            if(map.containsKey(sb.toString())) {
                count = binarySearch(sb.toString(), score);
            }
            answer[i] = count;
        }

        return answer;
    }

    private static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start=0;
        int end = list.size()-1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(list.get(mid) < score) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return list.size()-start;
    }

    private static void makeSentence(String[] arr, String str, int count) {
        if(count==4) {
            if(!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(Integer.parseInt(arr[4]));
            return;
        }
        makeSentence(arr, str+"-", count+1);
        makeSentence(arr, str+arr[count], count+1);
    }
}
