package me.goldapple.demobootweb;

import org.springframework.web.bind.annotation.*;

/**
 * Created by jojoldu@gmail.com on 2020-12-05
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@RestController
public class SampleController {
    //prehandle
    //요청 처리
    //posthandler
    //뷰 랜더링
    //afterCompletion
    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person,int a){
        return "hello "+person.getName() ;
    }
    @GetMapping("/message")
    public String message(@RequestBody String body){
        return body;
    }
    @GetMapping("/jsonMessage")
    public Person jsonMessage(@RequestBody Person person){
        return person;
    }
}
