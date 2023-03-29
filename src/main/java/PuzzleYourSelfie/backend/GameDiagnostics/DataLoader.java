package PuzzleYourSelfie.backend.GameDiagnostics;

import PuzzleYourSelfie.backend.GameDiagnostics.Level.Level;
import PuzzleYourSelfie.backend.GameDiagnostics.Level.LevelDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static PuzzleYourSelfie.backend.GameDiagnostics.AppConstants.JSON_FILE_PATH;


@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private LevelDAO levelDAO;

    public void run(ApplicationArguments args){
        List<Level> levels = levelDAO.getAll();
        if (levels.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                Level[] levels1 = mapper.readValue(new File(JSON_FILE_PATH), Level[].class);
                for (Level level : levels1) {
                    levelDAO.saveToDatabase(level);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
