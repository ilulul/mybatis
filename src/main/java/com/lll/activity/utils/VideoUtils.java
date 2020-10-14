package com.lll.activity.utils;

/**
 * @program: activity
 * @description: 视频转码
 * @author: lilulu
 * @create: 2020-09-17 17:03
 */

import cn.hutool.core.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ws.schild.jave.*;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class VideoUtils {
    private Logger logger = LoggerFactory.getLogger(getClass());


    private static Map<String, Integer> sizeBitRateMap;

    static {
        sizeBitRateMap = new HashMap<>();
        sizeBitRateMap.put("1920*1080", 4992);
        sizeBitRateMap.put("1280*720", 2496);
        sizeBitRateMap.put("1024*576", 1856);
        sizeBitRateMap.put("840*480", 1216);
        sizeBitRateMap.put("768*432", 1088);
        sizeBitRateMap.put("640*360", 896);
        sizeBitRateMap.put("424*240", 576);
    }


    public static void main(String[] args) {
        VideoUtils videoUtils = new VideoUtils();
//        videoUtils.convertVideoToMP4(new File("D:\\app\\Vitas - Звезда.avi"),"D:\\app\\lll.mp4");

//        videoUtils.getVideoInfoAndGenerateThumbnail(new File("D:\\app\\test.mp4"), "D:\\app\\转过码的.jpg");


    }

    /**
     * 截取视频的一针作为封面图
     *
     * @param file          视频文件
     * @param thumbnailPath 截取图片保存路径
     * @return
     */
    //Output file is empty, nothing was encoded (check -ss / -t / -frames parameters if used)
    public void getVideoInfoAndGenerateThumbnail(File file, String thumbnailPath) {
        MultimediaObject multimediaObject = new MultimediaObject(file);
        try {
            MultimediaInfo info = multimediaObject.getInfo();
            VideoInfo videoInfo = info.getVideo();
            logger.info("获取视频时长：{}", info.getDuration() / 1000);
            if (ObjectUtil.isNotNull(videoInfo)) {
                VideoSize size = videoInfo.getSize();
                int width = size.getWidth();
                int height = size.getHeight();
                logger.info("视频宽：{} 视频高{}", width, height);
                logger.info("比特率：{}", videoInfo.getBitRate() / 1000);
                ScreenExtractor screenExtractor = new ScreenExtractor();
                File target = new File(thumbnailPath);
                //截取视频作为图片保存
                /*
                 *第一个参数 视频源文件信息类
                 * 第二个参数 截取的宽度
                 * 第三个参数  截取的高度
                 * 第四个参数  截取的是那一帧
                 * 第五个参数是  截取的图片质量 1-31   数字越小质量越高
                 *
                 **/
                screenExtractor.render(multimediaObject, size.getWidth(), size.getHeight(), 3000, target, 20);

            }
        } catch (EncoderException e) {
            e.printStackTrace();
        }

    }


    /**
     * @param source     源文件
     * @param targetPath 转码后的路径
     */
    public void convertVideoToMP4(File source, String targetPath) {
        MultimediaObject multimediaObject = new MultimediaObject(source);
        try {
            MultimediaInfo info = multimediaObject.getInfo();
            VideoInfo videoInfo = info.getVideo();
            VideoSize size = videoInfo.getSize();
            System.out.println("原视频宽：" + size.getWidth());
            System.out.println("原视频高：" + size.getHeight());
            System.out.println("原视频比特率：" + videoInfo.getBitRate() / 1000);
            System.out.println("原视频编码：" + videoInfo.getDecoder());

            Integer bitRate = sizeBitRateMap.get(size.getWidth() + "*" + size.getHeight());
            VideoAttributes video = new VideoAttributes();
            //设置视频编码
            video.setCodec("h264");

            if (ObjectUtil.isNotNull(bitRate)) {
                //设置比特率
                video.setBitRate(bitRate * 1000);
            }
            File target = new File(targetPath);
            AudioAttributes audio = new AudioAttributes();
            //设置编码器名称
            audio.setCodec("aac");
            EncodingAttributes attrs = new EncodingAttributes();
            //设置转换后的格式
            attrs.setFormat("mp4");
            attrs.setAudioAttributes(audio);
            attrs.setVideoAttributes(video);
            Encoder encoder = new Encoder();
            encoder.encode(multimediaObject, target, attrs);
            //花费毫秒数

            MultimediaObject multimediaObjectOfter = new MultimediaObject(Paths.get(targetPath).toFile());
            MultimediaInfo info1 = multimediaObjectOfter.getInfo();
            VideoInfo video1 = info1.getVideo();
            VideoSize size1 = video1.getSize();

            System.out.println("转换后视频宽：" + size1.getWidth());
            System.out.println("转换后视频高：" + size1.getHeight());
            System.out.println("转换后视频比特率：" + video1.getBitRate() / 1000);
            System.out.println("转换后视频编码：" + video1.getDecoder());

        } catch (EncoderException e) {
            e.printStackTrace();
        }
    }

//package com.founder.util.video;
//
//import java.util.ArrayList;
//import java.util.List;
//
//    public class TransferUtil {
//
//        public static void main(String[] args) throws FFmpegException {
//            boolean flag = transform("D:\\ffmpeg\\ffmpeg2016\\bin\\ffmpeg.exe", "d:\\ys\\StoryBrooke.mp4", "d:\\ys\\480p.flv", "480x320");
//            System.out.println(flag);
//        }
//
//        /**
//         * 视频转换
//         * @param ffmpegPath ffmpeg路径
//         * @param oldPath 原视频地址
//         * @param newPath 新视频存放地址(包含视频格式)
//         * @param resolution 分辨率
//         * @return
//         * @throws FFmpegException
//         */
//        public static Boolean transform(String ffmpegPath, String oldPath, String newPath, String resolution) throws FFmpegException {
//            List<String> command = getFfmpegCommand(ffmpegPath, oldPath, newPath, resolution);
//            if (null != command && command.size() > 0) {
//                return process(command);
//            }
//            return false;
//        }
//
//        private static boolean process(List<String> command) throws FFmpegException {
//            try {
//                if (null == command || command.size() == 0)
//                    return false;
//                Process videoProcess = new ProcessBuilder(command).redirectErrorStream(true).start();
//                videoProcess.getInputStream().close();
//                int exitcode = videoProcess.waitFor();
//                if (exitcode == 1)
//                    return false;
//                return true;
//            } catch (Exception e) {
//                throw new FFmpegException("file transfer failed", e);
//            }
//        }
//
//        private static List<String> getFfmpegCommand(String ffmpegPath, String oldfilepath, String outputPath, String resolution) throws FFmpegException {
//            List<String> command = new ArrayList<String>();
//            command.add(ffmpegPath); // 添加转换工具路径
//            command.add("-i"); // 添加参数＂-i＂，该参数指定要转换的文件
//            command.add(oldfilepath); // 添加要转换格式的视频文件的路径
//            command.add("-qscale"); // 指定转换的质量
//            command.add("4");
//
//        /*command.add("-ab"); //设置音频码率
//        command.add("64");
//        command.add("-ac"); //设置声道数
//        command.add("2");
//        command.add("-ar"); //设置声音的采样频率
//        command.add("22050");*/
//
//            command.add("-r"); // 设置帧速率
//            command.add("24");
//            command.add("-s"); // 设置分辨率
//            command.add(resolution);
//            command.add("-y"); // 添加参数＂-y＂，该参数指定将覆盖已存在的文件
//            command.add(outputPath);
//            return command;
//        }
//    }
//
//    class FFmpegException extends Exception {
//
//        private static final long serialVersionUID = 1L;
//
//        public FFmpegException() {
//            super();
//        }
//
//        public FFmpegException(String message) {
//            super(message);
//        }
//
//        public FFmpegException(Throwable cause) {
//            super(cause);
//        }
//
//        public FFmpegException(String message, Throwable cause) {
//            super(message, cause);
//        }
//    }

}
