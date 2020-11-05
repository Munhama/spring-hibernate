package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortuneService(..))")
	public Object aroundGetFortuneService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("\n=========>>>>>> Executing @Around on method: " + method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			
			// log the exception
			logger.warning(e.getMessage());
			
			// rethrow exception
			throw e;
			
			/* HANDLING EXCEPTION!!!
			// give user a custom message
			result = "Your helicopter is on the way!";
			*/
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		logger.info("\n=========>>>>>> Duration: " + duration / 1000.0 + " second");
		
		return result;
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {

		String method = joinPoint.getSignature().toShortString();

		logger.info("\n=========>>>>>> Executing @After on method: " + method);
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exception")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exception) {

		String method = joinPoint.getSignature().toShortString();

		logger.info("\n=========>>>>>> Executing @AfterThrowing on method: " + method);

		logger.info("\n=========>>>>>> The Exception is: " + exception);
	}

	@Before("com.luv2code.aopdemo.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {

		logger.info("\n=========>>>>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		logger.info("Method: " + methodSignature);

		// display method arguments
		Object[] args = joinPoint.getArgs();

		for (Object tempArgs : args) {
			logger.info("Args: " + tempArgs);

			if (tempArgs instanceof Account) {
				Account account = (Account) tempArgs;

				logger.info("Account name: " + account.getName());
				logger.info("Account age: " + account.getAge());
			}
		}
	}

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

		String method = joinPoint.getSignature().toShortString();

		logger.info("\n=========>>>>>> Executing @AfterReturning on method: " + method);

		logger.info("\n=========>>>>>> Result: " + result);

		// convert the account name to uppercase
		convertAccoountNamesToUpperCase(result);

		logger.info("\n=========>>>>>> Result after modify: " + result);
	}

	private void convertAccoountNamesToUpperCase(List<Account> result) {

		for (Account tempAccount : result) {
			String upperName = tempAccount.getName().toUpperCase();

			tempAccount.setName(upperName);
		}
	}
}
