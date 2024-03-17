package ba.unsa.etf.game.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "character")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "about")
    private String about;

    @Column(name = "year_released")
    private Integer yearReleased;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "game_characters",
            joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "character_id", referencedColumnName = "id")
    )
    private List<GameEntity> games;
}


