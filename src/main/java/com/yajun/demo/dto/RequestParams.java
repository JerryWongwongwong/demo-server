package com.yajun.demo.dto;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

/**
 * <P>
 *     公共参数DTO
 * </P>
 * @author lvjunlong
 * @date 2019/8/14 上午9:33
 */
public class RequestParams {

    private static final ThreadLocal<CommonParams> commonParams = new ThreadLocal<>();

    public static void put(CommonParams params) {
        commonParams.set(params);
    }

    public static Integer getAppId() {
        RequestParams.CommonParams params = commonParams.get();
        return null != params ? params.getAppId() : null;
    }

    public static Integer getChannelId() {
        RequestParams.CommonParams params = commonParams.get();
        return null != params ? params.getChannelId() : null;
    }

    public static String getDeviceId() {
        RequestParams.CommonParams params = commonParams.get();
        return null != params ? params.getDeviceId() : null;
    }

    public static Map<String, String> getParamMap() {
        RequestParams.CommonParams params = commonParams.get();
        return null != params ? params.getParamMap() : null;
    }

    public static String getIp() {
        RequestParams.CommonParams params = commonParams.get();
        return null != params ? params.getIp() : null;
    }

    public static String getOsVersion() {
        RequestParams.CommonParams params = commonParams.get();
        return null != params ? params.getOsVersion() : null;
    }


    @Data
    public static class CommonParams {

        /**
         * 游戏Id
         */
        private Integer appId;

        /**
         * 渠道Id
         */
        private Integer channelId;

        /**
         * 设备Id
         */
        private String deviceId;

        /**
         * 融合这边参数加密后的签名，
         * 用于与客户端传过来的签名做对比
         */
        private Map<String, String> paramMap = Maps.newHashMap();

        /**
         * ip
         */
        private String ip;

        /**
         * 系统版本
         */
        private String osVersion;




    }
}
