package com.lll.activity.sys.controller;

import com.lll.activity.utils.Base64Util;
import com.lll.activity.utils.HttpUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: activity
 * @description: 测试 腾讯ai开放平台:图片鉴黄接口
 * @author: lilulu
 * @create: 2020-09-18 16:44
 */
@RestController
@RequestMapping("/test/")
public class TencentAiPictureIdentifyTheYellowController {

    private static final String APP_ID = "2156822311";
    private final static String URL = "https://api.ai.qq.com/fcgi-bin/vision/vision_porn";
//    private final static String App_Key= "5d6d8inRLTLCYJtA";
//    private final static String image_url= "C:\\Users\\123321\\Desktop\\BZ\\LoL\\20.jpg";

    /**
     * @param imgURL
     * @return
     * nonce_str   :非空且长度上限32字节
     * image      :原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式），image和image_url必须至少提供一个
     */
    @GetMapping("test")
    public String test(String imgURL) {
        final Map<String, String> params = new HashMap<String, String>();
        //appId
        params.put("app_id", String.valueOf(APP_ID));
        //请求时间戳（秒级）
        params.put("time_stamp", String.valueOf(System.currentTimeMillis() / 1000));
        //随机字符串
        params.put("nonce_str", HttpUtils.getRandomString(15));
        //待识别图片url
        params.put("image", imgString(imgURL));
        String result = HttpUtils.doPost(URL, params);
        return result;
    }


    public static String imgString(String filePath) {
        byte[] data;
        try {
            data = Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return Base64Util.encode(data);
    }


}
