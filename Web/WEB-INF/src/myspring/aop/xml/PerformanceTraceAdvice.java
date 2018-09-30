package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint)throws Throwable{
		long start = System.currentTimeMillis();
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + " 시작");
		
		try{
			Object result = joinPoint.proceed();
			return result;
			
		}finally{
			System.out.println(signatureString + " 종료");
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 실행시간: " + (finish - start)+ " ms");
		}
		
	}
}
