package ba.unsa.etf.game.repository;

import ba.unsa.etf.game.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GameRepository extends CrudRepository<GameEntity, UUID> {
}
