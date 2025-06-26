package ru.netology.springBootDemo.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springBootDemo.model.Authorities;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<String, String> authorizedUsers = Map.of(
            "admin", "adminPassword",
            "user", "qwerty"
    );

    private final Map<String, List<Authorities>> permissions = Map.of(
            "admin", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE),
            "user", List.of(Authorities.READ)
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (authorizedUsers.containsKey(user) && authorizedUsers.get(user).equals(password)) {
            return permissions.get(user);
        }
        return Collections.emptyList();
    }
}