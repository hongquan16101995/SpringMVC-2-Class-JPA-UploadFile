package com.cg.product.controller;

import com.cg.product.model.SessionCookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sc")
@SessionAttributes("user")
public class SessionCookieController {

    @ModelAttribute("user")
    public SessionCookie setUpSession() {
        return new SessionCookie();
    }

    @GetMapping
    public String getSession(@ModelAttribute("user") SessionCookie sessionCookie) {
        sessionCookie.increment();
        return "/session_cookie";
    }

    @GetMapping("/login")
    public String login(@CookieValue(value = "setUser", defaultValue = "") String setUser,
                        Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "/session_cookie";
    }

    @PostMapping("/do_login")
    public String doLogin(@ModelAttribute("user") SessionCookie sessionCookie,
                          Model model,
                          @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response,
                          HttpServletRequest request) {
        if (sessionCookie.getUsername().equals("admin@gmail.com") &&
                sessionCookie.getPassword().equals("123456")) {
            if (sessionCookie.getUsername() != null) {
                setUser = sessionCookie.getUsername();
            }

            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            Cookie[] cookies = request.getCookies();
            for (Cookie ck : cookies) {
                if (!ck.getName().equals("setUser")) {
                    ck.setValue("");
                }
                model.addAttribute("cookieValue", ck);
                break;
            }
        } else {
            sessionCookie.setUsername("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
        }
        return "/session_cookie";
    }
}
