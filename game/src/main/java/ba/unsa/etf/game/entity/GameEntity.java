package ba.unsa.etf.game.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "game")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(name = "about")
    private String about;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "esbr_rating")
    private String esbrRating;

    @ManyToOne
    @JoinColumn(name="publisher_id")
    private PublisherEntity publisher;

    @OneToOne
    @JoinColumn(name = "review_id")
    private ReviewEntity review;

    @ManyToMany(mappedBy = "games")
    private List<CharacterEntity> characters;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "game_genre",
            joinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id",
                    referencedColumnName = "id"))
    private List<GenreEntity> genres;
}
