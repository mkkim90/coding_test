package programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 프로그래머스 오픈채팅
 * record	result
 * ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
 * ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
 */
public class OpenChatTest {
    private Map<String, String> nickName = new HashMap<>();
    @Test
    void openChat() {
        String[] records = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        List<String> enterLeaveRecord = new ArrayList<>();
        for (String record : records) {
            // 닉네임 추출
            if (record.indexOf("Enter") > -1 || record.indexOf("Change") > -1) {
                String[] splitRecord = record.split(" ");
                nickName.put(splitRecord[1], splitRecord[2]);
            }

            // 출력 메세지 추출
            if (record.indexOf("Enter") > -1 || record.indexOf("Leave") > -1) {
                enterLeaveRecord.add(record);
            }
        }

        String[] result = new String[enterLeaveRecord.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = outputMessage(enterLeaveRecord.get(i));
        }
    }

    private String outputMessage(String record) {
        String[] splitRecord = record.split(" ");
        StringBuffer message = new StringBuffer();
        message.append(nickName.get(splitRecord[1]));
        message.append("님이 ");
        String verb = (splitRecord[0].indexOf("Enter") == 0) ? "들어왔습니다." : "나갔습니다.";
        message.append(verb);
        return message.toString();
    }

}
