package PuzzleYourSelfie.backend.GameDiagnostics.Diagnostics;

import PuzzleYourSelfie.backend.GameDiagnostics.LevelNotFoundException;
import PuzzleYourSelfie.backend.GameDiagnostics.UserNotFoundException;
import PuzzleYourSelfie.backend.GameDiagnostics.model.ApiResponse;
import PuzzleYourSelfie.backend.GameDiagnostics.model.LevelDiagnosticsIncomingRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diagnostics")
@AllArgsConstructor
public class LevelDiagnosticsController {

    private LevelDiagnosticsDAO levelDiagnosticsDAO;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ApiResponse<String> postDiagnostics(@RequestBody LevelDiagnosticsIncomingRequest body) {
        try {
            levelDiagnosticsDAO.saveToDatabase(levelDiagnosticsDAO.transformIncomingRequestToLevelDiagnosticsModel(body));
            return new ApiResponse<>(HttpStatus.ACCEPTED, "Data was saved");
        } catch (LevelNotFoundException e) {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, "Level was not found with id: " + body.getLevelId());
        } catch (UserNotFoundException e) {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, "User was not found with id: " + body.getUserId());
        }
    }

}
