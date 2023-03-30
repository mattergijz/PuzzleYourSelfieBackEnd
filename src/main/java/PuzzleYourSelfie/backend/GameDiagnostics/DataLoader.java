package PuzzleYourSelfie.backend.GameDiagnostics;

import PuzzleYourSelfie.backend.GameDiagnostics.Level.Level;
import PuzzleYourSelfie.backend.GameDiagnostics.Level.LevelDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;


@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private LevelDAO levelDAO;

    private final ResourceLoader resourceLoader;

    ApplicationContext context;

    //TODO: make sure file gets read in the dev environment as well als the production environment
    public String loadFileFromJar(ApplicationContext context) throws IOException {
        URL resource = context.getResource("classpath:levels.json");
        InputStream inputStream = resource.openStream();
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
        String fileContent = scanner.useDelimiter("\\A").next();
        scanner.close();
        return fileContent;
    }

    public String loadFileNormally() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:levels.json");
        byte[] bytes = Files.readAllBytes(resource.getFile().toPath());
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public void run(ApplicationArguments args) {
        List<Level> levels = levelDAO.getAll();
        if (levels.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                String currentFile = String.valueOf(DataLoader.class.getResource("DataLoader.class"));
                Level[] levels1;
                if (currentFile.startsWith("jar:")) {
                    levels1 = mapper.readValue(loadFileFromJar(context), Level[].class);
                } else {
                    levels1 = mapper.readValue(loadFileNormally(), Level[].class);
                }
                for (Level level : levels1) {
                    levelDAO.saveToDatabase(level);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
