package kr.go.mogef.idolbom_api.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Component
public class PrometheusLoggingInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (request.getRequestURI().contains("/actuator/prometheus")) {
            log.info("Prometheus scrape: {}", request.getRequestURI());
        }
        return true;
    }
}

