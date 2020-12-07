package me.goldapple.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2020-12-05
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@Controller
@SessionAttributes("event")
public class SampleController {


//    @ModelAttribute("categories")
//    public List<String> categories(){
//        return List.of("study","seminar","hobby","social");
//    }

    //@GetMapping(value = "/hello"
                //,consumes = MediaType.APPLICATION_JSON_VALUE
                //,produces = MediaType.TEXT_PLAIN_VALUE
                //,params = "name=kmo"
    //)

    @GetMapping("/events/form/name")
    public String eventFormName(Model model){
        throw new EventException();
        //model.addAttribute("event", new Event());
        //return "/events/form-name";
    }
    @PostMapping("/events/form/name")
    public String eventsFormNameSubmit(@Valid @ModelAttribute Event event,
                              BindingResult bindingResult
                              ){
        if(bindingResult.hasErrors()){
            return "/events/form-name";
        }
        return "redirect:/events/form/limit";
    }
    @GetMapping("/events/form/limit")
    public String eventFormLimit(@ModelAttribute Event event,Model model){
        model.addAttribute("event", event);
        return "/events/form-limit";
    }
    @PostMapping("/events/form/limit")
    public String eventsFormLimitSubmit(@Valid @ModelAttribute Event event,
                                       BindingResult bindingResult,
                                        SessionStatus sessionStatus,
                                        RedirectAttributes attributes

    ){
        if(bindingResult.hasErrors()){
            return "/events/form-limit";
        }
        sessionStatus.setComplete();
        attributes.addFlashAttribute("newEvent", event);
        return "redirect:/events/list";
    }


    @GetMapping("/events/list")
    public String getEvents(
                            Model model,
                            @SessionAttribute LocalDateTime visitTime){
        /*조회했다고 치고*/
        Event event = (Event)model.asMap().get("newEvent");
        Event newEvent = new Event();
        newEvent.setName("spring");
        newEvent.setLimit(10);

        List<Event> eventList = new ArrayList<>();
        eventList.add(newEvent);
        eventList.add(event);
        model.addAttribute("eventList", eventList);
        return "/events/list";
    }

}
