package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

//import com.google.gson.Gson;
public class ApiHelper {

    public ApiHelper() {
    }

    public enum HttpMethodType {POST, GET, DELETE}

    private static final ObjectMapper JACKSON_OBJECT_MAPPER = new ObjectMapper();
    //private static final Gson GSON = new Gson();

    private String accessToken;

    public ApiHelper(String accessToken) {
        this.accessToken = accessToken;
    }

    public String request(final String apiPath) {
        return request(HttpMethodType.GET, apiPath, null);
    }

    public String request(final HttpMethodType httpMethod, final String apiPath) {
        return request(httpMethod, apiPath, null);
    }

    public String requestWithMapToParams(final HttpMethodType httpMethod, final String apiPath, final Map<String, String> param) {
        return request(httpMethod, apiPath, mapToParams(param));
    }

    public String request(HttpMethodType httpMethod, final String apiPath, final String params) {
        String requestUrl = apiPath;
        if (httpMethod == null) {
            httpMethod = HttpMethodType.GET;
        }
        if (params != null && params.length() > 0
                && (httpMethod == HttpMethodType.GET || httpMethod == HttpMethodType.DELETE)) {
            requestUrl += params;
        }

        try {
            final URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod(httpMethod.toString());

            if (this.accessToken != null && !this.accessToken.isEmpty()) {
                conn.setRequestProperty("Authorization", "Bearer " + this.accessToken);
            }

            conn.setRequestProperty("Content-Type", "x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");

            if (params != null && params.length() > 0 && httpMethod == HttpMethodType.POST) {
                byte[] postDataBytes = params.toString().getBytes("UTF-8");
                conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
                conn.setDoOutput(true);
                conn.getOutputStream().write(postDataBytes);
            }

            final int responseCode = conn.getResponseCode();
            System.out.println(String.format("\nSending '%s' request to URL : %s", httpMethod, requestUrl));
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));

            final StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
            System.out.println(buffer.toString());
            return buffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public String mapToParams(Map<String, String> map) {
        StringBuilder paramBuilder = new StringBuilder();
        for (String key : map.keySet()) {
            paramBuilder.append(paramBuilder.length() > 0 ? "&" : "");
            paramBuilder.append(String.format("%s=%s", urlEncodeUTF8(key), urlEncodeUTF8(map.get(key))));
        }
        return paramBuilder.toString();
    }

    public String mapToJsonStr(Map<String, String> map) throws IOException {
        return JACKSON_OBJECT_MAPPER.writeValueAsString(map);
    }
}
