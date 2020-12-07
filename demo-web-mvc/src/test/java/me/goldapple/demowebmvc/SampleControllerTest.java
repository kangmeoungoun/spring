package me.goldapple.demowebmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by jojoldu@gmail.com on 2020-12-05
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void eventForm()throws Exception{
        MockHttpServletRequest request = this.mockMvc.perform(get("/events/form"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/events/form"))
                .andExpect(model().attributeExists("event"))
                .andExpect(request().sessionAttribute("event", notNullValue()))
                .andReturn().getRequest();
        Object event = request.getSession().getAttribute("event");
        System.out.println(event);
    }

    @Test
    public void helloTest() throws Exception {
        /*
        this.mockMvc.perform(options("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().stringValues(HttpHeaders.ALLOW,
                        hasItems(containsString("GET")
                                ,containsString("HEAD")
                                ,containsString("OPTIONS")
                )));
        */
        ResultActions resultActions = this.mockMvc.perform(post("/events")
                .param("name", "kmo")
                .param("limit", "-1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().hasErrors());
        ModelAndView modelAndView = resultActions.andReturn().getModelAndView();
        Map<String, Object> model = modelAndView.getModel();
        System.out.println(model.size());

    }
    @Test
    public void getEvents() throws Exception{
        Event newEvent = new Event();
        newEvent.setName("Winter is coming.");
        newEvent.setLimit(10000);
        this.mockMvc.perform(get("/events/list")
                    .sessionAttr("visitTime", LocalDateTime.now())
                    .flashAttr("newEvent",newEvent))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(model().attributeExists("categories"))
                    ;//.andExpect(xpath("//p").nodeCount(2));
    }
}