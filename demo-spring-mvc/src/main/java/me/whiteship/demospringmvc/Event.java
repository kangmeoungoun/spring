package me.whiteship.demospringmvc;

import lombok.*;

import java.time.LocalDateTime;

/**
 * Created by jojoldu@gmail.com on 2020-11-30
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@Getter
@Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class Event {
    private String name;

    private int limitOfEnrollment;

    private LocalDateTime startDataTime;

    private LocalDateTime endDataTime;
}
