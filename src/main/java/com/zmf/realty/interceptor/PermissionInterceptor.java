package com.zmf.realty.interceptor;

import com.alibaba.fastjson.JSON;
import com.zmf.realty.service.jwt.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * the interceptor to intercepte the request when the user has no permission
 */
@Component
public class PermissionInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtService jwtService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
//        ManagerRequired managerRequired = ((HandlerMethod) handler).getMethodAnnotation(ManagerRequired.class);
//        logger.info("annotation: " + managerRequired);
        logger.info("uri: " + request.getRequestURI() + "  token: " + request.getHeader("x-auth-token"));

        if (method.equals(HttpMethod.GET.toString()) || method.equals(HttpMethod.OPTIONS.toString())) {
            return true;
        } else if (method.equals(HttpMethod.POST.toString()) && request.getRequestURI().equals("/api/login")) {
            return true;
        } else if (method.equals(HttpMethod.POST.toString()) && request.getRequestURI().equals("/api/messages")) {
            return true;
        } else if (method.equals(HttpMethod.POST.toString()) && request.getRequestURI().equals("/api/messages-search")) {
            return true;
        } else {
            if (jwtService.isValid(request.getHeader("x-auth-token"))) {
                return true;
            } else {
//                response.sendRedirect("/api/errors/invalid");
                response.setStatus(401);
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, PUT, DELETE, OPTIONS");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Headers", "x-auth-token, content-type, x_request_with");
                PrintWriter writer = response.getWriter();
                Map<String, String> resp = new HashMap<>();
                resp.put("error", "token invalid");
                writer.write(JSON.toJSONString(resp));
                writer.flush();
                writer.close();
                return false;
            }
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
