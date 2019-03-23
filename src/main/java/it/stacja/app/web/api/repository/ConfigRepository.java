package it.stacja.app.web.api.repository;

import it.stacja.app.web.api.domain.Config;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigRepository extends MongoRepository<Config, String> {
}
