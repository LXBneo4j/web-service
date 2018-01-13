package com.self.study.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author: lxb.
 * @time: 2018/1/10.
 * @gmail: liuxiaobo170601@gmail.com
 * @extend： 目标：
 */
@WebService
public interface Service {
    @WebMethod
    public String say(String name);
}
