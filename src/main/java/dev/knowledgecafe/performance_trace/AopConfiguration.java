package dev.knowledgecafe.performance_trace;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfiguration {
    @Pointcut("execution(public String dev.knowledgecafe.performance_trace.EmployeeService.getFullName(..)))")
    public void monitor() { }

    @Pointcut("execution(public int dev.knowledgecafe.performance_trace.EmployeeService.createEmployee(..))")
    public void customMonitor() { }

    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
        return new PerformanceMonitorInterceptor(true);
    }

    @Bean
    public Advisor performanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("dev.knowledgecafe.performance_trace.AopConfiguration.monitor()");
        return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
    }


    @Bean
    public CustomPerformanceIntercepter customPerformanceMonitorInterceptor() {
        return new CustomPerformanceIntercepter(true);
    }
    @Bean
    public Advisor customPerformanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("dev.knowledgecafe.performance_trace.AopConfiguration.customMonitor()");
        return new DefaultPointcutAdvisor(pointcut, customPerformanceMonitorInterceptor());
    }

}
