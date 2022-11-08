package programmers;

public class 스티커모으기2 {
    public int solution(int sticker[]) {
        int len = sticker.length;
        if(len==1) {
            return sticker[0];
        }

        int[] dp1 = new int[len]; // 첫번쨰 스티커를 떼는 경우
        int[] dp2 = new int[len]; // 첫번째 스티커를 뗴지 않는 경우

        // 1) 첫번째 스티커를 뗴는 경우
        dp1[0] = sticker[0];
        dp1[1] = dp1[0]; // 첫번쨰를 뗐기 떄문에 두번째 스티커는 뗴지 않는다
        // 첫번째 스티커를 떼면 마지막 스티커를 뗴지 못하기 때문에 len-1 까지만 순회한다
        for(int i=2;i<len-1;i++) {
            dp1[i] = Math.max(dp1[i-2]+sticker[i], dp1[i-1]);
        }

        // 2) 첫번째 스티커를 뗴지 않는 경우
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i=2;i<len;i++) {
            dp2[i] = Math.max(dp2[i-2]+sticker[i], dp2[i-1]);
        }

        return Math.max(dp1[len-2], dp2[len-1]);
    }
}
