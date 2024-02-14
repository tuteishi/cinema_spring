package by.cinema.cinema_web.aspects;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
@Slf4j
public class LoggerAspect {
    private static final String LOG_REQUEST_PATTERN = "HTTP Method - {} | Controller Method - {} | URL - {}";
    private static final String LOG_RESPONSE_PATTERN = "HTTP Method - {} | Controller Method - {} | URL - {} | Response - {}";

    @Pointcut("execution(* by.cinema.cinema_web.controllers..*(..))")
    public void pointCut() {
    }

    private static HttpServletRequest getHttpServletRequest() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request;
    }

    @Before("pointCut()")
    public void logRequest(JoinPoint joinPoint) {
        HttpServletRequest request = getHttpServletRequest();
        log.info(LOG_REQUEST_PATTERN,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI());
    }

    @AfterReturning(value = "pointCut()", returning = "response")
    public void logResponse(JoinPoint joinPoint, Object response) {
        HttpServletRequest request = getHttpServletRequest();
        log.info(LOG_RESPONSE_PATTERN,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI(),
                response);
    }
}