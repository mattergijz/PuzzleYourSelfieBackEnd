package PuzzleYourSelfie.backend.GameDiagnostics.User;

import PuzzleYourSelfie.backend.GameDiagnostics.model.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private UserDAO userDAO;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ApiResponse<UUID> createUser(@RequestBody Map<String, Object> body) {
        UUID userId = userDAO.createUser(body);
        if (userId != null) {
            return new ApiResponse<>(HttpStatus.ACCEPTED, userId, "User was created");
        } else {
            return new ApiResponse<>(HttpStatus.BAD_REQUEST, "");
        }
    }
}
