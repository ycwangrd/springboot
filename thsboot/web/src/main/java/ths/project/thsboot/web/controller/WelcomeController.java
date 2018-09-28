package ths.project.thsboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: wangrd
 * @since: 2018年08月10日 17:30:09
 * @Desc:
 */
@Controller(value = "/")
public class WelcomeController {
    
    @GetMapping("/rest")
    @ResponseBody
    public String welcome() {
        return "Welcome to first Springboot";
    }
    
    @GetMapping("/")
    public ModelAndView mvcWelcome() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
}
