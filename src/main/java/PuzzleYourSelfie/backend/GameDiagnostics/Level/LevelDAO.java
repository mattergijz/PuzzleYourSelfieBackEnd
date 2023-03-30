package PuzzleYourSelfie.backend.GameDiagnostics.Level;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class LevelDAO {

    private LevelRepository levelRepository;

    public void saveToDatabase(Level level) {
        this.levelRepository.save(level);
    }

    public Optional<Level> getById(UUID levelId) {
        return levelRepository.findById(levelId);
    }

    public List<Level> getAll() {
        return levelRepository.findAll();
    }
}
