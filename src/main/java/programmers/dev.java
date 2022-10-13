package programmers;

import java.util.Arrays;

public class dev {
    public static void main(String[] args) {
        String[] registered_list = {"cow", "cow1","cow2","cow3","cow4","cow5","cow6","cow7","cow8","cow9"};
        String new_id = "cow";
        String answer = "";
        if(!Arrays.asList(registered_list).contains(new_id)) {
            System.out.println(new_id);
            return;
        }

        int index=0;
        for(int i=3;i<new_id.length();i++) { // S+N 구분
            if(new_id.charAt(i)>='a' && new_id.charAt(i)<='z') {
                continue;
            }
            index=i;
            break;
        }

        String s = new_id;
        int n = 0;
        if(index!=0) {
            s = new_id.substring(0,index);
            n = Integer.parseInt(new_id.substring(index));
        }

        while(true) {
            n++;
            String str = s+n;
            System.out.println(str);
            if(!Arrays.asList(registered_list).contains(str)) {
                answer = str;
                break;
            }
        }

        System.out.println(answer);
    }
}
