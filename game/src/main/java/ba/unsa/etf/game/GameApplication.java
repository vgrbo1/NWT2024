package ba.unsa.etf.game;

import ba.unsa.etf.game.entity.CharacterEntity;
import ba.unsa.etf.game.entity.GameEntity;
import ba.unsa.etf.game.entity.PublisherEntity;
import ba.unsa.etf.game.entity.ReviewEntity;
import ba.unsa.etf.game.repository.CharacterRepository;
import ba.unsa.etf.game.repository.GameRepository;
import ba.unsa.etf.game.repository.PublisherRepository;
import ba.unsa.etf.game.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class GameApplication {

	private final CharacterRepository characterRepository;
	private final PublisherRepository publisherRepository;
	private final GameRepository gameRepository;
	private final ReviewRepository reviewRepository;

	public GameApplication(final CharacterRepository characterRepository, PublisherRepository publisherRepository, GameRepository gameRepository, ReviewRepository reviewRepository) {
		this.characterRepository = characterRepository;
        this.publisherRepository = publisherRepository;
        this.gameRepository = gameRepository;
        this.reviewRepository = reviewRepository;
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GameApplication.class, args);
		GameApplication myApplication = context.getBean(GameApplication.class);
		CharacterEntity ce = new CharacterEntity();
		ce.setName("Neki lik");
		ce.setAbout("Los karakter");
		ce.setYearReleased(2013);
		ce = myApplication.characterRepository.save(ce);

		PublisherEntity pe = new PublisherEntity();
		pe.setName("EA");
		pe.setCountry("Amerikaaa");
		pe.setEstablished(2001);

		pe = myApplication.publisherRepository.save(pe);

		ReviewEntity re = new ReviewEntity();
		re.setText("Igrica mi se ne svidja");
		re.setRating(0.0);

		re = myApplication.reviewRepository.save(re);

		GameEntity ge = new GameEntity();
		ge.setAbout("Dosadna igrica");
		ge.setRate(2.1);
		ge.setTitle("GTA V");
		ge.setPublisher(pe);
		ge.setCharacters(new ArrayList<>(Arrays.asList(ce)));
		ge.setReview(re);
		ge = myApplication.gameRepository.save(ge);
		ce.setGames(new ArrayList<>(Arrays.asList(ge)));
		ce = myApplication.characterRepository.save(ce);
	}
}
