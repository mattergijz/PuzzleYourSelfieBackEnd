package PuzzleYourSelfie.backend.GameDiagnostics.Diagnostics;


import PuzzleYourSelfie.backend.GameDiagnostics.Level.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelDiagnostics {

    @Id
    @Column
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    private Level level;


}
