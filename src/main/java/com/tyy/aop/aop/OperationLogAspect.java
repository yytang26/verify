package com.tyy.aop.aop;

import com.tyy.aop.req.UserOperationReq;
import com.tyy.aop.service.UserOperationService;
import com.tyy.aop.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author:tyy
 * @date:2021/5/16
 */

@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private UserOperationService userOperationService;

    @Pointcut("@annotation(com.tyy.aop.aop.OperationLog)")
    private void pointCutMethod(){

    }

    @Around("pointCutMethod()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method targetMethod = methodSignature.getMethod();
        String params = "";
        if(targetMethod.isAnnotationPresent(OperationLog.class)){
            //全路径名字.方法名字
            String methodName= joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
            String remoteIp = LogUtil.getIpAddr(request);
            String method = request.getMethod();
            if("POST".equals(method)) {
                //输入的参数
                Object[] paramsArray = joinPoint.getArgs();
                params = LogUtil.argsArrayToString(paramsArray);
            } else{
                Map<?,?> paramsMap = (Map<?,?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
                params = paramsMap.toString();
            }
            OperationLog operationLog = targetMethod.getAnnotation(OperationLog.class);
            UserOperationReq userOperationReq = UserOperationReq.builder().action(operationLog.action()).remark(operationLog.remark())
                    .creator("tyy").creatorId("1234").operator("tyy").operatorId("1234").method(methodName).ip(remoteIp).params(params).build();
                userOperationService.save(userOperationReq);
        }
        return joinPoint.proceed();
    }
}
