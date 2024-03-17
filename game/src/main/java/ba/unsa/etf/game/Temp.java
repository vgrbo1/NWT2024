package ba.unsa.etf.game;

import ba.unsa.etf.game.entity.CharacterEntity;
import ba.unsa.etf.game.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class Temp {

    private final CharacterRepository characterRepository;

    @Autowired
    public Temp(final CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public void insertInto() {
        CharacterEntity ce = new CharacterEntity();
        ce.setName("Neki lik");
        ce.setAbout("Los karakter");
        ce.setYearReleased(2013);
        characterRepository.save(ce);
    }

}
