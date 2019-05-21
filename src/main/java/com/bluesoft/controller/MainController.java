package com.***REMOVED***.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Matt on 21.05.2019 at 20:18.
 */

@Controller
public class MainController {

    @ResponseBody
    @GetMapping("/greetings")
    public String greetings() {
        return "greetings";
    }
}
