package PuzzleYourSelfie.backend.GameDiagnostics.User;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserDAO {

    private UserRepository userRepository;

    public UUID createUser(Map<String, Object> userRequest) {
        if (userRequest.containsKey("age") || userRequest.containsKey("name")) {
            int age = Integer.parseInt(String.valueOf(userRequest.get("age")));
            String name = String.valueOf(userRequest.get("name"));
            User user = new User(age, name);
            saveToDatabase(user);
            return user.getId();
        } else {
            return null;
        }
    }

    public Optional<User> getById(UUID userId) {
        return userRepository.findById(userId);
    }

    public void saveToDatabase(User user) {
        userRepository.save(user);
    }

}
