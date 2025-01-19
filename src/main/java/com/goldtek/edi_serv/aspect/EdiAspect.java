package com.goldtek.edi_serv.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EdiAspect {
	@Before("execution(* com.goldtek.edi_serv.*(..))")
	public void before() {
		System.out.println("========START==========");
	}
}
