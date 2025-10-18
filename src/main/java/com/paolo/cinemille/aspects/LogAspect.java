package com.paolo.cinemille.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.java.Log;

@Log
@Aspect
public class LogAspect {
	
	@Pointcut("execution(* com.paolo.cinemille.controllers.*.*(..))")
	private void controllers() {}
	
	@Pointcut("execution(* com.paolo.cinemille.services.*.*(..))")
	private void services() {}

	@Around("controllers() || services()")
	Object logService(ProceedingJoinPoint pjp) throws Throwable 
	{
		String type= pjp.getSignature().getDeclaringTypeName();
		String method = pjp.getSignature().getName();
		
		log.info(String.format("%s:%s start", type, method));
		
		Object value = pjp.proceed();
		
		log.info(String.format("%s : %s end", type, method));
		
		return value;
	}
}
