package com.mddarr.avromoviekafka.resource;


import com.mddarr.avromoviekafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final Producer producer;

    @Autowired
    UserResource(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestParam("name") String name, @RequestParam("age") Integer age) {
            this.producer.sendMessage(new com.mddarr.avromoviekafka.User(name, age));
        return "Success";
    }
}