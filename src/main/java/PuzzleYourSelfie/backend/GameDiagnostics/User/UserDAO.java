package PuzzleYourSelfie.backend.GameDiagnostics.User;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserDAO {

    private UserRepository userRepository;

    public Optional<User> getById(UUID userId) {
        return userRepository.findById(userId);
    }

    public void saveToDatabase(User user) {
        userRepository.save(user);
    }

}
