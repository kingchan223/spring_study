package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    //이렇게 되면 MyLogger가 아니라, MyLogger를 DL할 수 있는 객체가 의존성으로 주입된다.
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestUrl = request.getRequestURL().toString();
        myLogger.setRequestURL(requestUrl);
        System.out.println(myLogger);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
