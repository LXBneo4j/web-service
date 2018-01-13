package com.self.study.service;

import javax.xml.ws.Endpoint;

/**
 * @author: lxb.
 * @time: 2018/1/10.
 * @gmail: liuxiaobo170601@gmail.com
 * @extend： 目标：
 */
public class WebServicePublish {
    private static String address="http://192.168.1.136:8989/Self_Service";
    public static void main(String[] args) {
        Endpoint.publish(address,new WebServiceImpl());
        System.out.println("YES");
    }
}
