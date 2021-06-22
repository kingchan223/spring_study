package hello.core.lifecycle;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleTest {

    @Test
    public void lifecyleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifecycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifecycleConfig {
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("https://hello!");
            return networkClient;
        }
    }
}
