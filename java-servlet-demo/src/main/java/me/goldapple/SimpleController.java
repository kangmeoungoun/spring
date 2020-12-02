package me.goldapple;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jojoldu@gmail.com on 2020-12-02
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

@org.springframework.stereotype.Controller("/simple")
public class SimpleController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("simple");
    }
}
