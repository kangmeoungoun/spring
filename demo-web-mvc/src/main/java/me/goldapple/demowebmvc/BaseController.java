package me.goldapple.demowebmvc;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2020-12-08
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@ControllerAdvice(basePackages ={"me.goldapple",""} )

public class BaseController {
    @ExceptionHandler
    public String eventErrorHandler(EventException eventException , Model model){
        model.addAttribute("message","event error");
        return "error";
    }

    @InitBinder
    public void initEventBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
        webDataBinder.addValidators(new EventValidator());
    }
    @ModelAttribute
    public void categories(Model model){
        model.addAttribute("categories", List.of("study","seminar","hobby","social"));
    }
}
