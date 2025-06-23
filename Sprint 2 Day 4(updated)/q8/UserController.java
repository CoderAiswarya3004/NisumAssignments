import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @PostMapping
    public String save(@RequestBody User user) {
        userDAO.save(user);
        return "User saved";
    }

    @PutMapping
    public String update(@RequestBody User user) {
        userDAO.update(user);
        return "User updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userDAO.delete(id);
        return "User deleted";
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return userDAO.get(id);
    }

    @GetMapping
    public List<User> list() {
        return userDAO.list();
    }
}
