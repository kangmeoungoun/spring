package me.whiteship.demospringmvc;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2020-11-30
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@Service
public class EventService {
    public List<Event> getEvents(){
        Event event = Event.builder()
                            .name("스프링 웹 MVC 스터디 1차")
                            .limitOfEnrollment(5)
                            .startDataTime(LocalDateTime.of(2019,1,10,10,0))
                            .endDataTime(LocalDateTime.of(2019,1,10,20,0))
                            .build();
        Event event2 = Event.builder()
                .name("스프링 웹 MVC 스터디 2차")
                .limitOfEnrollment(5)
                .startDataTime(LocalDateTime.of(2019,1,10,10,0))
                .endDataTime(LocalDateTime.of(2019,1,10,20,0))
                .build();
        return List.of(event, event2);
    }
}
