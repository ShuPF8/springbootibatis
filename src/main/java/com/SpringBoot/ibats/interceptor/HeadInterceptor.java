package com.SpringBoot.ibats.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
@Component("headInterceptor")
@Slf4j
public class HeadInterceptor implements HandlerInterceptor {

    private ThreadLocal<Long> requestTime = new ThreadLocal<Long>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        log.info("请求开始地址:"+request.getRequestURI());
        requestTime.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        long statTime = requestTime.get().longValue();
        long endTime = System.currentTimeMillis();
        log.info("请求地址结束，耗时："+ (endTime - statTime) + " MS");
    }
}
