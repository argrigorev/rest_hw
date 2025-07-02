package ru.netology.springBootDemo.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springBootDemo.model.Authorities;
import ru.netology.springBootDemo.model.User;
import ru.netology.springBootDemo.resolver.FromQuery;
import ru.netology.springBootDemo.service.AuthorizationService;
import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid @FromQuery User user) {
        return service.getAuthorities(user);
    }
}
