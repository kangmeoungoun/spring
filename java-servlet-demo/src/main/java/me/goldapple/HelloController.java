package me.goldapple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jojoldu@gmail.com on 2020-12-01
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@Controller
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello" + helloService.getName();
    }
    @GetMapping("/sample")
    public String sample(){
        return "sample";
    }
}
