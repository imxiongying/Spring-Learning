package me.xiongying.springlearning.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/test")
public class TestAction {

    @GetMapping(value = "")
    public String test() {
        return "test msg";
    }
}
