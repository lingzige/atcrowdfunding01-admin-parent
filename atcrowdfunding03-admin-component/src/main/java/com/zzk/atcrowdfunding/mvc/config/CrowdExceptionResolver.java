package com.zzk.atcrowdfunding.mvc.config;


import com.google.gson.Gson;
import com.zzk.atcrowdfunding.constant.CrowdConstant;
import com.zzk.atcrowdfunding.exception.LoginFailedException;
import com.zzk.atcrowdfunding.util.CrowdUtil;
import com.zzk.atcrowdfunding.util.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CrowdExceptionResolver {

    @ExceptionHandler(value = LoginFailedException.class)
    public ModelAndView resolverLoginFailedException(LoginFailedException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String viewName = "admin-login";
        return commonResolver(viewName, exception, request, response);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolverNullPointerException(NullPointerException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String viewName = "system-error";
        return commonResolver(viewName, exception, request, response);
    }

    private ModelAndView commonResolver(String viewName,Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1, 判断当前请求类型
        boolean judgeRequest = CrowdUtil.judgeRequestType(request);

        // 2. 如果是ajax请求
        if(judgeRequest){

            // 3. 创建ResultEntity对象
            ResultEntity<Object> failed = ResultEntity.failed(exception.getMessage());

            // 4。创建Gson对象
            Gson gson = new Gson();

            // 5. 转为json对象
            String json = gson.toJson(failed);

            // 6. 将json字符串作为响应体返回给浏览器
            response.getWriter().write(json);

            // 7.返回空
            return null;
        }

        // 8.普通请求
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION, exception);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

}
