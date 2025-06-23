import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private Map<Integer, User> users = new HashMap<>();

    @PostMapping
    public String create(@RequestBody User user) {
        users.put(user.getId(), user);
        return "User created";
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return users.get(id);
    }

    @GetMapping
    public Collection<User> getAll() {
        return users.values();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody User user) {
        users.put(id, user);
        return "User updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        users.remove(id);
        return "User deleted";
    }
}
