package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

		for (Object tempArgs : args) {
			System.out.println("Args: " + tempArgs);

			if (tempArgs instanceof Account) {
				Account account = (Account) tempArgs;

				System.out.println("Account name: " + account.getName());
				System.out.println("Account age: " + account.getAge());
			}
		}
	}

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

		String method = joinPoint.getSignature().toShortString();

		System.out.println("\n=========>>>>>> Executing @AfterReturning on method: " + method);

		System.out.println("\n=========>>>>>> Result: " + result);

		// convert the account name to uppercase
		convertAccoountNamesToUpperCase(result);

		System.out.println("\n=========>>>>>> Result after modify: " + result);
	}

	private void convertAccoountNamesToUpperCase(List<Account> result) {

		for (Account tempAccount : result) {
			String upperName = tempAccount.getName().toUpperCase();

			tempAccount.setName(upperName);
		}
	}
}
