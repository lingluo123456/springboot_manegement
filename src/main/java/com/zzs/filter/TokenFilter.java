package com.zzs.filter;

import com.zzs.utils.CurrentHolder;
import com.zzs.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Slf4j
public class TokenFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1.获取请求路径
        String path = request.getRequestURI();

        //2.判断是不是登录操作，如果是登录操作，放行
        if (path.contains("/login")) {
            filterChain.doFilter(request, response);
            return;
        }
        //3.判断有没有token，如果没有，返回401
        String token = request.getHeader("token");
        if (token == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //4.如果有token，就解析token，如果解析失败，返回401
        try {
            Claims claims =JwtUtils.parseToken(token);
            Integer empId=Integer.parseInt(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
            log.info("令牌合法，设置当前员工id:{}",empId);

        } catch (Exception e) {
            log.info("令牌非法，状态码401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //6.如果解析成功，放行
        log.info("令牌合法，放行");
        filterChain.doFilter(request, response);

        CurrentHolder.remove();
    }

}
