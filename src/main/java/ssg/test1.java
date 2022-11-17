package ssg;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class test1 {
    public int solution(String[] members, String[][] commands, String messageID) {
        /*
        [
        [“W”, “MY”, “1”],
        [“W”, “A”, “7”],
        [“W”, “B”, “4”],
        [“W”, “MY”, “9”],
        [“W”, “A”, “11”],
        [“R”, “B”, “”]
        ]
        */
        int answer = 0;
        int memberNum = members.length; // 본인 제외한 인원 수
        int i=0;
        String target = "";
        for(i=0;i<commands.length;i++) {
            if(commands[i][2].equals(messageID)) {
                target = commands[i][1];
                break;
            }
        }
        // 현재 i -> 해당 메시지 인덱스
        Set<String> readMembers = new HashSet<>();
        for(int j=i+1;j<commands.length;j++) {
            if(!commands[j][1].equals(target)) {
                readMembers.add(commands[j][1]);
            }
        }
        answer = memberNum-readMembers.size();

        return answer;
    }

}
