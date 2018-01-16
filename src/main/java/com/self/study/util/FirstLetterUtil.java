package com.self.study.util;

import java.io.UnsupportedEncodingException;

/**
 * @author: lxb.
 * @time: 2018/1/16.
 * @gmail: liuxiaobo170601@gmail.com
 * @extend： 目标：
 */
public class FirstLetterUtil {
    private final static int[] li_SecPosValue = {1601, 1637, 1833, 2078, 2274,
            2302, 2433, 2594, 2787, 3106, 3212, 3472, 3635, 3722, 3730, 3858,
            4027, 4086, 4390, 4558, 4684, 4925, 5249, 5590};
    private final static String[] lc_FirstLetter = {"a", "b", "c", "d", "e",
            "f", "g", "h", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "w", "x", "y", "z"};


    public String getAllFirstLetter(String str) {
        if (str == null || str.trim().length() == 0) {
            return "";
        }

        String _str = "";
        for (int i = 0; i < str.length(); i++) {
            _str = _str + this.getFirstLetter(str.substring(i, i + 1));
//            System.out.println(_str);
        }
        return _str;
    }


    public String getFirstLetter(String chinese) {
        if (chinese == null ) {
            return "";
        }
        if(",".equals(chinese) || "，".equals(chinese) || ";".equals(chinese) || "；".equals(chinese) || "。".equals(chinese)|| ".".equals(chinese)){
//            return " "+chinese+" ";
            return " " ;
        }
        chinese = this.conversionStr(chinese, "GB2312", "ISO8859-1");
//        chinese = this.conversionStr(chinese, "GB2312", "UTF-8");
//
        if (chinese.length() > 1) // 判断是不是汉字
        {
            int li_SectorCode = (int) chinese.charAt(0); // 汉字区码
            int li_PositionCode = (int) chinese.charAt(1); // 汉字位码

            li_SectorCode = li_SectorCode - 160;
            li_PositionCode = li_PositionCode - 160;

            int li_SecPosCode = li_SectorCode * 100 + li_PositionCode; // 汉字区位码
            if (li_SecPosCode > 1600 && li_SecPosCode < 5590) {
                for (int i = 0; i < 23; i++) {
                    if (li_SecPosCode >= li_SecPosValue[i]
                            && li_SecPosCode < li_SecPosValue[i + 1]) {
                        chinese = " "+lc_FirstLetter[i]+" ";
                        break;
                    }
                }
            } else // 非汉字字符,如图形符号或ASCII码
            {
                chinese = this.conversionStr(chinese, "ISO8859-1", "GB2312");
                chinese = chinese.substring(0, 1);
            }
        }

        return chinese;
    }


    private String conversionStr(String str, String charsetName, String toCharsetName) {
        try {
            str = new String(str.getBytes(charsetName), toCharsetName);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("字符串编码转换异常：" + ex.getMessage());
        }
        return str;
    }
    public static String getFirst(String old){
        String returnStr="";
        if(old==null || old.trim().length()==0){
            return returnStr;
        }
        String[] split=old.split(" ");

        for(String s:split){
            if(s!=null && !"".equals(s) &&  !" ".equals(s) && s.length()>0){
                returnStr=returnStr+s.substring(0,1);
            }
//            System.out.println(s+"|");
        }
        return returnStr;
    }


    public static void main(String[] args) {
//        for(Double i=0.0;i<1000;i++){
//            System.out.println((Math.PI/4)*Math.atan(i/10));
//        }

//        MainTest cte = new MainTest();
//        System.out.println("获取拼音首字母：" + cte.getAllFirstLetter("我ss才 a"));
//        System.out.println("获取拼音首字母：" + cte.getFirstLetter("我"));

        ///字符串：
        String str="我们都是sha bi 呵HE呵，As is true.";
        FirstLetterUtil cte = new FirstLetterUtil();
        System.out.println(getFirst(cte.getAllFirstLetter(str)));
//        System.out.println(cte.getAllFirstLetter(str));


    }






}
