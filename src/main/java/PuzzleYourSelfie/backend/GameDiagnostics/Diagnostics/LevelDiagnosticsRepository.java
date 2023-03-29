package PuzzleYourSelfie.backend.GameDiagnostics.Diagnostics;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LevelDiagnosticsRepository extends JpaRepository<LevelDiagnostics, UUID> {

}
