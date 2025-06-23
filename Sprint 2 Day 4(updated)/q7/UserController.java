import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        return "GET user with ID: " + id;
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        return "POST user created with name: " + user.getName();
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        return "PUT user with ID " + id + " updated to name: " + user.getName();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return "DELETE user with ID: " + id;
    }
}
