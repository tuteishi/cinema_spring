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

import static by.cinema.cinema_web.utils.Constants.LOG_REQUEST_PATTERN;
import static by.cinema.cinema_web.utils.Constants.LOG_RESPONSE_PATTERN;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    @Pointcut("execution(* by.cinema.cinema_web.controllers..*(..))")
    public void pointCut() {
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

    private HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}