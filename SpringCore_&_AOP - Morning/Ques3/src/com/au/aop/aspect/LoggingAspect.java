package com.au.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//multiple advices inside aspect
@Aspect
public class LoggingAspect {
	
	//to write specifically for circle class write om.au.aop.model.Circle.getName()
//	@Before("execution(public String getName())")
//	public void LoggingAdvice() {
//		System.out.println("Logging Advice");
//	}
	
	//Apply before all methods start with get
	//execution(public * get*(*) - with parameter
	//execution(public * get*(..) - with any number of parameters
	//execution(* com.au.aop.model.*.get*()) - all get functions for class under model
	@Before("execution(public * get*())")
	public void LoggingAdvice() {
		System.out.println("Logging Advice");
		
	}
	
	@Before("allGetters()")
	public void SecondAdvice() {
		System.out.println("Second Advice");
		
	}
	
	@After("execution(public * get*())")
	public void LoggingAfterAdvice() {
		System.out.println("Logging After Advice");
		
	}
	
	@AfterReturning("execution(public * get*())")
	public void LoggingAfterReturningAdvice() {
		System.out.println("Logging After Returning Advice");
		
	}
	
	@AfterThrowing (pointcut = "execution(* com.au.aop.service.ShapeService.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(Exception ex) throws Throwable 
    {
        System.out.println("Logging if any method throws exception " + ex);
    }
	
	@Pointcut("execution(public * get*(..))")
	public void allGetters() { 
		/* this is a dummy method for holding pointcut expressions, so they can be referenced later in annotations @Before etc */
	}
	
	@Pointcut("execution (public * set*(..))")
	private void setterMethods() {}
	
	@Around("setterMethods()")
	public void aroundAdvice() {
		System.out.println("Around Advice");
	}


}
