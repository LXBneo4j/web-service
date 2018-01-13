package com.self.study.enums;

/**
 * @author: lxb.
 * @time: 2018/1/12.
 * @gmail: liuxiaobo170601@gmail.com
 * @extend： 目标：
 */
public enum Language {
    CN("CN","中国")
    ;
    private String code;
    private String message;


    Language(String code,String message){
        this.code=code;
        this.message=message;
    }
}
