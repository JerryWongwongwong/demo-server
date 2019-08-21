package com.yajun.demo.interceptors;


import com.yajun.demo.dto.RequestParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author lvjunlong
 * @date 2019/8/14 上午9:53
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String appId = request.getParameter("appID");
        String appIdHeader = request.getHeader("EU-AppID");
        if (StringUtils.isBlank(appId) && StringUtils.isNotBlank(appIdHeader)) {
            appId = appIdHeader;
        }

        String channelId = request.getParameter("channelID");
        String channelIdHeader = request.getHeader("EU-ChannelID");
        if (StringUtils.isBlank(channelId) && StringUtils.isNotBlank(channelIdHeader)) {
            channelId = channelIdHeader;
        }

        String deviceId = request.getParameter("deviceID");
        String deviceIdHeader = request.getHeader("EU-DeviceID");
        if (StringUtils.isBlank(deviceId) && StringUtils.isNotBlank(deviceIdHeader)) {
            deviceId = deviceIdHeader;
        }

        String osVersion = request.getParameter("osVersion");
        String osVersionHeader = request.getHeader("EU-OsVersion");
        if (StringUtils.isBlank(osVersion) && StringUtils.isNotBlank(osVersionHeader)) {
            osVersion = osVersionHeader;
        }


        RequestParams.CommonParams params = new RequestParams.CommonParams();
        params.setAppId(StringUtils.isBlank(appId) ? null : Integer.parseInt(appId));
        params.setChannelId(StringUtils.isBlank(channelId) ? null : Integer.parseInt(channelId));
        params.setDeviceId(deviceId);
        params.setOsVersion(StringUtils.isBlank(osVersion) ? null : osVersion);
        RequestParams.put(params);

        return true;
    }
}
