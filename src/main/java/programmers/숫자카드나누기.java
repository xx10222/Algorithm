package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        List<Integer> listA = getDivisors(Arrays.stream(arrayA).distinct().toArray());
        List<Integer> listB = getDivisors(Arrays.stream(arrayB).distinct().toArray());

        for(int i=listA.size()-1;i>=0;i--) {
            int a = listA.get(i);

            Boolean check = true;
            for(int b : arrayB) {
                if(b%a==0) {
                    check = false;
                    break;
                }
            }
            if(check) {
                answer = a;
                break;
            }
        }

        for(int j=listB.size()-1;j>=0;j--) {
            int b = listB.get(j);

            Boolean check = true;
            for(int a : arrayA) {
                if(a%b==0) {
                    check = false;
                    break;
                }
            }

            if(answer<b && check) {
                answer = b;
                break;
            }
        }
        return answer;
    }

    // 배열의 원소를 모두 나눌 수 있는 수를 반환하는 메소드
    public List<Integer> getDivisors(int[] array) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(array);
        int min = array[0];

        for(int i=2;i<=min;i++) {
            Boolean check = true;
            for(int num : array) {
                if(num%i!=0) {
                    check=false;
                    break;
                }
            }
            if(check) {
                list.add(i);
            }
        }

        return list;
    }
}
