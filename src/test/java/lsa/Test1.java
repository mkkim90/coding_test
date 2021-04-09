package lsa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import util.ApiHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    /**
     * Method안의 로직은 아래와 같은 기능을 구현해야 한다.
     * 1. https://s3.ap-northeast-2.amazonaws.com/bunjang-interview/events.json
     * - 해당 URL을 콜하고 리턴되는 데이터를 가져와서 Model 클래스로 적용하고 데이터를 분석해야 한다.
     *
     * 해당 포맷으로 만들
     * [
     * {
     * login: "rafaelfranca”,
     * events: {
     * TotalEvent: 20,
     * IssueCommentEvent: 10,
     * PullRequestEvent: 3,
     * IssuesEvent: 3,
     * PushEvent: 2,
     * PullRequestReviewCommentEvent: 2
     * }
     * }
     * ]
     * 참고 : http://3.35.177.204:8080/api/event?sort=PushEvent
     */
    @Test
    void test() throws IOException {
        ApiHelper apiHelper = new ApiHelper();
        String response = apiHelper.request("https://s3.ap-northeast-2.amazonaws.com/bunjang-interview/events.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> results = objectMapper.readValue(response, new ArrayList<Map<String, Object>>().getClass());

        List<Map<String, Object>> bodys = new ArrayList<>();
        for (Map<String, Object> result : results) {
            Map<String, Object> actor = (Map<String, Object>) result.get("actor");
            String login = (String) actor.get("login");
            String type = (String) result.get("type");

            Map<String, Object> initBody = new HashMap<>();
            if (bodys.size() == 0 || !loginSame(bodys, login)) {
                initBody.put("login", login);
                bodys.add(initBody);
            }


            for (Map<String, Object> body : bodys) {
                if (body.get("login").equals(login)) {
                    Map<String, Integer> events = new HashMap<>();
                    if (body.containsKey("events")) {
                        events = (Map<String, Integer>) body.get("events");
                    }
                    events.put(type, events.getOrDefault(type, 0) + 1);
                    body.put("events", events);
                }
            }
        }


        System.out.println(objectMapper.writeValueAsString(bodys));
    }

    private boolean loginSame(List<Map<String, Object>> bodys, String login) {
        return bodys.stream().anyMatch(i -> i.get("login").equals(login));
    }
}
