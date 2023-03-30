package PuzzleYourSelfie.backend.GameDiagnostics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelDiagnosticsIncomingRequest {
    private UUID userId;
    private UUID levelId;
    private int piecesLeft;
    private int timeLeft;
    private boolean finished;

    @Override
    public String toString() {
        return String.format("UserId: %s; LevelId: %s; Pieces left: %s; Time left: %s; Finished: %s;", userId, levelId, piecesLeft, timeLeft, finished);
    }
}
