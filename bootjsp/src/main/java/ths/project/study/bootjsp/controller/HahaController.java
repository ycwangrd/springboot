package ths.project.study.bootjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: wangrd
 * @since: 2018年10月16日 13:47:42
 * @Desc:
 */
@Controller
public class HahaController {
    @GetMapping(value = "/welcome")
    public String welcome(Model model) {
        model.addAttribute("name", "SpringBoot使用jsp");
        return "welcome";
    }
}
