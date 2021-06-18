package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",//hello.core.member 이하를 스캔한다.
        basePackageClasses = AutoAppConfig.class,//AutoAppConfig.class가 있는 패키지 이하를 스캔한다.
        //컴포넌트 스캔에서 제외할 것들(즉 현재까지의 코드에서는 AppConfig는 제외한다.)
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    @Bean(name="memoryMemberRepository")
    MemberRepository MemoryMemberRepository(){
        return new MemoryMemberRepository();
    }
}
