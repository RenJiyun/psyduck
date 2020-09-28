package com.eggip.api;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private Map<Long, User> users = new ConcurrentHashMap<>();

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return user;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return users.get(id);
    }

}
