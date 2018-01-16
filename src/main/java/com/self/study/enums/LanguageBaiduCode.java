package com.self.study.enums;

/**
 * @author: lxb.
 * @time: 2018/1/16.
 * @gmail: liuxiaobo170601@gmail.com
 * @extend： 目标：
 */
public enum LanguageBaiduCode {
    auto("auto","自动检测"),
    zh("zh","中文"),
    en("en","英语"),
    yue("yue","粤语"),
    wyw("wyw","文言文"),
    jp("jp","日语"),
    kor("kor","韩语"),
    fra("fra","法语"),
    spa("spa","西班牙语"),
    th("th","泰语"),
    ara("ara","阿拉伯语"),
    ru("ru","俄语"),
    pt("pt","葡萄牙语"),
    de("de","德语"),
    it("it","意大利语"),
    el("el","希腊语"),
    nl("nl","荷兰语"),
    pl("pl","波兰语"),
    bul("bul","保加利亚语"),
    est("est","爱沙尼亚语"),
    dan("dan","丹麦语"),
    fin("fin","芬兰语"),
    cs("cs","捷克语"),
    rom( "rom","罗马尼亚语"),
    slo("slo","斯洛文尼亚语"),
    swe("swe","瑞典语"),
    hu("hu","匈牙利语"),
    cht("cht","繁体中文"),
    vie("vie","越南语")
            ;

    LanguageBaiduCode(String code,String message){

    }


    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
