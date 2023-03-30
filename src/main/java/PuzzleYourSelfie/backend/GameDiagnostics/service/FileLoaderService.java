package PuzzleYourSelfie.backend.GameDiagnostics.service;

import org.apache.catalina.core.ApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileLoaderService {

    public String loadFile(ApplicationContext context) throws IOException {
        URL resource = context.getResource("classpath:levels.json");
        InputStream inputStream = resource.openStream();
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
        String fileContent = scanner.useDelimiter("\\A").next();
        scanner.close();
        return fileContent;
    }
}
