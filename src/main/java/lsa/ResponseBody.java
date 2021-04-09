package lsa;

import java.util.List;
import java.util.Map;

public class ResponseBody {
    private String login;
    private List<Map<String, Integer>> events;

    public ResponseBody(String login, List<Map<String, Integer>> events) {
        this.login = login;
        this.events = events;
    }

    public ResponseBody() {
    }

    public String getLogin() {
        return login;
    }

    public List<Map<String, Integer>> getEvents() {
        return events;
    }
}
