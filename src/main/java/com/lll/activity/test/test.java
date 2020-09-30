package com.lll.activity.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: activity
 * @description: 测试
 * @author: lilulu
 * @create: 2020-09-18 16:44
 */
@RestController("/test/")
public class test {
    private final static String URL= "https://api.ai.qq.com/fcgi-bin/vision/vision_porn";
    private final static String App_ID= "2156822311";
    private final static String App_Key= "5d6d8inRLTLCYJtA";
    private final static String image_url= "C:\\Users\\123321\\Desktop\\BZ\\LoL\\25.jpg";

  @GetMapping("test")
    public  JSONObject test(){
        HashMap<String, Object> params = new HashMap<>();
        JSONObject data = new JSONObject();
        Date dateTime = new Date();

        int secondTimestamp = getSecondTimestamp(dateTime);

      String filename= RandomStringUtils.randomAlphanumeric(10);
        Map<String,String> key=new HashMap<>();
        try {
            int secondTimestamp2 = getSecondTimestamp(dateTime);

            key.put("app_key",App_Key);
            key.put("app_id",App_ID);//应用标识（AppId）
            key.put("time_stamp", String.valueOf(secondTimestamp2));//请求时间戳（秒级）
            key.put("nonce_str",filename);//随机字符串
            key.put("image_url",image_url);//随机字符串
            params.put("app_id",App_ID);//应用标识（AppId）
            params.put("time_stamp",secondTimestamp);//请求时间戳（秒级）
            params.put("nonce_str",filename);//随机字符串
            params.put("image_url",image_url);//随机字符串
            String sign = TencentAISignSort.getSignature(key);
            params.put("sign",sign);//随机字符串

            String post = HttpClientUtil.post(URL, params);
            JSONObject parseObject = JSON.parseObject(post);
            data =parseObject;
            return parseObject;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
    public static int getSecondTimestamp(Date date){
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if (length > 3) {
            return Integer.valueOf(timestamp.substring(0,length-3));
        } else {
            return 0;
        }
    }

//    public JSONArray dhSel(String type, String dh) throws Exception {
//        String url = ConstantConf.KDN_URL;
//        String apiKey = ConstantConf.KDN_API_KEY;
//        String EBusinessID = ConstantConf.KDN_EBUSINESSID;
//        HashMap<String, Object> params = new HashMap<>();
//        JSONObject data = new JSONObject();
//        data.put("ShipperCode", type);
//        data.put("LogisticCode", dh);
//        String jsonString = JSON.toJSONString(data);
//        String encode = URLEncoder.encode(jsonString, "utf-8");
//        params.put("RequestData", encode);
//        params.put("EBusinessID", EBusinessID);
//        params.put("RequestType", ConstantConf.KDN_REUEST_TYPE);
//        BASE64Encoder base64Encoder = new BASE64Encoder();
//        String md532 = Md5Util.getMd532(jsonString + apiKey);
//        String encode2 = base64Encoder.encode(md532.getBytes());
//        String encode3 = URLEncoder.encode(encode2, "utf-8");
//        params.put("DataSign", encode3);
//        String post = HttpClientUtil.post(url, params);
//        JSONObject parseObject = JSON.parseObject(post);
//        JSONArray jsonArray = parseObject.getJSONArray("Traces");
//        return jsonArray;
//    }



}
