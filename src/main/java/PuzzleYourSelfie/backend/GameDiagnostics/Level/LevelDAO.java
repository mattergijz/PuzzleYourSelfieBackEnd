package PuzzleYourSelfie.backend.GameDiagnostics.Level;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class LevelDAO {

    private LevelRepository levelRepository;

    public void saveToDatabase(Level level) {
        this.levelRepository.save(level);
    }

    public List<Level> getAll() {
        return levelRepository.findAll();
    }
}
