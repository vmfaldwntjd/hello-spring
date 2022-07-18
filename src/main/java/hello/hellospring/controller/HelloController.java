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
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    //mvc 방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    //API 방식 -> 위의 mvc와의 차이가 뭐냐면 페이지 소스보기를 진행했을 때 html소스 코드가 뜨지 않고 데이터 결과가 뜬다.
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    //여기부터가 진짜 API 실습이다.
    @GetMapping("hello-api")
    @ResponseBody //이게 붙어있으면 데이터를 그냥 그대로 넘겨준다. 즉, html템플릿 파일을 찾아서 넘겨주지 않고 문자 그대로 넘겨주는 역할을 한다.
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); //새로운 객체를 만들었다.
        hello.setName(name);
        return hello; //이번엔 객체를 넘겨주었다. -> 이렇게 되면 json 방식으로 데이터가 넘어간다.
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
