package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        @Autowired(required = false)//(required = false)일때 Member라는 bean이없으므로 이 메소드 자체가 호출이 안된다.
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = "+noBean1);
        }

        @Autowired//@Nullable 얘는 호출은 가능하지만 없으므로 null이 들어간다.
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = "+noBean2);
        }

        @Autowired//Optional<Member> optional로 감싸준다.
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = "+noBean3);
        }
    }
}
