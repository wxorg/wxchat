package wx.com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	@Pointcut("execution(* wx.com.service1.*.msg_Handler(..))")
	public void myPointCut() { } 
	
	
	@Before("myPointCut()")
	public void doBefore(JoinPoint jp){
		System.out.println("befor log ................");
	}
	
	@After("myPointCut()")
	public void doAfter(JoinPoint jp){
		System.out.println("after log ................");
	}

}
