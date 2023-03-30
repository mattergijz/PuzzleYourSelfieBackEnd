package PuzzleYourSelfie.backend.GameDiagnostics.User;

import PuzzleYourSelfie.backend.GameDiagnostics.model.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private UserDAO userDAO;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ApiResponse<String> createUser(@RequestBody Map<String, Object> body) {
        int age = Integer.parseInt(String.valueOf(body.get("age")));
        String name = String.valueOf(body.get("name"));
        userDAO.saveToDatabase(new User(age, name));
        return new ApiResponse<>(HttpStatus.ACCEPTED, "User was created");
    }
}
