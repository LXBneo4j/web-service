package com.self.study.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

import com.self.study.enums.AliyunRequestTypeEnum;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import javax.print.attribute.standard.Copies;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author: lxb.
 * @time: 2018/1/12.
 * @gmail: liuxiaobo170601@gmail.com
 * @extend： 目标： 通过手机号找到省市
 */
public class AddressUtil {
    private static PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

    private static String splitStr="省";
    private static String resultStr="未知";
    private static String provincial="provincial";
    private static String municipal="municipal";
    private static String region="region";
    private static String language="CN";
    private static String url = "http://gc.ditu.aliyun.com/regeocoding?l=#lat#,#log#&type=#code#";

    public static Map<String,String> getProvincesByPhone(String phone){
        PhoneNumberOfflineGeocoder phoneNumberOfflineGeocoder = PhoneNumberOfflineGeocoder.getInstance();
        Map<String,String> map=null;
        Phonenumber.PhoneNumber referencePhonenumber = null;
        try {
            referencePhonenumber = phoneUtil.parse(phone, language);
            //手机号码归属城市 referenceRegion
            String referenceRegion = phoneNumberOfflineGeocoder.getDescriptionForNumber(referencePhonenumber, Locale.CHINA);
            if(StringUtils.isNotBlank(referenceRegion)){
                String[] arr=referenceRegion.split(splitStr);
                if(arr!=null){
                    map=new HashMap<String, String>();
                    if(arr[0]!=null){
                        map.put(provincial,arr[0]+splitStr);
                    }else{
                        map.put(provincial,resultStr);
                    }
                    map.put(municipal,arr[1]);
                }
            }
        } catch (NumberParseException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 字符串替换
     * @param old
     * @return
     */
    private static String change(String old,Map<String,String> map){
        if(map!=null && !map.isEmpty()){
            for(String code:map.keySet()){
                old=old.replace ("#"+code+"#",map.get (code));
            }
        }
        return old;
    }
    /**
     *  lat 31.2990170   纬度
     *  log 121.3466440    经度
     *   lat 小  log  大
     *   参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)
     *
     * @return
     */
    public static AliyunAddress getAddByLatitudeAndLongitude(Map<String,String> map){
        AliyunAddress j_2=null;
        String urlString = change(url,map);
        String res = "";
        try {
            URL url = new URL(urlString);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line+"\n";
            }
            in.close();

            System.out.println(res);
            JSONObject jsonObject = JSONObject.parseObject (res);
            JSONArray jsonArray = JSONArray.parseArray (jsonObject.getString("addrList"));
            j_2 = JSONObject.parseObject (jsonArray.get(0).toString (),AliyunAddress.class);

            Map<String,String> resultMap = new HashMap<String, String>();
            String allAdd = j_2.getAdmName();
            String [] arr= allAdd.split(",");
            resultMap.put(provincial,arr[0]);
            resultMap.put(municipal,arr[1]);
            resultMap.put(region,arr[2]);
            j_2.setAdmMap(resultMap);

            Map<String,String> addrMap = new HashMap<String, String>();
            String logLat = j_2.getNearestPoint();
            String [] arr1= logLat.split(",");
            addrMap.put("log",arr1[0]);
            addrMap.put("lat",arr1[1]);

            j_2.setLogLatMap(addrMap);
            System.out.println("省:"+arr[0]+"\n市:"+arr[1]+"\n区:"+arr[2]);
        } catch (Exception e) {
            System.out.println("error in wapaction,and e is " + e.getMessage());
        }
        return j_2;
    }






    public static void main(String[] args) {
//        System.out.println(getProvincesByPhone("18380805107"));
        Map<String,String> map=new HashMap<String, String>();
        map.put("log","116.5050");
        map.put("lat","35.5462");
        map.put("code", AliyunRequestTypeEnum.POI.code());
        System.out.println(getAddByLatitudeAndLongitude(map));
    }





}
