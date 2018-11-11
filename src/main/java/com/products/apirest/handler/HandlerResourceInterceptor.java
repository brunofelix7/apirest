package com.products.apirest.handler;

import com.products.apirest.util.DateManager;
import com.products.apirest.util.FileManager;
import com.products.apirest.util.MyRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

@Component
public class HandlerResourceInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(HandlerResourceInterceptor.class);

    /* Este método é usado para executar operações antes de enviar a solicitação ao controller */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        this.logger.info("preHandle");
        String today = DateManager.dateNow();
        FileManager.write(String.format("%s : request to %s", today, request.getRequestURI()));
        return true;
    }

    /* Este método é usado para executar operações antes de enviar a resposta ao cliente */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        this.logger.info("postHandle");
    }

    /* Este método é usado para executar operações depois de concluir a solicitação e a resposta */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
        this.logger.info("afterCompletion");
        String today = DateManager.dateNow();
        FileManager.write(String.format("%s : response from %s", today, request.getRequestURI()));
        FileManager.write(String.format("%s : method %s", today, request.getMethod()));
        FileManager.write(String.format("%s : status code %s", today, response.getStatus()));
        FileManager.write("-----");
    }

}
