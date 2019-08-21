package com.yajun.demo.interceptors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eusdk.annotation.Anonymous;
import com.eusdk.constant.CachePrefix;
import com.eusdk.entity.UserToken;
import com.eusdk.enums.StateCodeEnum;
import com.eusdk.feigncall.utrade.AccountFeignApi;
import com.eusdk.utils.SdkResult;
import com.eusdk.utils.encrypt.SignUtil;
import com.eusdk.utils.logging.GwsLogger;
import com.yushi.core.util.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiexiang
 * @date 2019/8/14 1:51 PM
 */

public class IdentifyInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private AccountFeignApi accountFeignApi;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        GwsLogger.info("登录认证拦截器: request uri:{}; params:{}; sign:{};",
                request.getRequestURI(), JSON.toJSONString(SignUtil.requestParam(request)), request.getParameter("sign"));
        Anonymous anonymous = (handler instanceof HandlerMethod) ?
                ((HandlerMethod) handler).getMethodAnnotation(Anonymous.class) : null;
        if (null != anonymous && anonymous.value()) {
            return true;
        }

        String token = CookieUtils.getValue(request, "token");
        String userId = request.getParameter("userID");
        if (StringUtils.isBlank(token) || StringUtils.isBlank(userId)) {
            SdkResult sdkResult = new SdkResult(StateCodeEnum.TOKEN_VERIFY_FAIL.getState(), StateCodeEnum.TOKEN_VERIFY_FAIL.getMessage());
            response.getOutputStream().write(JSONObject.toJSONString(sdkResult).getBytes());
            return false;
        }
        UserToken sdkToken = (UserToken) redisTemplate.opsForValue().get(CachePrefix.USER_TOKEN + token);
        if (null == sdkToken) {
            sdkToken = accountFeignApi.getUserToken(token);
        }
        if (null == sdkToken) {
            GwsLogger.info("用户校验失败,token:{}", token);
            SdkResult sdkResult = new SdkResult(StateCodeEnum.TOKEN_VERIFY_FAIL.getState(), StateCodeEnum.TOKEN_VERIFY_FAIL.getMessage());
            response.getOutputStream().write(JSONObject.toJSONString(sdkResult).getBytes());
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
