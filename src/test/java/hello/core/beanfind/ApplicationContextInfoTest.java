package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 bean출력하기")
    void findAll(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames){
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name  = " + beanDefinitionName + ", object = "+bean);
        }
        System.out.println("---------------------------------------------------------------------");
        Map<String, MemberRepository> beansOFType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOFType.keySet()) {
            System.out.println("key = "+key+",  value = "+beansOFType.get(key));
        }
    }

    @Test
    @DisplayName("애플리케이션 bean출력하기")
    void findapplicationbean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
             /*
             ROLE ROLE_APPLICATION:    직접 등록한 애플리케이션 빈  == 0
             ROLE ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈 == 0
             getRole()은 ROLE에 따라 정수 0, 1, 2를 반환한다.
             */
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name  = " + beanDefinitionName + ", object = "+bean);
            }
        }
    }
}
