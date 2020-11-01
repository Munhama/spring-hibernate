package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {

	@Before("com.luv2code.aopdemo.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {

		System.out.println("\n=========>>>>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + methodSignature);
		
		// display method arguments
		Object[] args = joinPoint.getArgs();
		
		for(Object tempArgs : args) {
			System.out.println("Args: " + tempArgs);
			
			if(tempArgs instanceof Account) {
				Account account = (Account) tempArgs;
				
				System.out.println("Account name: " + account.getName());
				System.out.println("Account age: " + account.getAge());
			}
		}
	}
}
