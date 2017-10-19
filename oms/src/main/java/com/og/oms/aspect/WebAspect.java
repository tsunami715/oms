package com.og.oms.aspect;

import com.og.oms.annotation.PermisAnnotation;
import com.og.oms.enums.ResultCode;
import com.og.oms.exception.OmsException;
import com.og.oms.utils.JsonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 拦截器：记录用户操作日志，检查用户是否登录……
 */
@Aspect
@Component
@Order(-99)
public class WebAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebAspect.class);

    public WebAspect() {
        logger.info("初始化WebAspect");
    }

    /**
     * 拦截器具体实现
     *
     * @param pjp
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object Interceptor(ProceedingJoinPoint pjp) {
        // 记录方法开始的时间
        long beginTime = System.currentTimeMillis();

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        // 获取被拦截的方法
        Method method = signature.getMethod();
        // 获取被拦截的方法名
        String methodName = method.getName();

        // 判断用户是否登录

        // 是否需要验证权限
        PermisAnnotation permis = method.getAnnotation(PermisAnnotation.class);
        if(permis != null) {
            // TODO 判断是否有权限
        }

        // 校验参数
        for(Object obj : pjp.getArgs()) {
            if(obj instanceof BindingResult) {
                BindingResult br = (BindingResult) obj;
                if(br.hasErrors()) {
                    List<ObjectError> list = br.getAllErrors();
                    System.out.println(list.get(0).getDefaultMessage());
                }
            }
        }

        Object result = null;
        try {
            if(result == null) {
                // 一切正常的情况下，继续执行被拦截的方法
                result = pjp.proceed();
            }
        } catch(Throwable e) {
            if(!(e instanceof OmsException)) {
                logger.error("执行{}方法异常", e, methodName);
            }

            result = new JsonResult(ResultCode.EXCEPTION, "发生异常：" + e.getMessage());
        }

        long costMs = System.currentTimeMillis() - beginTime;
        logger.info("{}请求结束，耗时：{}ms", methodName, costMs);

        return result;
    }


    @AfterThrowing(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)", throwing = "e")
    public void handleThrowing(Exception e) {
        logger.info("handleThrowing");
    }
}
