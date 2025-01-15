package com.zzs.intercepter;


import com.zzs.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 令牌校验拦截器
 */
//@Slf4j
//@Component
//public class TokenInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //3.判断有没有token，如果没有，返回401
//        String token = request.getHeader("token");
//        if (token == null) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
//        //4.如果有token，就解析token，如果解析失败，返回401
//        try {
//            JwtUtils.parseToken(token);
//        } catch (Exception e) {
//            log.info("令牌非法，状态码401");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
//        //5.如果解析成功，放行
//        log.info("令牌合法，放行");
//        return true;
//    }
//}
