package PuzzleYourSelfie.backend.GameDiagnostics;

import PuzzleYourSelfie.backend.GameDiagnostics.Level.Level;
import PuzzleYourSelfie.backend.GameDiagnostics.Level.LevelDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;


@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private LevelDAO levelDAO;

    private final ResourceLoader resourceLoader;


    public String loadFile() throws IOException {
        ClassPathResource resource = new ClassPathResource("levels.json");
        byte[] bytes = Files.readAllBytes(resource.getFile().toPath());
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public void run(ApplicationArguments args) {
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
