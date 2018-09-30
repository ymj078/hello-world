package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint)throws Throwable{
		long start = System.currentTimeMillis();
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + " ����");
		
		try{
			Object result = joinPoint.proceed();
			return result;
			
		}finally{
			System.out.println(signatureString + " ����");
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " ����ð�: " + (finish - start)+ " ms");
		}
		
	}
}
