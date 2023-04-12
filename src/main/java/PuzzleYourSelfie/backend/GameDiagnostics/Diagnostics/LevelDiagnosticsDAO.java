package PuzzleYourSelfie.backend.GameDiagnostics.Diagnostics;

import PuzzleYourSelfie.backend.GameDiagnostics.Level.Level;
import PuzzleYourSelfie.backend.GameDiagnostics.Level.LevelDAO;
import PuzzleYourSelfie.backend.GameDiagnostics.exception.LevelNotFoundException;
import PuzzleYourSelfie.backend.GameDiagnostics.User.User;
import PuzzleYourSelfie.backend.GameDiagnostics.User.UserDAO;
import PuzzleYourSelfie.backend.GameDiagnostics.exception.UserNotFoundException;
import PuzzleYourSelfie.backend.GameDiagnostics.model.LevelDiagnosticsIncomingRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class LevelDiagnosticsDAO {
    private LevelDiagnosticsRepository levelDiagnosticsRepository;
    private LevelDAO levelDAO;

    private UserDAO userDAO;

    public void saveToDatabase(LevelDiagnostics levelDiagnostics) {
        levelDiagnosticsRepository.save(levelDiagnostics);
    }

    public LevelDiagnostics transformIncomingRequestToLevelDiagnosticsModel(LevelDiagnosticsIncomingRequest request) throws LevelNotFoundException, UserNotFoundException {
        Optional<Level> levelOpt = levelDAO.getById(request.getLevelId());
        if (levelOpt.isEmpty()) {
            throw new LevelNotFoundException();
        }
        Optional<User> userOpt = userDAO.getById(request.getUserId());
        if (userOpt.isEmpty()) {
            throw new UserNotFoundException();
        }
        return new LevelDiagnostics(levelOpt.get(), userOpt.get(), request.getTimeLeft(), request.getPiecesLeft(), request.isFinished());
    }
}
