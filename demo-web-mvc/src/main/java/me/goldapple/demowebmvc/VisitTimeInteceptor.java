package me.goldapple.demowebmvc;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * Created by jojoldu@gmail.com on 2020-12-06
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public class VisitTimeInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("visitTime") ==null){
            session.setAttribute("visitTime", LocalDateTime.now());
        }
        return true;
    }
}
