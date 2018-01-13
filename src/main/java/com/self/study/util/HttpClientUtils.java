package com.self.study.util;

import okhttp3.*;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Map;




public class HttpClientUtils {

    private MediaType mediaType = MediaType.parse("application/json;charset=utf-8");

   // protected Logger logger = LoggerFactory.getLogger(ChangQHttpClient.class);

    protected final OkHttpClient okHttpClient = new OkHttpClient();

    public String doPostJson(String url,String jsonStr) throws IOException {
        RequestBody requestBody = FormBody.create(mediaType, jsonStr);
        return post(url,requestBody);
    }

    public String doPost(String url, Map<String,String> paramsMap) throws IOException {
        FormBody.Builder formBody = new FormBody.Builder();
        for (Map.Entry<String,String> map : paramsMap.entrySet()) {
            formBody.addEncoded(map.getKey(),map.getValue());
        }
        return post(url,formBody.build());
    }

    protected String post(String url, RequestBody requestBody) throws IOException {
        Request request = new Request.Builder()
                .url(url).post(requestBody)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();

            String responseStr = response.body().string();

           // logger.debug("返回 Response：" + responseStr);

            return responseStr;
        } catch (ConnectException ex) {
            //logger.error("连接超时",ex);
            throw new IOException("连接超时");
        }

    }
    
}
