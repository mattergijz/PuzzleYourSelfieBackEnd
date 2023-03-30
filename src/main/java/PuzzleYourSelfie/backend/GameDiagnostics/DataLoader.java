package PuzzleYourSelfie.backend.GameDiagnostics;

import PuzzleYourSelfie.backend.GameDiagnostics.Level.Level;
import PuzzleYourSelfie.backend.GameDiagnostics.Level.LevelDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private LevelDAO levelDAO;

    private final ResourceLoader resourceLoader;


    public String loadFile() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("levels.json");
        return String.valueOf(inputStream);
    }

    public void run(ApplicationArguments args) {
        System.out.println(DataLoader.class.getResource("DataLoader.class"));
        List<Level> levels = levelDAO.getAll();
        if (levels.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                Level[] levels1 = mapper.readValue(loadFile(), Level[].class);
                for (Level level : levels1) {
                    levelDAO.saveToDatabase(level);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
