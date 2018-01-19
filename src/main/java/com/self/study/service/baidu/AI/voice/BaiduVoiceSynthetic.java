package com.self.study.service.baidu.AI.voice;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;

/**
 * @author: lxb.
 * @time: 2018/1/19.
 * @gmail: liuxiaobo170601@gmail.com
 * @extend： 目标：
 */
public class BaiduVoiceSynthetic {

    //设置APPID/AK/SK
    public static final String APP_ID = "10712970";
    public static final String API_KEY = "ErbaMM6XfGh7Zevy70op2MrG";
    public static final String SECRET_KEY = "Ih1h2VGtCaG6TQDfyDl79tHpb44OL8Xs";

    public static void main(String[] args) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        TtsResponse res = client.synthesis("你好百度,没有不可能，i'm woxiaobao", "zh", 1, null);
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, "E:\\BAT\\百度开放品台\\2-语音识别\\测试语言\\output.mp3");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (res1 != null) {
            System.out.println(res1.toString(2));
        }

    }


//    public void synthesis(AipSpeech client)
//    {
//        TtsResponse res = client.synthesis("你好百度", "zh", 1, null);
//        System.out.println(res.getErrorCode());
//
//        // 设置可选参数
//        HashMap<String, Object> options = new HashMap<String, Object>();
//        options.put("spd", "5");
//        options.put("pit", "5");
//        options.put("per", "4");
//        TtsResponse res = client.synthesis("你好百度", "zh", 1, options);
//        System.out.println(res.getErrorCode());
//        JSONObject result = res.getResult();    //服务器返回的内容，合成成功时为null,失败时包含error_no等信息
//        byte[] data = res.getData();            //生成的音频数据
//    }
}
