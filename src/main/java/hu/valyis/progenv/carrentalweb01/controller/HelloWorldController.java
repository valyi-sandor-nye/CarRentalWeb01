package hu.valyis.progenv.carrentalweb01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloWorldController {

    @GetMapping
    public String helloWorld() {
        return "hello árvíztűrő tükörfúrógép";

    }
}
