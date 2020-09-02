package Hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(@RequestParam("data") String name , Model model){
        model.addAttribute("data", name);
        int a = 1;
        int b = 10;
        System.out.println(a+b);
        return "hello";
    }
}
