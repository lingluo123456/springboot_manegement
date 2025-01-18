package com.zzs.aop;

import com.zzs.mapper.OperateLogMapper;
import com.zzs.pojo.OperateLog;
import com.zzs.utils.CurrentHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    // 环绕通知
    @Around("@annotation(com.zzs.anno.Log)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        OperateLog operateLog = new OperateLog();
        long startTime = System.currentTimeMillis();
        Object result = null;

            // 获取操作人信息，这里假设从 SecurityContextHolder 中获取，可根据实际情况修改
        operateLog.setOperateEmpId(getCurrentUserId());
            // 获取操作时间
        operateLog.setOperateTime(LocalDateTime.now());
            // 获取目标类的全类名
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
            // 获取目标方法的方法名
        operateLog.setMethodName(joinPoint.getSignature().getName());
            // 获取方法运行时参数
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
            // 执行目标方法
        result = joinPoint.proceed();
            // 获取返回值
        operateLog.setReturnValue(result.toString());
        // 计算方法执行时长
        long endTime = System.currentTimeMillis();
        operateLog.setCostTime(endTime - startTime);
            // 保存日志
        operateLogMapper.insert(operateLog);

        return result;
    }
         private Integer getCurrentUserId() {
         // 示例：从 SecurityContextHolder 中获取用户信息
         return CurrentHolder.getCurrentId();
     }
}