package com.java96.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Aspect
@Log
public class TimeChecker {

	//@Before("execution(* com.java96.service.*.*(..))")//서비스에 있는 모돈 메소드에 이걸 걸고싶어, 문자열을 잘못쓰면 찾기 힘들다.그래서 복붙한거다.
	public void sample1(JoinPoint jp) {
		
		log.info("---------------------------------");
		log.info("" +Arrays.toString(jp.getArgs()) );
		log.info("---------------------------------");
		
	}
	
	//@Around("execution(* com.java96.service.*.*(..))")
	public Object sampleAround(ProceedingJoinPoint jp) throws Throwable {//이렇게 하면 드디어 로그를찍을수 있게 된다.
		
		long start = System.currentTimeMillis();
		
		String methodName = jp.getSignature().getName();//getSignature가 메소드.
		
		
		//Method.invoke()..실제로 그 메소드를 실행해버리는것
		Object result = jp.proceed();
		
		long end = System.currentTimeMillis();
		
		log.info(methodName + " " + (end - start));
		
		return result;
		
	}
}
