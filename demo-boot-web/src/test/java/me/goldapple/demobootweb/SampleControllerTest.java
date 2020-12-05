package me.goldapple.demobootweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by jojoldu@gmail.com on 2020-12-05
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;
    @Test
    public void hello() throws Exception {

        Person person = new Person();
        person.setName("kmo");

        Person savedPerson = personRepository.save(person);
        this.mockMvc.perform(get("/hello")
                    .param("id",savedPerson.getId().toString()))
                .andDo(print())
                .andExpect(content().string("hello kmo"));
    }
    @Test
    public void helloStatic()throws Exception{
        this.mockMvc.perform(get("/mobile/index.html"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(Matchers.containsString("Hello Mobile")))
                    .andExpect(header().exists(HttpHeaders.CACHE_CONTROL));
    }
    @Test
    public void stringMessage() throws Exception{
        this.mockMvc.perform(get("/message")
                .content("hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }
    @Test
    public void jsonMessage() throws Exception{
        Person person = new Person();
        person.setId(2019L);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(person);
        this.mockMvc.perform(get("/jsonMessage")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(s))
                    .andDo(print())
                    .andExpect(status().isOk());
    }
}