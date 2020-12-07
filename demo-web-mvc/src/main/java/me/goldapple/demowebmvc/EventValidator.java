package me.goldapple.demowebmvc;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by jojoldu@gmail.com on 2020-12-07
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

public class EventValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Event event = (Event)o;
        if(event.getName().equalsIgnoreCase("aaa")){
            errors.rejectValue("name","wrongValue","this value is not allowed");
        }
    }
}
