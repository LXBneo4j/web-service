package com.self.study.util;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: lxb.
 * @time: 2018/1/13.
 * @gmail: liuxiaobo170601@gmail.com
 * @extend： 目标：
 */
public class AliyunAddressDO implements Serializable {
    private String type;
    private String status;
    private String name;
    private String id;
    private String admCode;
    private String admName;
    private String addr;
    private String nearestPoint;
    private String distance;

    private Map<String,String> admMap;
    private Map<String,String> logLatMap;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdmCode() {
        return admCode;
    }

    public void setAdmCode(String admCode) {
        this.admCode = admCode;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getNearestPoint() {
        return nearestPoint;
    }

    public void setNearestPoint(String nearestPoint) {
        this.nearestPoint = nearestPoint;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Map<String, String> getAdmMap() {
        return admMap;
    }

    public void setAdmMap(Map<String, String> admMap) {
        this.admMap = admMap;
    }

    public Map<String, String> getLogLatMap() {
        return logLatMap;
    }

    public void setLogLatMap(Map<String, String> logLatMap) {
        this.logLatMap = logLatMap;
    }

    @Override
    public String toString() {
        return "{" +
                "type:'" + type + '\'' +
                ", status:'" + status + '\'' +
                ", name:'" + name + '\'' +
                ", id:'" + id + '\'' +
                ", admCode:'" + admCode + '\'' +
                ", admName:'" + admName + '\'' +
                ", addr:'" + addr + '\'' +
                ", nearestPoint:'" + nearestPoint + '\'' +
                ", distanc:'" + distance + '\'' +
                ", admMap:" + admMap +
                ", logLatMap:" + logLatMap +
                '}';
    }
}
