package fr.chinjto.games.back.server.aspects;

import fr.chinjto.games.back.server.resources.Action;
import fr.chinjto.games.back.server.resources.Server;
import fr.chinjto.games.back.server.resources.annotations.ServerResource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Slf4j
@Aspect
@Component
public class ResourcesLoggingAspect {

    @Around("@annotation(fr.chinjto.games.back.server.resources.annotations.ServerResource)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        final Method method = signature.getMethod();
        final ServerResource serverResource = method.getAnnotation(ServerResource.class);
        final Server server = serverResource.server();
        final Action action = serverResource.action();
        log.info(">> {} :: {} >>", action, server);
        final Object result;
        try {
            result = joinPoint.proceed();
            log.info("   {} :: {} <<", action, server);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            log.info("   {} :: {} XX", action, server);
            throw e;
        }
        return result;
    }

}
