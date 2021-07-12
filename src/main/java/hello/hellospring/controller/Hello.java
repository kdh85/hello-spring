package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Hello {

    @GetMapping(value = "/hello")
    public String Hello(Model model, @RequestParam(defaultValue = "user") String data){
        model.addAttribute("data",data);
        return "hello";
    }
}
