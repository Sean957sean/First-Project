package Hello.hellospring.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController

public class RestController {
    @PostMapping("/users/create")
    public @ResponseBody User create(@RequestBody User user) {
        return user;
        //RestController 라는 것이 있으면 ResponseBody 라는 어노테이션 생략가능!
        //User 라는 객체로 넘겨주기
    }

}
