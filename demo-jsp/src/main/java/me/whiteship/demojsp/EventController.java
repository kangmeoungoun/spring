package me.whiteship.demojsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2020-12-05
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@Controller
public class EventController {
    @GetMapping("/events")
    public String getEvents(Model model){
        Event event1 = new Event();
        event1.setName("스프링 웹 MVC 스터디 1");
        event1.setStarts(LocalDateTime.of(2019,1,15,10,20));
        Event event2 = new Event();
        event2.setName("스프링 웹 MVC 스터디 2");
        event2.setStarts(LocalDateTime.of(2019,1,15,12,20));
        List<Event> list = Arrays.asList(event1,event2);
        model.addAttribute("events",list);
        model.addAttribute("message", "Happy New Year");
        return "events/list";
    }
}
