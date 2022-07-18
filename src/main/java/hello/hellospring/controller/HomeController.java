package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; //로컬 호스트를 실행하면 템플릿에서 home.html파일이 실행이 될 것이다.
    }
}
