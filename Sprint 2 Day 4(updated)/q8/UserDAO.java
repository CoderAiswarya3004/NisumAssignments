import java.util.List;

public interface UserDAO {
    void save(User user);
    void update(User user);
    void delete(int id);
    User get(int id);
    List<User> list();
}
