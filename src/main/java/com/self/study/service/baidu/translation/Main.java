package com.self.study.service.baidu.translation;


public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "";
    private static final String SECURITY_KEY = "";

    public static void main(String[] args) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "最近流水记录若当月翻译字符数≤2百万，当月免费；若超过2百万字符，按照49元/百万字符支付当月全部翻译字符数费用";
        System.out.println(api.getTransResult(query, "auto", "en"));
    }

}
