package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!@!@!");

        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam(name="name") String name, Model model) {
        model.addAttribute("name", name);

        return "hello-templete";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(name="name") String name) {
        return "hello" + name; //hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        //프로퍼티 접근 방식이라고 함
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
