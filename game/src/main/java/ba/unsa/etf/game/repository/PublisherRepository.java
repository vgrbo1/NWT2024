package ba.unsa.etf.game.repository;

import ba.unsa.etf.game.entity.PublisherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublisherRepository extends CrudRepository<PublisherEntity, UUID> {
}
