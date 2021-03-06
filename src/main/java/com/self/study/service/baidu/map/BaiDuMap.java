package com.self.study.service.baidu.map;

/**
 * @author: lxb.
 * @time: 2018/1/17.
 * @gmail: liuxiaobo170601@gmail.com
 * @extend： 目标：
 */
public class BaiDuMap {
    static double DEF_PI = 3.14159265359; // PI
    static double DEF_2PI= 6.28318530712; // 2*PI
    static double DEF_PI180= 0.01745329252; // PI/180.0
    static double DEF_R =6370693.5; // radius of earth
    //适用于近距离
    public static double GetShortDistance(double lon1, double lat1, double lon2, double lat2)
    {
        double ew1, ns1, ew2, ns2;
        double dx, dy, dew;
        double distance;
        // 角度转换为弧度
        ew1 = lon1 * DEF_PI180;
        ns1 = lat1 * DEF_PI180;
        ew2 = lon2 * DEF_PI180;
        ns2 = lat2 * DEF_PI180;
        // 经度差
        dew = ew1 - ew2;
        // 若跨东经和西经180 度，进行调整
        if (dew > DEF_PI)
            dew = DEF_2PI - dew;
        else if (dew < -DEF_PI)
            dew = DEF_2PI + dew;
        dx = DEF_R * Math.cos(ns1) * dew; // 东西方向长度(在纬度圈上的投影长度)
        dy = DEF_R * (ns1 - ns2); // 南北方向长度(在经度圈上的投影长度)
        // 勾股定理求斜边长
        distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }
    //适用于远距离
    public static double GetLongDistance(double lon1, double lat1, double lon2, double lat2)
    {
        double ew1, ns1, ew2, ns2;
        double distance;
        // 角度转换为弧度
        ew1 = lon1 * DEF_PI180;
        ns1 = lat1 * DEF_PI180;
        ew2 = lon2 * DEF_PI180;
        ns2 = lat2 * DEF_PI180;
        // 求大圆劣弧与球心所夹的角(弧度)
        distance = Math.sin(ns1) * Math.sin(ns2) + Math.cos(ns1) * Math.cos(ns2) * Math.cos(ew1 - ew2);
        // 调整到[-1..1]范围内，避免溢出
        if (distance > 1.0)
            distance = 1.0;
        else if (distance < -1.0)
            distance = -1.0;
        // 求大圆劣弧长度
        distance = DEF_R * Math.acos(distance);
        return distance;
    }
    //转至 http://blog.csdn.net/chentravelling/article/details/51058742
//    /**
//     * 计算两点之间距离
//     * @param start
//     * @param end
//     * @return 米
//     */
//    public String getDistance(LatLng start,LatLng end){
//        double lat1 = (Math.PI/180)*start.latitude;
//        double lat2 = (Math.PI/180)*end.latitude;
//
//        double lon1 = (Math.PI/180)*start.longitude;
//        double lon2 = (Math.PI/180)*end.longitude;
//
//        //地球半径
//        double R = 6371;
//
//        //两点间距离 km，如果想要米的话，结果*1000
//        double d =  Math.acos(Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon2-lon1))*R;
//        if(d<1)
//            return (int)d*1000+"m";
//        else
//            return String.format("%.2f",d)+"km";
//    }

    public static void main(String[] args) {
//        double mLat1 = 39.90923; // point1纬度
//        double mLon1 = 116.357428; // point1经度
//        double mLat2 = 39.90923;// point2纬度
//        double mLon2 = 116.397428;// point2经度

        double mLat1 = 29.5532; // point1纬度
        double mLon1 = 106.5064; // point1经度
        double mLat2 = 29.5527;// point2纬度
        double mLon2 = 106.5059;// point2经度
        double distance = BaiDuMap.GetShortDistance(mLon1, mLat1, mLon2, mLat2);
        System.out.println(distance);
    }
}
