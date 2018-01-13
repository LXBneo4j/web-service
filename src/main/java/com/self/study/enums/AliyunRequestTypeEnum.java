package com.self.study.enums;

/**
 * @author: lxb.
 * @time: 2018/1/13.
 * @gmail: liuxiaobo170601@gmail.com
 * @extend： 目标：
 */
public enum AliyunRequestTypeEnum {
    ROAD("100","道路"),
    POI("010","POI"),
    DOOR_ADDRESS("001","道路"),
    ALL("111","")
    ;
    private String code;
    private String message;


    AliyunRequestTypeEnum(String code,String message){
        this.code=code;
        this.message=message;
    }

    public String code(){
        return code;
    }

    public String message(){
        return message;
    }
}
