package com.self.study.service;

import com.self.study.util.Encoding;

import javax.jws.WebService;

/**
 * @author: lxb.
 * @time: 2018/1/10.
 * @gmail: liuxiaobo170601@gmail.com
 * @extend： 目标：
 */
@WebService
public class WebServiceImpl implements Service {
    public String say(String name) {
        name=Encoding.charSetConvert(name);
        System.out.println(name==null?"":name+":Successful visit WebService");
        if(name==null){
            return "hello service";
        }else{
            return "hello"+name;
        }
    }
}
