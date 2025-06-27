package ru.netology.springBootDemo.service;

import org.springframework.stereotype.Service;
import ru.netology.springBootDemo.exception.UnauthorizedUser;
import ru.netology.springBootDemo.model.Authorities;
import ru.netology.springBootDemo.model.User;
import ru.netology.springBootDemo.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> authorities = userRepository.getUserAuthorities(user.getUser(), user.getPassword());
        if (authorities == null || authorities.isEmpty()) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }

        return authorities;
    }
    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
