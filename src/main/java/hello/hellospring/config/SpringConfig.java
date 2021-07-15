package hello.hellospring.config;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberBeanRepository;
import hello.hellospring.repository.MemberBeanRepositoryImpl;
import hello.hellospring.service.MemberBeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberBeanService memberBeanService(){
        return new MemberBeanService(memberBeanRepository());
    }

    @Bean
    public MemberBeanRepository memberBeanRepository(){
        return new MemberBeanRepositoryImpl();
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }
}
