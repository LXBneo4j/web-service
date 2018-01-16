package com.self.study.service.baidu.translation;

import java.io.Serializable;

/**
 * @author: lxb.
 * @time: 2018/1/16.
 * @gmail: liuxiaobo170601@gmail.com
 * @extend： 目标：
 */
public class BaiduTransDO  implements Serializable{
    private String src;
    private String dst;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }
}
